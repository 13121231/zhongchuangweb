<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户项目报销页面</title>
<link href="${pageContext.request.contextPath}/PUBLIC/bs/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/PUBLIC/JQuery/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/PUBLIC/bs/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/uiprogramexpense.js"></script>
</head>

<body>
<%String ProgramName= (String) request.getAttribute("programName"); %>
<div class="container" style="margin-top:7% ">
	<div class="row">
		<div class="col-lg-offset-1 col-lg-10">
			<div class="panel panel-default">
				<div class="panel-heading">	
				<ul class="nav nav-pills">
					  <li role="presentation"><a href="${pageContext.request.contextPath}/servlet/user/ShowUI1PageServlet"><h3 class="panel-title">项目申请</h3></a></li>
					  <li role="presentation"  class="active"><a href="${pageContext.request.contextPath}/servlet/user/ShowUI2PageServlet"><h3 class="panel-title">报销申请</h3></a></li>
					</ul>
					
					</div>	
						<div class="panel-body">
							<div class=row>
								<div class="col-lg-12">
									<form class=form-horizontal method=post action="${pageContext.request.contextPath}/servlet/user/UIExpenseServlet" id="UI2Form" role="form" enctype="multipart/form-data">	
										<div class="form-group" id="inputProgramName"> 
											<label class="control-label col-sm-4 sr-only" for="programName">项目名称</label>
											<div class="col-sm-4">
												<input type="text" class="form-control" name="programName" id="programName" placeholder="项目名称" onblur="check_ProgramName()" tabIndex="1"  value="" autofocus>
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramNameSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramNameError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramNameMessage" style="color: red; margin: 0%"></p></span>
										</div>
										<div class=form-group id="inputProgramNo">
											<label class="control-label col-sm-4 sr-only" for="ProgramNo">项目编号</label>
											<div class=col-lg-4>										
												<input class=form-control type="text" name="programNo" id="programNo" placeholder="项目编号" onblur="check_ProgramNo()" tabIndex="2">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramNoSuccess" style="visibility:hidden"></span>
		                                    	<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramNoError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramNoMessage" style="color: red; margin: 0%"></p></span>
										</div>
								<!-- <div class=form-group id="inputProgramMobileNumber">
											<label class="control-label col-sm-4 sr-only" for="ProgramMobileNumber">项目负责人手机号码</label>
											<div class=col-lg-4>										
												<input  class=form-control type="text"  name=ProgramMobileNumber  id=ProgramMobileNumber 	placeholder="项目负责人手机号码" onblur="check_ProgramMobileNumber()" tabIndex="4">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramMobileNumberSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramMobileNumberError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramMobileNumberMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
									<div class=form-group id="inputProgramEmail">
											<label class="control-label col-sm-4 sr-only" for="inputProgramEmail">项目负责人邮箱</label>
											<div class=col-lg-4>										
												<input  class=form-control tsype="text"  name=ProgramEmail  id=ProgramEmail 	placeholder="项目负责人邮箱" onblur="check_ProgramEmail()" tabIndex="4">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramEmailSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramEmailError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramEmailMessage" style="color: red; margin: 0%"></p></span>
									</div> -->
						
								<div class=form-group id="inputProgramWord">
											<label class="control-label col-sm-4 sr-only" for="ProgramWord">项目材料清单</label>
											<div class=col-lg-2>项目材料清单</div>
											<div class=col-lg-4 >										
												<input  type="file"  name=ProgramWord  id=ProgramWord 	placeholder="项目材料清单" onblur="check_ProgramWord()" tabIndex="5"></p>
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramWordSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramWordError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramWordMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
									<div class=form-group id="inputProgramPicture">
											<label class="control-label col-sm-4 sr-only" for="ProgramPicture">项目材料图片</label>
											<div class=col-lg-2>项目材料图片</div>
											<div class=col-lg-4 >										
												<input   type="file"  name=ProgramPicture  id=ProgramPicture 	placeholder="项目材料图片" onblur="check_ProgramWordPricture()" tabIndex="5">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramPictureSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramPictureError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramPictureMessage" style="color: red; margin: 0%"></p></span>
									</div>
									<div class="form-group" id="inputVerifyCode">
										<label class="control-label col-sm-4 sr-only" for="verifyCode">验证码</label>
										<div class="col-sm-2">
											<input class="form-control" type="text" name="verifyCode" id="verifyCode" placeholder="验证码" onblur="check_verifyCode()" tabIndex="6">
											<span class="glyphicon glyphicon-ok form-control-feedback" id="verifyCodeSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="verifyCodeError" style="visibility:hidden"></span>
										</div>
										<div class="col-sm-2">
											<img src="${pageContext.request.contextPath}/servlet/VerifyCodeServlet" style="width: 100%" onclick="this.src=this.src + '?' + Math.random()"/>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="verifyCodeMessage" style="color: red; margin: 0%"></p></span>
									</div>
										
										<div class="form-group form-actions">
											<div class="col-xs-offset-4 col-xs-2 ">
												<button type="reset" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span>重新输入</button>
											</div>
											<div class="col-xs-2 ">
												<button type="button" class="btn btn-sm btn-info" onclick="submitUI2()"><span class="glyphicon glyphicon-off"></span> 提交</button>
											</div>
										</div>
									<div class="form-group" hidden>
										<input id="base" value="${pageContext.request.contextPath}">
									</div>
										
										
									</form>
										
								</div>
							</div>
						</div>
	
			
			</div>
		</div>
	</div>
</div>


</body>


</html>