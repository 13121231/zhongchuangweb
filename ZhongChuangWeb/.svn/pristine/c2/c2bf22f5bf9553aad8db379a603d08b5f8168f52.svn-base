/**
 * 
 */
/**
 * 
 */
var userNoFlag = false;
var passwordFlag = false;
var verifyCodeFlag = false;
var XMLHttpReq;
var url;
	
function submitadminlogin() {
	check_adminuserNo();
	check_adminpassword();
	check_verifyCode();
	if(userNoFlag  && passwordFlag && verifyCodeFlag) {
		$("#AdminLoginForm").submit();
	}
}
	
function check_adminuserNo() {
	$("#adminuserNo").popover('destroy');
	if($("#adminuserNo").val() == "" || $("#adminuserNo").val() == null) {
		$("#adminuserNo").popover({
			html:true,
			title:"帐号验证",
			content:"<p style='color:red'>管理员帐号不能为空</p>"
		});
		$("#adminuserNo").popover('show');
		userNoFlag = false;
		$("#inputadminUserNo").attr("class", "input-group has-error has-feedback");
		$("#adminuserNoSuccess").css("visibility", "hidden");
		$("#adminuserNoError").css("visibility", "");
		$("#adminuserNoMessage").text("账号不能为空！");
	} else {
		if($("#adminuserNo").val() != "admin") {
			userNoFlag = false;
			$("#adminuserNo").popover({
				html:true,
				title:"帐号验证",
				content:"<p style='color:red'>管理员帐号不正确</p>",	
			});
			$("#adminuserNo").popover('show');
			$("#inputadminUserNo").attr("class", "input-group has-error has-feedback");
			$("#adminuserNoSuccess").css("visibility", "hidden");
			$("#adminuserNoError").css("visibility", "");
			$("#adminuserNoMessage").text("账号不正确！");
		} 
		else {
			userNoFlag = true;
			$("#inputadminUserNo").attr("class", "input-group has-success has-feedback");
			$("#adminuserNoSuccess").css("visibility", "");
			$("#adminuserNoError").css("visibility", "hidden");
			$("#adminuserNoMessage").text("");
		}
	}
}
function tip_adminuserNo() {
	$("#adminuserNo").popover('destroy');
	if($("#adminuserNo").val() == "" || $("#adminuserNo").val() == null) {
		$("#adminuserNo").popover({
			html:true,
			content:"<p style='color:LimeGreen'>请输入管理员帐号 :)若没有修改则为admin</p>"
		});
		$("#adminuserNo").popover('show');
		userNoFlag = false;
	} else {
		if($("#adminuserNo").val() != "admin") {
			userNoFlag = false;
			$("#adminuserNo").popover({
				html:true,
				content:"<p style='color:red'>管理员帐号不正确</p>",	
			});
			$("#adminuserNo").popover('show');
			$("#inputadminUserNo").attr("class", "input-group has-error has-feedback");
			$("#adminuserNoSuccess").css("visibility", "hidden");
			$("#adminuserNoError").css("visibility", "");
			$("#adminuserNoMessage").text("账号不正确！");
		} 
		else {
			userNoFlag = true;
			$("#inputadminUserNo").attr("class", "input-group has-success has-feedback");
			$("#adminuserNoSuccess").css("visibility", "");
			$("#adminuserNoError").css("visibility", "hidden");
			$("#adminuserNoMessage").text("");
		}
	}
}
	
function check_adminpassword() {
	$("#adminpassword").popover('destroy');
	if($("#adminpassword").val() == "" || $("#adminpassword").val() == null) {
		$("#adminpassword").popover({
			html:true,
			content:"<p style='color:red'>密码不能为空</p>"
		});
		$("#adminpassword").popover('show');
		passwordFlag = false;
		$("#inputadminPassword").attr("class", "input-group has-error has-feedback");
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
					$("#inputadminPassword").attr("class", "input-group has-success has-feedback");
					$("#adminpasswordSuccess").css("visibility", "");
					$("#adminpasswordError").css("visibility", "hidden");
					$("#adminpasswordMessage").text("");
				}else if(XMLHttpReq.responseText == 1) {
					$("#adminpassword").popover({
						html:true,
						content:"<p style='color:red'>密码不正确</p>"
					});
					$("#adminpassword").popover('show');
					//} else if(json_parse(XMLHttpReq.responseText)[0] == false) {
					userNoFlag = false;
					$("#inputadminPassword").attr("class", "input-group has-error has-feedback");
					$("#adminpasswordSuccess").css("visibility", "hidden");
					$("#adminpasswordError").css("visibility", "");
					$("#adminpasswordMessage").text("密码错误");
				}
			}
		}
		XMLHttpReq.send("adminpassword=" + $("#adminpassword").val());
	}
}
function tip_adminpassword() {
	$("#adminpassword").popover('destroy');
	if($("#adminpassword").val() == "" || $("#adminpassword").val() == null) {
		$("#adminpassword").popover({
			html:true,
			content:"<p style='color:LimeGreen'>:)请输入管理员密码</p>"
		});
		$("#adminpassword").popover('show');
		passwordFlag = false;
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
					$("#inputadminPassword").attr("class", "input-group has-success has-feedback");
					$("#adminpasswordSuccess").css("visibility", "");
					$("#adminpasswordError").css("visibility", "hidden");
					$("#adminpasswordMessage").text("");
				}else if(XMLHttpReq.responseText == 1) {
					$("#adminpassword").popover({
						html:true,
						content:"<p style='color:red'>密码不正确</p>"
					});
					$("#adminpassword").popover('show');
					//} else if(json_parse(XMLHttpReq.responseText)[0] == false) {
					userNoFlag = false;
					$("#inputadminPassword").attr("class", "input-group has-error has-feedback");
					$("#adminpasswordSuccess").css("visibility", "hidden");
					$("#adminpasswordError").css("visibility", "");
					$("#adminpasswordMessage").text("密码错误");
				}
			}
		}
		XMLHttpReq.send("adminpassword=" + $("#adminpassword").val());
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