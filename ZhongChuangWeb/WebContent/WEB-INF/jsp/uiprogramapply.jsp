<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script src="${pageContext.request.contextPath}/JS/uiprogramapply.js"></script>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
						<div class="col-lg-offset-0 col-lg-10" style="margin-top:8%">
							<div class=row>
								<div class="col-lg-12">
									<form class=form-horizontal method=post action="${pageContext.request.contextPath}/servlet/user/ProgramApplyServlet" id="UI1Form" role="form" >	
										
										<div class="form-group" id="inputProgramName">
										<label class="control-label col-sm-4 sr-only" for="ProgramName">项目名称</label>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="ProgramName" id="ProgramName" placeholder="项目名称" onblur="check_ProgramName()" tabIndex="1" autofocus>
											<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramNameSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramNameError" style="visibility:hidden"></span>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="ProgramNameMessage" style="color: red; margin: 0%"></p></span>
									</div>
										
									<!-- <div class=form-group id="inputProgramNo">
											<label class="control-label col-sm-4 sr-only" for="ProgramNo">项目编号</label>
											<div class=col-lg-4>										
												<input  class=form-control type="text"  name=ProgramNo  id=ProgramNo 	placeholder="项目编号" onblur="check_ProgramNo()" tabIndex="2">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramNoSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramNoError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramNoMessage" style="color: red; margin: 0%"></p></span>
									</div> -->
									
									<!-- <div class=form-group id="inputProgramUserName">
											<label class="control-label col-sm-4 sr-only" for="ProgramUserName">项目负责人</label>
											<div class=col-lg-4>										
												<input  class=form-control type="text"  name=ProgramUserName  id=ProgramUserName 	placeholder="项目负责人" onblur="check_ProgramUserName()" tabIndex="3" value="This is focused...">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramUserNameSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramUserNameError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramUserNameMessage" style="color: red; margin: 0%"></p></span>
									</div> -->
									<div class=form-group id="inputProgramType">
										<label class="control-label col-sm-4 sr-only" for="ProgramType">项目类型选择</label>
									<div class=col-lg-4>
									<p>项目类型选择<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramTypeSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramTypeError" style="visibility:hidden"></span>
	                                 </p>
									<label class="radio-inline">
										  <input type="radio" name="ProgramType" id="ProgramType1" value="A" onclick="chose_check1()" checked="checked"> A
									</label>
									<label class="radio-inline">
										  <input type="radio" name="ProgramType" id="ProgramType2" value="B" onclick="chose_check2()"> B
									</label>
									<label class="radio-inline">
										  <input type="radio" name="ProgramType" id="ProgramType3" value="C"  onclick="chose_check3()"> C
									</label>
									</div>
									<span class="col-sm-3" style="padding: 0"><p id="ProgramTypeMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
									<div class=form-group id="inputProgramMobileNumber">
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
												<input  class=form-control type="text"  name=ProgramEmail  id=ProgramEmail 	placeholder="项目负责人邮箱" onblur="check_ProgramEmail()" tabIndex="4">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramEmailSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramEmailError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramEmailMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
								<!-- <div class=form-group id="inputProgramWord">
											<label class="control-label col-sm-4 sr-only" for="ProgramWord">项目文档</label>
											<div class=col-lg-4 style="display:inline-block;">
												<p>上传项目文档	<input type="button" value="增加"  onclick="addFile()" id="Button1">&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="减少"  onclick="cutFile()" id="Button2"></p>									
												<input   type="file"  multiple="multiple" name=ProgramWord  id=ProgramWord 	placeholder="项目文档" onblur="check_ProgramWord()" tabIndex="5">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="ProgramWordSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="ProgramWordError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="ProgramWordMessage" style="color: red; margin: 0%"></p></span>
									</div> -->
									
										
									<div class="form-group" id="inputVerifyCode">
										<label class="control-label col-sm-4 sr-only" for="verifyCode">验证码</label>
										<div class="col-sm-2">
											<input class="form-control"   type="text" name="verifyCode" id="verifyCode" placeholder="验证码" onblur="check_verifyCode()" tabIndex="6">
											 
											<span class="glyphicon glyphicon-ok form-control-feedback" id="verifyCodeSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="verifyCodeError" style="visibility:hidden"></span>
										</div>
										<div class="col-sm-2">
											<img src="${pageContext.request.contextPath}/servlet/VerifyCodeServlet" style="width: 100%" onclick="this.src=this.src + '?' + Math.random()"/>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="verifyCodeMessage" style="color: red; margin: 0%"></p></span>
									</div>
										
										<div class="form-group form-actions">
											<div class="col-xs-offset-4 col-xs-4">
												<button type="button" class="btn btn-lg btn-info btn-block" onclick="submitUI1()"><span class="glyphicon glyphicon-off"></span> 提交</button>
											</div>
										</div>
									<div class="form-group" hidden>
										<input id="base" value="${pageContext.request.contextPath}">
									</div>
										
										
									</form>
										
								</div>
							</div>
						</div>
	
			
	
<%@ include file="/WEB-INF/jsp/footer.jsp" %>