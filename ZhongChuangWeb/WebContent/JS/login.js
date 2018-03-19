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
	
function submitlogin() {
	check_userNo();
	check_password();
	check_verifyCode();
	if(userNoFlag  && passwordFlag && verifyCodeFlag) {
		$("#LoginForm").submit();
	}
}
	
function check_userNo() {
	var reg=/^\d{10}$/;
	if($("#userNo").val() == "" || $("#userNo").val() == null) {
		$("#userNo").popover('destroy');
		$(function () {
			$("#userNo").popover({
						delay: {show: 1000, hide: 1000},
						html:true,
						content:"<p style='color:red'>学号不能为空</p>"
			});});
		$("#userNo").popover('show');
		userNoFlag = false;
		$("#inputUserNo").attr("class", "input-group has-error has-feedback");
		$("#userNoSuccess").css("visibility", "hidden");
		$("#userNoError").css("visibility", "");
		$("#userNoMessage").text("学号不能为空！");
	} else {
		
		if(!reg.test($("#userNo").val())) {
			$("#userNo").popover('destroy');
			$(function () {	
				$("#userNo").popover({
							html:true,
							content:"<p style='color:red'>您输入的学号长度不是10位数字</p>"
				});});
			$("#userNo").popover('show');
			$("#userNo").popover('show');
			userNoFlag = false;
			$("#inputUserNo").attr("class", "input-group has-error has-feedback");
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
						$("#userNo").popover('destroy');
						$("#inputUserNo").attr("class", "input-group has-success has-feedback");
						$("#userNoSuccess").css("visibility", "");
						$("#userNoError").css("visibility", "hidden");
						$("#userNoMessage").text("");
					} else if(XMLHttpReqForUserNo.responseText == 1) {
					//} else if(json_parse(XMLHttpReq.responseText)[0] == false) {
						$("#userNo").popover('destroy');
						$(function () {
							$("#userNo").popover({
										html:true,
										content:"<p style='color:red'>学号未注册</p>"
							});});
						$("#userNo").popover('show');
						userNoFlag = false;
						$("#inputUserNo").attr("class", "input-group has-error has-feedback");
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
/*function tip_userNo() {
	if($("#userNo").val() == "" || $("#userNo").val() == null) {
		$("#userNo").popover('destroy');
		$(function () {
			$("#userNo").popover({
						delay: {show: 1000, hide: 1000},
						html:true,
						content:"<p style='color:DeepSkyBlue'>:)请输入10位学号</p>"
			});});
		$("#userNo").popover('show');
		userNoFlag = false;
	} else {
		if($("#userNo").val().length != 10) {
			$("#userNo").popover('destroy');
			$(function () {
				$("#userNo").popover({
							html:true,
							content:"<p style='color:red'>学号长度不正确</p>"
				});});
			$("#userNo").popover('show');
			$("#userNo").popover('show');
			userNoFlag = false;
			$("#inputUserNo").attr("class", "input-group has-error has-feedback");
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
						$("#userNo").popover('destroy');
						$("#inputUserNo").attr("class", "input-group has-success has-feedback");
						$("#userNoSuccess").css("visibility", "");
						$("#userNoError").css("visibility", "hidden");
						$("#userNoMessage").text("");
					} else if(XMLHttpReqForUserNo.responseText == 1) {
					//} else if(json_parse(XMLHttpReq.responseText)[0] == false) {
						$("#userNo").popover('destroy');
						$(function () {
							$("#userNo").popover({
										html:true,
										content:"<p style='color:red'>学号未注册</p>"
							});});
						$("#userNo").popover('show');
						userNoFlag = false;
						$("#inputUserNo").attr("class", "input-group has-error has-feedback");
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

	
	*/
function check_password() {
	if($("#password").val() == "" || $("#password").val() == null) {
		passwordFlag = false;
		$("#password").popover('destroy');
		$("#password").popover({
			html:true,
			content:"<p style='color:red'>密码不能为空</p>"
		});
		$("#password").popover('show');
		$("#inputPassword").attr("class", "input-group has-error has-feedback");
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
					$("#password").popover('destroy');
					passwordFlag = true;
					$("#inputPassword").attr("class", "input-group has-success has-feedback");
					$("#passwordSuccess").css("visibility", "");
					$("#passwordError").css("visibility", "hidden");
					$("#passwordMessage").text("");
				}else if(XMLHttpReqForPassword.responseText == 0){
					$("#password").popover('destroy');
					$("#password").popover({
						html:true,
						content:"<p style='color:red'>密码不正确</p>",
					});
					$("#password").popover('show');
					passwordFlag = false;
					$("#inputPassword").attr("class", "input-group has-error has-feedback");
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

function tip_password() {
	if($("#password").val() == "" || $("#password").val() == null) {
		passwordFlag = false;
		$("#password").popover('destroy');
		$("#password").popover({
			html:true,
			content:"<p style='color:DeepSkyBlue'>:)请输入对应账号密码</p>"	
		});
		$("#inputPassword").attr("class", "input-group");
		$("#password").popover('show');
		$("#passwordSuccess").css("visibility", "hidden");
		$("#passwordError").css("visibility", "hidden");
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
					$("#password").popover('destroy');
					passwordFlag = true;
					$("#inputPassword").attr("class", "input-group has-success has-feedback");
					$("#passwordSuccess").css("visibility", "");
					$("#passwordError").css("visibility", "hidden");
					$("#passwordMessage").text("");
				}else if(XMLHttpReqForPassword.responseText == 0){
					$("#password").popover('destroy');
					$("#password").popover({
						html:true,
						content:"<p style='color:red'>密码不正确</p>",
					});
					$("#password").popover('show');
					passwordFlag = false;
					$("#inputPassword").attr("class", "input-group has-error has-feedback");
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
		
		//var url = $("#base").val() + "/servlet/TestVerifyCodeServlet?code=" + $("#verifyCode").val();
		url = $("base").attr("href") + "/servlet/TestVerifyCodeServlet";
		//alert(url);
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

//创建XMLHttpRequest对象
/*function createXMLHttpRequest() {
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
