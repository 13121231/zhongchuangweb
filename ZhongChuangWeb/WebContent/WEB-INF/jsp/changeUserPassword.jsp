<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>用户修改密码界面</title>
<script src="${pageContext.request.contextPath}/JS/changeUserPassword.js"></script>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<div class="col-lg-offset-0 col-lg-10" style="margin-top:10%">
				<div class=row>
								<div class="col-lg-12">
									<form class=form-horizontal method=post action="${pageContext.request.contextPath}/servlet/ChangeUserPasswordServlet" id="changeUserPasswordForm" role="form">	
										<div class="form-group" id="inputUserNo">
										<label class="control-label col-sm-4 sr-only" for="adminuserNo">user</label>
										<div class="col-sm-4">
											<input type="text" class="form-control" name="userNo" id="userNo" placeholder="学号" onblur="check_userNo()" tabIndex="1" autofocus>
											<span class="glyphicon glyphicon-ok form-control-feedback" id="userNoSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="userNoError" style="visibility:hidden"></span>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="userNoMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
									<div class=form-group id="inputPassword">
											<label class="control-label col-sm-4 sr-only" for="password">旧密码</label>
											<div class=col-sm-4>										
												<input  class=form-control type="password"  name=password  id=password 	placeholder="旧密码" onblur="check_password()" tabIndex="2">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="passwordSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="passwordError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="passwordMessage" style="color: red; margin: 0%"></p></span>
									</div>

									<div class=form-group id="inputNewPassword">
											<label class="control-label col-sm-4 sr-only" for="Newpassword">新密码</label>
											<div class=col-sm-4>										
												<input  class=form-control type="password"  name=Newpassword  id=Newpassword 	placeholder="新密码" onblur="check_Newpassword()" tabIndex="2">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="NewpasswordSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="NewpasswordError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="NewpasswordMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
									<!-- <div class=form-group id="inputsetEmail">
											<label class="control-label col-sm-1 sr-only" for="setEmail">新密码</label>
											<div class=col-lg-8>										
												<input  class=form-control type="text"  name=setEmail  id=setEmail 	placeholder="设置接受的邮箱" onblur="check_Email()" tabIndex="2">
												<span class="glyphicon glyphicon-ok form-control-feedback" id="setEmailSuccess" style="visibility:hidden"></span>
	                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="setEmailError" style="visibility:hidden"></span>
											</div>
											<span class="col-sm-3" style="padding: 0"><p id="setEmailMessage" style="color: red; margin: 0%"></p></span>
									</div>
									 -->
									<div class="form-group" id="inputVerifyCode">
										<label class="control-label col-sm-4 sr-only" for="verifyCode">验证码</label>
										<div class="col-sm-2">
											<input class="form-control" type="text" name="verifyCode" id="verifyCode" placeholder="验证码" onblur="check_verifyCode()" tabIndex="4">
											<span class="glyphicon glyphicon-ok form-control-feedback" id="verifyCodeSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="verifyCodeError" style="visibility:hidden"></span>
										</div>
										<div class="col-sm-2">
											<img src="${pageContext.request.contextPath}/servlet/VerifyCodeServlet" style="width: 100%" onclick="this.src=this.src + '?' + Math.random()"/>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="verifyCodeMessage" style="color: red; margin: 0%"></p></span>
									</div>
										<br>
										<div class="form-group form-actions">
											<div class="col-xs-offset-4 col-xs-4 ">
													<button type="button" class="btn btn-lg btn-danger btn-block" onclick="submitlogin()"><span class="glyphicon glyphicon-off"></span> 提交</button>
											</div>
										</div>
									<div class="form-group" hidden>
										<input id="base" value="${pageContext.request.contextPath}">
									</div>
									</form>
								</div>
							</div>
						</div>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
