/**
 * 
 */
var userNoFlag = false;
var userNameFlag = false;
var passwordFlag = false;
var newpasswordFlag = false;
var verifyCodeFlag = false;
var XMLHttpReq;
var url;
	
function submitRegister() {
	check_userNo();
	check_userName();
	check_password();
	check_verifyCode();
	check_Newpassword();
	if(userNoFlag && userNameFlag && passwordFlag && verifyCodeFlag &&newpasswordFlag) {
		$("#registerForm").submit();
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
					if(XMLHttpReqForUserNo.responseText == 1) {
					//if(json_parse(XMLHttpReq.responseText)[0] == true) {
						userNoFlag = true;
						$("#inputUserNo").attr("class", "form-group has-success has-feedback");
						$("#userNoSuccess").css("visibility", "");
						$("#userNoError").css("visibility", "hidden");
						$("#userNoMessage").text("");
					} else if(XMLHttpReqForUserNo.responseText == 0) {
					//} else if(json_parse(XMLHttpReq.responseText)[0] == false) {
						userNoFlag = false;
						$("#inputUserNo").attr("class", "form-group has-error has-feedback");
						$("#userNoSuccess").css("visibility", "hidden");
						$("#userNoError").css("visibility", "");
						$("#userNoMessage").text("该学号已经被注册了！");
					}
				}
			}
			XMLHttpReqForUserNo.send("studentNo=" + $("#userNo").val());
		}
	}
}
	
function check_userName() {
	if($("#userName").val() == "" || $("#userName").val() == null) {
		userNameFlag = false;
		$("#inputUserName").attr("class", "form-group has-error has-feedback");
		$("#userNameSuccess").css("visibility", "hidden");
		$("#userNameError").css("visibility", "");
		$("#userNameMessage").text("姓名不能为空！");
	} else {
		userNameFlag = true;
		$("#inputUserName").attr("class", "form-group has-success has-feedback");
		$("#userNameSuccess").css("visibility", "");
		$("#userNameError").css("visibility", "hidden");
		$("#userNameMessage").text("");
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
		passwordFlag = true;
		$("#inputPassword").attr("class", "form-group has-success has-feedback");
		$("#passwordSuccess").css("visibility", "");
		$("#passwordError").css("visibility", "hidden");
		$("#passwordMessage").text("");
	}
}

function check_Newpassword() {
	if($("#Newpassword").val() == "" || $("#Newpassword").val() == null) {
		newpasswordFlag = false;
		$("#inputNewpassword").attr("class", "form-group has-error has-feedback");
		$("#NewpasswordSuccess").css("visibility", "hidden");
		$("#NewpasswordError").css("visibility", "");
		$("#NewpasswordMessage").text("密码不能为空！");
	} else {
		if($("#Newpassword").val() == $("#password").val()){
		newpasswordFlag = true;
		$("#inputNewpassword").attr("class", "form-group has-success has-feedback");
		$("#NewpasswordSuccess").css("visibility", "");
		$("#NewpasswordError").css("visibility", "hidden");
		$("#NewpasswordMessage").text("");
	} else {
		newpasswordFlag = false;
		$("#inputNewpassword").attr("class", "form-group has-error has-feedback");
		$("#NewpasswordSuccess").css("visibility", "hidden");
		$("#NewpasswordError").css("visibility", "");
		$("#NewpasswordMessage").text("密码不一致！");
	}
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
		var XMLHttpReqForVerifyCode = null;
		if(window.XMLHttpRequest) {
			//DOM2浏览器
			XMLHttpReqForVerifyCode = new XMLHttpRequest();
		} else if(window.ActiveXObject) {
			//使用json语法创建数组
			var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
			for(var i = 0; i < MSXML.length; i++) {
				try{
					XMLHttpReqForVerifyCode = new ActiveXObject(MSXML[i]);
				} catch(e) {
					
				}
			}
		}
		//createXMLHttpRequest();
		//var url = $("#base").val() + "/servlet/TestVerifyCodeServlet?code=" + $("#verifyCode").val();
		url = $("#base").val() + "/servlet/TestVerifyCodeServlet";
		//XMLHttpReq.open("GET", url, true);
		XMLHttpReqForVerifyCode.open("POST", url, true);
		XMLHttpReqForVerifyCode.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		XMLHttpReqForVerifyCode.onreadystatechange = function testVerifyCodeServletResponse() {
			if(XMLHttpReqForVerifyCode.readyState == 4 && (XMLHttpReqForVerifyCode.status == 200 || XMLHttpReqForVerifyCode.status == 304)) {
				if(XMLHttpReqForVerifyCode.responseText == 1) {
				//if(json_parse(XMLHttpReq.responseText) == "true") {
					verifyCodeFlag = true;
					$("#inputVerifyCode").attr("class", "form-group has-success has-feedback");
					$("#verifyCodeSuccess").css("visibility", "");
					$("#verifyCodeError").css("visibility", "hidden");
					$("#verifyCodeMessage").text("");
				} else if(XMLHttpReqForVerifyCode.responseText == 0) {
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
		XMLHttpReqForVerifyCode.send("code=" + $("#verifyCode").val());
	}
}

/*//创建XMLHttpRequest对象
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
}*/