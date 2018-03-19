
var ProgramNameFlag = false;
var ProgramNoFlag = false;
//var ProgramUserNameFlag = false;
var ProgramTypeFlag =false;
var ProgramMobileNumberFlag = false;
var verifyCodeFlag = false;
var ProgramWordFlag=false;
var ProgramEmailFlag=false;
var XMLHttpReq;
var url;

function submitUI1() {
	check_ProgramName();
	//check_ProgramNo();
	//check_ProgramUserName();
	check_ProgramMobileNumber();
	check_verifyCode();
	//check_ProgramWord();
	check_ProgramEmail();
	check_ProgramType();
	if(ProgramNameFlag   && verifyCodeFlag &&ProgramTypeFlag  && ProgramMobileNumberFlag  && ProgramEmailFlag)  {
		$("#UI1Form").submit();
	}
}
	
function check_ProgramName() {
	if($("#ProgramName").val() == "" || $("#ProgramName").val() == null) {
		ProgramNameFlag = false;
		$("#inputProgramName").attr("class", "form-group has-error has-feedback");
		$("#ProgramNameSuccess").css("visibility", "hidden");
		$("#ProgramNameError").css("visibility", "");
		$("#ProgramNameMessage").text("项目名称不能为空！");
		//alert(5);
	} else {
		var XMLHttpReqForProgramName = null;
		if(window.XMLHttpRequest) {
			//DOM2浏览器
			XMLHttpReqForProgramName = new XMLHttpRequest();
		} else if(window.ActiveXObject) {
			//使用json语法创建数组
			var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
			for(var i = 0; i < MSXML.length; i++) {
				try{
					XMLHttpReqForProgramName = new ActiveXObject(MSXML[i]);
				} catch(e) {
					
				}
			}
		}
		//createXMLHttpRequest();
		url = $("#base").val() + "/servlet/TestProgramNameServlet";
		XMLHttpReqForProgramName.open("POST", url, true);
		XMLHttpReqForProgramName.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		XMLHttpReqForProgramName.onreadystatechange = function testProgramServletResponse() {
		//alert(1);
			if(XMLHttpReqForProgramName.readyState == 4 && (XMLHttpReqForProgramName.status == 200 || XMLHttpReqForProgramName.status == 304)) {
				//alert(2);
				//alert(json_parse(XMLHttpReq.responseText));
				//alert(XMLHttpReq.responseText);
				if(XMLHttpReqForProgramName.responseText == 1) {
				//if(json_parse(XMLHttpReq.responseText)[0] == true) {
					ProgramNameFlag = true;
					$("#inputProgramName").attr("class", "form-group has-success has-feedback");
					$("#ProgramNameSuccess").css("visibility", "");
					$("#ProgramNameError").css("visibility", "hidden");
					$("#ProgramNameMessage").text("");
				} else if(XMLHttpReqForProgramName.responseText == 0) {
					//alert(3);
				//} else if(json_parse(XMLHttpReq.responseText)[0] == false) {
					ProgramNameFlag = false;
					$("#inputProgramName").attr("class", "form-group has-error has-feedback");
					$("#ProgramNameSuccess").css("visibility", "hidden");
					$("#ProgramNameError").css("visibility", "");
					$("#ProgramNameMessage").text("该项目您已经注册了！");
				}
			}
		}
		XMLHttpReqForProgramName.send("programName=" + $("#ProgramName").val());
			/*ProgramNameFlag = true;
			$("#inputProgramName").attr("class", "form-group has-success has-feedback");
			$("#ProgramNameSuccess").css("visibility", "");
			$("#ProgramNameError").css("visibility", "hidden");
			$("#ProgramNameMessage").text("");*/
		} 
}

/*function check_ProgramNo() {
	if($("#ProgramNo").val() == "" || $("#ProgramNo").val() == null) {
		ProgramNoFlag = false;
		$("#inputProgramNo").attr("class", "form-group has-error has-feedback");
		$("#ProgramNoSuccess").css("visibility", "hidden");
		$("#ProgramNoError").css("visibility", "");
		$("#ProgramNoMessage").text("项目编号不能为空！");
	} else {
			ProgramNoFlag = true;
			$("#inputProgramNo").attr("class", "form-group has-success has-feedback");
			$("#ProgramNoSuccess").css("visibility", "");
			$("#ProgramNoError").css("visibility", "hidden");
			$("#ProgramNoMessage").text("");
		} 
}
		*/

	
	
/*function check_ProgramUserName() {
	if($("#ProgramUserName").val() == "" || $("#ProgramUserName").val() == null) {
		ProgramUserNameFlag = false;
		$("#inputProgramUserName").attr("class", "form-group has-error has-feedback");
		$("#ProgramUserNameSuccess").css("visibility", "hidden");
		$("#ProgramUserNameError").css("visibility", "");
		$("#ProgramUserNameMessage").text("项目负责人不能为空！");
	} else {
		ProgramUserNameFlag = true;
		$("#inputProgramUserName").attr("class", "form-group has-success has-feedback");
		$("#ProgramUserNameSuccess").css("visibility", "");
		$("#ProgramUserNameError").css("visibility", "hidden");
		$("#ProgramUserNameMessage").text("");
	}
}*/
function chose_check1()
{
	if($("#ProgramType1").val() == "" || $("#ProgramType1").val() == null) {
		$("#ProgramType1").val("A");
		$("#ProgramType2").val("");
		$("#ProgramType3").val("");
		}
}
function chose_check2()
{
	if($("#ProgramType2").val() == "" || $("#ProgramType2").val() == null) {
		$("#ProgramType2").val("B");
		$("#ProgramType1").val("");
		$("#ProgramType3").val("");
		}
}
function chose_check3()
{
	if($("#ProgramType3").val() == "" || $("#ProgramType3").val() == null) {
		$("#ProgramType3").val("C");
		$("#ProgramType1").val("");
		$("#ProgramType2").val("");
		}

}

