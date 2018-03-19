/**
 * 
 */
var userNoFlag = false;
var passwordFlag = false;
var NewpasswordFlag = false;
var verifyCodeFlag = false;
var XMLHttpReq;
var url;
	
function submitlogin() {
	check_Newpassword();
	check_password();
	check_userNo();
	check_verifyCode();
	if(userNoFlag  && passwordFlag && verifyCodeFlag && NewpasswordFlag ) {
		$("#changeUserPasswordForm").submit();
	}
}
	
function check_userNo() {
	if($("#userNo").val() == "" || $("#userNo").val() == null) {
		userNoFlag = false;
		$("#inputUserNo").attr("class", "form-group has-error has-feedback");
		$("#userNoSuccess").css("visibility", "hidden");
		$("#userNoError").css("visibility", "");
		$("#userNoMessage").text("学号不能为空！");
	} else {
		if($("#userNo").val().length != 10) {
			userNoFlag = false;
			$("#inputUserNo").attr("class", "form-group has-error has-feedback");
			$("#userNoSuccess").css("visibility", "hidden");
			$("#userNoError").css("visibility", "");
			$("#userNoMessage").text("学号长度不对！");
		} else {
			var XMLHttpReqForUserNo = null;
			if(window.XMLHttpRequest) {
				//DOM2浏览器
				XMLHttpReqForUserNo = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				//使用json语法创建数组
				var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
				for(var i = 0; i < MSXML.length; i++) {
					try{
						XMLHttpReqForUserNo = new ActiveXObject(MSXML[i]);
					} catch(e) {
						
					}
				}
			}
			//createXMLHttpRequest();
			url = $("#base").val() + "/servlet/TestStudentNoServlet";
			XMLHttpReqForUserNo.open("POST", url, true);
			XMLHttpReqForUserNo.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			XMLHttpReqForUserNo.onreadystatechange = function testStudentNoServletResponse() {
				//alert(1);
				if(XMLHttpReqForUserNo.readyState == 4 && (XMLHttpReqForUserNo.status == 200 || XMLHttpReqForUserNo.status == 304)) {
					//alert(json_parse(XMLHttpReq.responseText));
					//alert(XMLHttpReq.responseText);
					if(XMLHttpReqForUserNo.responseText == 0) {
					//if(json_parse(XMLHttpReq.responseText)[0] == true) {
						userNoFlag = true;
						$("#inputUserNo").attr("class", "form-group has-success has-feedback");
						$("#userNoSuccess").css("visibility", "");
						$("#userNoError").css("visibility", "hidden");
						$("#userNoMessage").text("");
					} else if(XMLHttpReqForUserNo.responseText == 1) {
					//} else if(json_parse(XMLHttpReq.responseText)[0] == false) {
						userNoFlag = false;
						$("#inputUserNo").attr("class", "form-group has-error has-feedback");
						$("#userNoSuccess").css("visibility", "hidden");
						$("#userNoError").css("visibility", "");
						$("#userNoMessage").text("该学号不存在");
					}
				}
			}
			XMLHttpReqForUserNo.send("studentNo=" + $("#userNo").val());
		//	XMLHttpReqForUserNo.send("password="+$("#password").val());
		}
	}
}
	

	
function check_password() {
	if($("#password").val() == "" || $("#password").val() == null) {
		passwordFlag = false;
		$("#inputPassword").attr("class", "form-group has-error has-feedback");
		$("#passwordSuccess").css("visibility", "hidden");
		$("#passwordError").css("visibility", "");
		$("#passwordMessage").text("密码不能为空！");
	} else {
		var XMLHttpReqForPassword = null;
		if(window.XMLHttpRequest) {
			//DOM2浏览器
			XMLHttpReqForPassword = new XMLHttpRequest();
		} else if(window.ActiveXObject) {
			//使用json语法创建数组
			var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
			for(var i = 0; i < MSXML.length; i++) {
				try{
					XMLHttpReqForPassword = new ActiveXObject(MSXML[i]);
				} catch(e) {
					
				}
			}
		}
		url = $("#base").val() + "/servlet/TestUserPasswordServlet";
	//	var url = $("#base").val() + "/servlet/TestUserPasswordServlet";
		XMLHttpReqForPassword.open("POST", url, true);
		XMLHttpReqForPassword.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		XMLHttpReqForPassword.onreadystatechange = function testUserPasswordServletResponse(){
			if(XMLHttpReqForPassword.readyState == 4 && (XMLHttpReqForPassword.status == 200 || XMLHttpReqForPassword.status == 304)) {	
				if(XMLHttpReqForPassword.responseText == 1) {
					passwordFlag = true;
					$("#inputPassword").attr("class", "form-group has-success has-feedback");
					$("#passwordSuccess").css("visibility", "");
					$("#passwordError").css("visibility", "hidden");
					$("#passwordMessage").text("");
				}else if(XMLHttpReqForPassword.responseText == 0){
					passwordFlag = false;
					$("#inputPassword").attr("class", "form-group has-error has-feedback");
					$("#passwordSuccess").css("visibility", "hidden");
					$("#passwordError").css("visibility", "");
					$("#passwordMessage").text("密码错误");
				}
			}
			
		}
		XMLHttpReqForPassword.send("userNo="+$("#userNo").val()+"&password="+$("#password").val());
		/*XMLHttpReqForPassword.send("studentNo="+$("#userNo").val());
		XMLHttpReqForPassword.send("password="+$("#password").val());*/
	}
}
	
