/**
 * 
 */

//var ProgramNameFlag = false;
//var ProgramNoFlag = false;
//var ProgramUserNameFlag = false;
//var ProgramMobileNumberFlag = false;
//var ProgramEmailFlag=false;
var verifyCodeFlag = false;
var ProgramWordFlag=false;
var ProgramWordPrictureFlag=false;
var XMLHttpReq;
var url;
	
function submitUI2() {
	//check_ProgramName();
	//check_ProgramNo();
	//check_ProgramUserName();
	//check_ProgramMobileNumber();
	check_verifyCode();
	check_ProgramWord();
	check_ProgramWordPricture( );
	//check_ProgramEmail();
	if(verifyCodeFlag &&  ProgramWordPrictureFlag && ProgramWordFlag )  {
		$("#UI2Form").submit();
	}
}
	
function check_ProgramName() {
	if($("#programName").val() == "" || $("#programName").val() == null) {
		ProgramNameFlag = false;
		$("#inputProgramName").attr("class","form-group has-error has-feedback");
		$("#ProgramNameSuccess").css("visibility", "hidden");
		$("#ProgramNameError").css("visibility", "");
		$("#ProgramNameMessage").text("项目名称不能为空！");
	} else {
			ProgramNameFlag = true;
			$("#inputProgramName").attr("class", "form-group has-success has-feedback");
			$("#ProgramNameSuccess").css("visibility", "");
			$("#ProgramNameError").css("visibility", "hidden");
			$("#ProgramNameMessage").text("");
		} 
}

function check_ProgramNo() {
	if($("#programNo").val() == "" || $("#programNo").val() == null) {
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
		

	
	
function check_ProgramUserName() {
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
function check_ProgramWord( ){
	
	var filepath = $("input[name='ProgramWord']").val();
    var extStart = filepath.lastIndexOf(".");//获取后缀名位置
    var ext = filepath.substring(extStart, filepath.length).toUpperCase();//提取后缀名 不区分大小写
    if (ext != ".XLS" && ext != ".XLSX")
    	{
    	ProgramWordFlag=false;
    	//alert("上传文件只能为xls或者xlsx");
    	$("#inputProgramWord").attr("class", "form-group has-error has-feedback");
		$("#ProgramWordSuccess").css("visibility", "hidden");
		$("#ProgramWordError").css("visibility", "");
		$("#ProgramWordMessage").text("上传文件只能为xls或者xlsx");
    	}
    else {
    	ProgramWordFlag=true;
    	//alert("上传文件格式正确");
    	$("#inputProgramWord").attr("class", "form-group has-success has-feedback");
		$("#ProgramWordSuccess").css("visibility", "");
		$("#ProgramWordError").css("visibility", "hidden");
		$("#ProgramWordMessage").text("");
    	
    }
	
	
}
function check_ProgramWordPricture( ){
	
	var filepath = $("input[name='ProgramPicture']").val();
    var extStart = filepath.lastIndexOf(".");//获取后缀名位置
    var ext = filepath.substring(extStart, filepath.length).toUpperCase();//提取后缀名 不区分大小写
    if (ext != ".JPG" && ext != ".BMP")
    	{
    	ProgramWordPrictureFlag=false;
    	//alert("上传图片只能为jpg或者bmp");
    	$("#inputProgramPicture").attr("class", "form-group has-error has-feedback");
		$("#ProgramPictureSuccess").css("visibility", "hidden");
		$("#ProgramPictureError").css("visibility", "");
		$("#ProgramPictureMessage").text("上传文件只能为bmp或者jpg");
    	}
    else {
    	ProgramWordPrictureFlag=true;
    	//alert("上传文件格式正确");
    	$("#inputProgramPicture").attr("class", "form-group has-success has-feedback");
		$("#ProgramPictureSuccess").css("visibility", "");
		$("#ProgramPictureError").css("visibility", "hidden");
		$("#ProgramPictureMessage").text("");
    	
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