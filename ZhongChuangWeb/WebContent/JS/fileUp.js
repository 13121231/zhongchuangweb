/**
 * 
 */


var ProgramNameFlag = false;
var userNoFlag = false;
var ProgramWordFlag=false;

function submitUI1() {
	check_ProgramName();
	
	check_ProgramWord();
	
	if(ProgramNameFlag   && ProgramWordFlag)  {
		$("#fileUpForm").submit();
	}
}

/*function check_userNo() {
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
						userNoFlag = true;
						$("#inputUserNo").attr("class", "form-group has-success has-feedback");
						$("#userNoSuccess").css("visibility", "");
						$("#userNoError").css("visibility", "hidden");
						$("#userNoMessage").text("");
	}
}
}*/
function check_ProgramName() {
	if($("#ProgramName").val() == "" || $("#ProgramName").val() == null) {
		ProgramNameFlag = false;
		$("#inputProgramName").attr("class", "form-group has-error has-feedback");
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


function check_ProgramWord( ){
	
	var filepath = $("input[name='ProgramWord']").val();
    var extStart = filepath.lastIndexOf(".");//获取后缀名位置
    var ext = filepath.substring(extStart, filepath.length).toUpperCase();//提取后缀名 不区分大小写
    
    if (ext != ".DOC" && ext != ".DOCX")
    	{
    	ProgramWordFlag=false;
   
    	$("#inputProgramWord").attr("class", "form-group has-error has-feedback");
		$("#ProgramWordSuccess").css("visibility", "hidden");
		$("#ProgramWordError").css("visibility", "");
		$("#ProgramWordMessage").text("");
    	}
    else {
    	ProgramWordFlag=true;
    	
    	$("#inputProgramWord").attr("class", "form-group has-success has-feedback");
		$("#ProgramWordSuccess").css("visibility", "");
		$("#ProgramWordError").css("visibility", "hidden");
		$("#ProgramWordMessage").text("");
    	
    }
	
	
}
function upFile(obj){
	var tds=$(obj).parent().parent().find('td');
	$('#ProgramName').val(tds.eq(1).text());
	$('#myModal').modal('show');	
}
	

