/**
 * 
 */
var expenseFileFlag =false;
var inputUserNoFlag = false;
var XMLHttpReq=null;
function expenseUp(){
	
	check_ProgramBill();
	if(expenseFileFlag){
		
		$("#ExcelUpForm").submit();
	}
}
function queryUserNoSubmit(){
	
	check_inputQueryUserNo();
	if(inputUserNoFlag){
		$("#inputQueryUserNoForm").submit();
	}
}
function check_ProgramBill(){
	var filepath = $("input[name='ProjectBill']").val();
    var extStart = filepath.lastIndexOf(".");//获取后缀名位置
    var ext = filepath.substring(extStart, filepath.length).toUpperCase();//提取后缀名 不区分大小写
   
    if (ext != ".XLS" && ext != ".XLSX")
    	{
    	expenseFileFlag=false;
    	$("#inputProgramBill").attr("class", "form-group has-error has-feedback");
		$("#ProgramBillSuccess").css("visibility", "hidden");
		$("#ProgramBillError").css("visibility", "");
		$("#ProgramBillMessage").text("");
    	}
    else {
    	expenseFileFlag=true;
    	
    	$("#inputProgramBill").attr("class", "form-group has-success has-feedback");
		$("#ProgramBillSuccess").css("visibility", "");
		$("#ProgramBillError").css("visibility", "hidden");
		$("#ProgramBillMessage").text("");
    	
    }
	
}
function check_inputQueryUserNo(){
	var inputQueryUserNo=$("#inputQueryUserNo").val();
	if(inputQueryUserNo=="" || inputQueryUserNo==null){
		inputUserNoFlag =false;
		$("#inputQueryUserNoFrame").attr("class","input-group has-error has-feedback");
		$("#inputQueryUserNoError").css("visibility","");
		$("#inputQueryUserNoSuccess").css("visibility","hidden");
	}else{
		url=$("#base").val()+"/servlet/TestStudentNoServlet";
		createXMLHttpRequest(url);
		XMLHttpReq.onreadystatechange=function testStudentNoServletResponse(){
			if(XMLHttpReq.readyState == 4 && (XMLHttpReq.status == 200 || XMLHttpReq.status == 304)) {
				if(XMLHttpReq.responseText == 0) {
					inputUserNoFlag=true;
					$("#inputQueryUserNoFrame").attr("class","input-group has-success has-feedback")
					$("#inputQueryUserNoError").css("visibility","hidden");
					$("#inputQueryUserNoSuccess").css("visibility","");
				}
				else{
					inputUserNoFlag=false;
					$('#myModal1').modal('show');
					$("#inputQueryUserNoFrame").attr("class","input-group has-error has-feedback")
					$("#inputQueryUserNoError").css("visibility","");
					$("#inputQueryUserNoSuccess").css("visibility","hidden");
				}
			}
		}
		XMLHttpReq.send("studentNo=" + $("#inputQueryUserNo").val());
	
	}
}
//创建XMLHttpRequest对象
function createXMLHttpRequest(url) {
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
	XMLHttpReq.open("post",url,true);
	XMLHttpReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
}