function downloadtest(id){
	var url = "<%=request.getContextPath()%>/app/download" + "/" + id;
	$("#pluginurl").attr("href",url);
	}
function check_ProgramType(){
	if($("#ProgramType1").val() == "" && $("#ProgramType2").val() == "" && $("#ProgramType3").val() == "") {
		ProgramTypeFlag = false;
		$("#inputProgramType").attr("class", "form-group has-error has-feedback");
		$("#ProgramTypeSuccess").css("visibility", "hidden");
		$("#ProgramTypeError").css("visibility", "");
		$("#ProgramTypeMessage").text("项目编号不能为空！");
	} else {
		ProgramTypeFlag = true;
		$("#inputProgramType").attr("class", "form-group has-success has-feedback");
		$("#ProgramTypeSuccess").css("visibility", "");
		$("#ProgramTypeError").css("visibility", "hidden");
		$("#ProgramTypeMessage").text("");
	}
}

function check_ProgramMobileNumber() {
	if($("#ProgramMobileNumber").val() == "" || $("#ProgramMobileNumber").val() == null) {
		ProgramMobileNumberFlag = false;
		$("#inputProgramMobileNumber").attr("class", "form-group has-error has-feedback");
		$("#ProgramMobileNumberSuccess").css("visibility", "hidden");
		$("#ProgramMobileNumberError").css("visibility", "");
		$("#ProgramMobileNumberMessage").text("项目负责人手机号码不能为空！");
	} else {
		if($("#ProgramMobileNumber").val().length != 11) {
			ProgramMobileNumberFlag = false;
			$("#inputProgramMobileNumber").attr("class", "form-group has-error has-feedback");
			$("#ProgramMobileNumberSuccess").css("visibility", "hidden");
			$("#ProgramMobileNumberError").css("visibility", "");
			$("#ProgramMobileNumberMessage").text("项目扶着人手机号码长度不对！");
		}
		else{
		ProgramMobileNumberFlag = true;
		$("#inputProgramMobileNumber").attr("class", "form-group has-success has-feedback");
		$("#ProgramMobileNumberSuccess").css("visibility", "");
		$("#ProgramMobileNumberError").css("visibility", "hidden");
		$("#ProgramMobileNumberMessage").text("");
		}
	}
}
function check_ProgramEmail(){
	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; //验证邮箱的正则表达式
	if($("#ProgramEmail").val() == "" || $("#ProgramEmail").val() == null) {
		ProgramEmailFlag = false;
		$("#inputProgramEmail").attr("class", "form-group has-error has-feedback");
		$("#ProgramEmailSuccess").css("visibility", "hidden");
		$("#ProgramEmailError").css("visibility", "");
		$("#ProgramEmailMessage").text("项目负责人邮箱不能为空！");
	} else {
		if(!reg.test($("#ProgramEmail").val())){
			//alert("邮箱格式不对");
			ProgramEmailFlag = false;
			$("#inputProgramEmail").attr("class", "form-group has-error has-feedback");
			$("#ProgramEmailSuccess").css("visibility", "hidden");
			$("#ProgramEmailError").css("visibility", "");
			$("#ProgramEmailMessage").text("项目负责人邮箱不正确！");
			
		}else{
		ProgramEmailFlag = true;
		$("#inputProgramEmail").attr("class", "form-group has-success has-feedback");
		$("#ProgramEmailSuccess").css("visibility", "");
		$("#ProgramEmailError").css("visibility", "hidden");
		$("#ProgramEmailMessage").text("");
	}
	}
}
/*function check_ProgramWord( ){
	
	var filepath = $("input[name='ProgramWord']").val();
    var extStart = filepath.lastIndexOf(".");//获取后缀名位置
    var ext = filepath.substring(extStart, filepath.length).toUpperCase();//提取后缀名 不区分大小写
    
    if (ext != ".DOC" && ext != ".DOCX")
    	{
    	ProgramWordFlag=false;
   
    	$("#inputProgramWord").attr("class", "form-group has-error has-feedback");
		$("#ProgramWordSuccess").css("visibility", "hidden");
		$("#ProgramWordError").css("visibility", "");
		$("#ProgramWordMessage").text("上传文件只能为DOC或者DOCX");
    	}
    else {
    	ProgramWordFlag=true;
    	
    	$("#inputProgramWord").attr("class", "form-group has-success has-feedback");
		$("#ProgramWordSuccess").css("visibility", "");
		$("#ProgramWordError").css("visibility", "hidden");
		$("#ProgramWordMessage").text("");
    	
    }
	
	
}*/

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