function check_verifyCode() {
	if($("#verifyCode").val() == "" || $("#verifyCode").val() == null) {
		verifyCodeFlag = false;
		$("#inputVerifyCode").attr("class", "form-group has-error has-feedback");
		$("#verifyCodeSuccess").css("visibility", "hidden");
		$("#verifyCodeError").css("visibility", "");
		$("#verifyCodeMessage").text("验证码不能为空！");
	} else {
		createXMLHttpRequest();
		//var url = $("#base").val() + "/servlet/TestVerifyCodeServlet?code=" + $("#verifyCode").val();
		url = $("#base").val() + "/servlet/TestVerifyCodeServlet";
		//XMLHttpReq.open("GET", url, true);
		XMLHttpReq.open("POST", url, true);
		XMLHttpReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		XMLHttpReq.onreadystatechange = function testVerifyCodeServletResponse() {
			if(XMLHttpReq.readyState == 4 && (XMLHttpReq.status == 200 || XMLHttpReq.status == 304)) {
				
				if(XMLHttpReq.responseText == 1) {
				//if(json_parse(XMLHttpReq.responseText) == "true") {
					verifyCodeFlag = true;
					$("#inputVerifyCode").attr("class", "form-group has-success has-feedback");
					$("#verifyCodeSuccess").css("visibility", "");
					$("#verifyCodeError").css("visibility", "hidden");
					$("#verifyCodeMessage").text("");
				} else if(XMLHttpReq.responseText == 0) {
				//} else if(json_parse(XMLHttpReq.responseText) == "false") {
					verifyCodeFlag = false;
					$("#inputVerifyCode").attr("class", "form-group has-error has-feedback");
					$("#verifyCodeSuccess").css("visibility", "hidden");
					$("#verifyCodeError").css("visibility", "");
					$("#verifyCodeMessage").text("验证码不正确！");
				}
			}
		}
		
		//alert(code);
		//XMLHttpReq.send(null);
		XMLHttpReq.send("code=" + $("#verifyCode").val());
	}
}

//创建XMLHttpRequest对象
function createXMLHttpRequest() {
	if(window.XMLHttpRequest) {
		//DOM2浏览器
		XMLHttpReq = new XMLHttpRequest();
	} else if(window.ActiveXObject) {
		//使用json语法创建数组
		var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
		for(var i = 0; i < MSXML.length; i++) {
			try{
				XMLHttpReq = new ActiveXObject(MSXML[i]);
			} catch(e) {
				
			}
		}
	}
}

function check_Newpassword() {
	if($("#Newpassword").val() == "" || $("#Newpassword").val() == null) {
		NewpasswordFlag = false;
		$("#inputNewPassword").attr("class", "form-group has-error has-feedback");
		$("#NewpasswordSuccess").css("visibility", "hidden");
		$("#NewpasswordError").css("visibility", "");
		$("#NewpasswordMessage").text("密码不能为空！");
	} else {
		NewpasswordFlag = true;
		$("#inputNewPassword").attr("class", "form-group has-success has-feedback");
		$("#NewpasswordSuccess").css("visibility", "");
		$("#NewpasswordError").css("visibility", "hidden");
		$("#NewpasswordMessage").text("");
	}
}
