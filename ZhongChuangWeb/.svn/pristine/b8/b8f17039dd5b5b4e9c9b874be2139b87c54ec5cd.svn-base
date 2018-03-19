/**
 * 
 */
var userNoFlag = false;
var passwordFlag = false;
var NewpasswordFlag = false;
var setEmailFlag = false;
var verifyCodeFlag = false;
var XMLHttpReq;
var url;
	
function submitadminlogin() {
	check_adminNewpassword();
	check_adminpassword();
	check_adminuserNo();
	check_verifyCode();
	check_Email();
	if(userNoFlag  && passwordFlag && verifyCodeFlag && NewpasswordFlag && setEmailFlag) {
		$("#changePasswodForm").submit();
	}
}
	
function check_adminuserNo() {
	if($("#adminuserNo").val() == "" || $("#adminuserNo").val() == null) {
		userNoFlag = false;
		$("#inputadminUserNo").attr("class", "form-group has-error has-feedback");
		$("#adminuserNoSuccess").css("visibility", "hidden");
		$("#adminuserNoError").css("visibility", "");
		$("#adminuserNoMessage").text("账号不能为空！");
	} else {
		if($("#adminuserNo").val()!= "admin") {
			userNoFlag = false;
			$("#inputadminUserNo").attr("class", "form-group has-error has-feedback");
			$("#adminuserNoSuccess").css("visibility", "hidden");
			$("#adminuserNoError").css("visibility", "");
			$("#adminuserNoMessage").text("账号不正确！");
		} 
		else {
			userNoFlag = true;
			$("#inputadminUserNo").attr("class", "form-group has-success has-feedback");
			$("#adminuserNoSuccess").css("visibility", "");
			$("#adminuserNoError").css("visibility", "hidden");
			$("#adminuserNoMessage").text("");
		}
	}
}
	

	
function check_adminpassword() {
	if($("#adminpassword").val() == "" || $("#adminpassword").val() == null) {
		passwordFlag = false;
		$("#inputadminPassword").attr("class", "form-group has-error has-feedback");
		$("#adminpasswordSuccess").css("visibility", "hidden");
		$("#adminpasswordError").css("visibility", "");
		$("#adminpasswordMessage").text("密码不能为空！");
	} else {
		createXMLHttpRequest();
		//var url = $("#base").val() + "/servlet/TestVerifyCodeServlet?code=" + $("#verifyCode").val();
		url = $("#base").val() + "/servlet/TestAdminPasswordServlet";
		//XMLHttpReq.open("GET", url, true);
		XMLHttpReq.open("POST", url, true);
		XMLHttpReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		XMLHttpReq.onreadystatechange = function testPasswordServletResponse() {
			if(XMLHttpReq.readyState == 4 && (XMLHttpReq.status == 200 || XMLHttpReq.status == 304)) {
				if(XMLHttpReq.responseText == 0) {
				//if(json_parse(XMLHttpReq.responseText)[0] == true) {	
				
					passwordFlag = true;
					$("#inputadminPassword").attr("class", "form-group has-success has-feedback");
					$("#adminpasswordSuccess").css("visibility", "");
					$("#adminpasswordError").css("visibility", "hidden");
					$("#adminpasswordMessage").text("");
				}else if(XMLHttpReq.responseText == 1) {
					//} else if(json_parse(XMLHttpReq.responseText)[0] == false) {
					passwordFlag = false;
					$("#inputadminPassword").attr("class", "form-group has-error has-feedback");
					$("#adminpasswordSuccess").css("visibility", "hidden");
					$("#adminpasswordError").css("visibility", "");
					$("#adminpasswordMessage").text("密码错误");
				}
			}
		}
		XMLHttpReq.send("adminpassword=" + $("#adminpassword").val());
	}
}

function check_adminNewpassword() {
	if($("#adminNewpassword").val() == "" || $("#adminNewpassword").val() == null) {
		NewpasswordFlag = false;
		$("#inputadminNewPassword").attr("class", "form-group has-error has-feedback");
		$("#adminNewpasswordSuccess").css("visibility", "hidden");
		$("#adminNewpasswordError").css("visibility", "");
		$("#adminNewpasswordMessage").text("密码不能为空！");
	} else {
		NewpasswordFlag = true;
		$("#inputadminNewPassword").attr("class", "form-group has-success has-feedback");
		$("#adminNewpasswordSuccess").css("visibility", "");
		$("#adminNewpasswordError").css("visibility", "hidden");
		$("#adminNewpasswordMessage").text("");
	}
}
function check_Email(){
	
	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; //验证邮箱的正则表达式
	if($("#setEmail").val() == "" || $("#setEmail").val() == null) {
		setEmailFlag = false;
		$("#inputsetEmail").attr("class", "form-group has-error has-feedback");
		$("#setEmailSuccess").css("visibility", "hidden");
		$("#setEmailError").css("visibility", "");
		$("#setEmailMessage").text("项目负责人邮箱不能为空！");
	} else {
		if(!reg.test($("#setEmail").val())){
			//alert("邮箱格式不对");
			setEmailFlag = false;
			$("#inputsetEmail").attr("class", "form-group has-error has-feedback");
			$("#setEmailSuccess").css("visibility", "hidden");
			$("#setEmailError").css("visibility", "");
			$("#setEmailMessage").text("项目负责人邮箱格式不正确！");
			
		}else{
			setEmailFlag = true;
		$("#inputsetEmail").attr("class", "form-group has-success has-feedback");
		$("#setEmailSuccess").css("visibility", "");
		$("#setEmailError").css("visibility", "hidden");
		$("#setEmailMessage").text("");
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