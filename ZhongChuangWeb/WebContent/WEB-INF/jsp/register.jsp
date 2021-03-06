<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<link href="${pageContext.request.contextPath}/PUBLIC/bs/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/PUBLIC/JQuery/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/PUBLIC/bs/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/PUBLIC/JSON/json_parse.js"></script>
<script src="${pageContext.request.contextPath}/JS/register.js"></script> 
</head>
<body>
<div class="container" style="margin-top:8%">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			 <div class="navbar-header">
			 </div>
	   		 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			 	<p class="navbar-text " >欢迎来到众创注册界面</p>     	 
		     	<ul class="nav navbar-nav navbar-right">
		        	<li class="dropdown">
		          		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs">用户注册</span> <span class="caret"></span></a>
		          	    <ul class="dropdown-menu">
				            <li><a href="${pageContext.request.contextPath}/servlet/ShowAdminLoginPageServlet"> 管理员登录</a></li>
				            <li role="separator" class="divider"></li>	
				            <li><a href="${pageContext.request.contextPath}/servlet/ShowLoginPageServlet">用户登录</a></li>
			          </ul>
			        </li>
			     </ul>
		    </div><!-- /.navbar-collapse -->
	    </div><!-- /.container-fluid -->
	</nav>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							注册
						</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form role="form" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/servlet/RegisterServlet" id="registerForm">
									<div class="form-group" id="inputUserNo">
										<label class="control-label col-sm-1 sr-only" for="userNo">学号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="userNo" id="userNo" placeholder="学号" onblur="check_userNo()" tabIndex="1" autofocus>
											<span class="glyphicon glyphicon-ok form-control-feedback" id="userNoSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="userNoError" style="visibility:hidden"></span>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="userNoMessage" style="color: red; margin: 0%"></p></span>
									</div>
									<div class="form-group" id="inputUserName">
										<label class="control-label col-sm-1 sr-only" for="userName">姓名</label>
										<div class="col-sm-8">
											<input class="form-control" type="text" name="userName" id="userName" placeholder="姓名" onblur="check_userName()" tabIndex="2">
											<span class="glyphicon glyphicon-ok form-control-feedback" id="userNameSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="userNameError" style="visibility:hidden"></span>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="userNameMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
									<div class="form-group" id="inputPassword">
										<label class="control-label col-sm-1 sr-only" for="password">输入密码</label>
										<div class="col-sm-8">
											<input type="password" class="form-control" name="password" id="password" placeholder="输入密码" onblur="check_password()" tabIndex="3">
											<span class="glyphicon glyphicon-ok form-control-feedback" id="passwordSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="passwordError" style="visibility:hidden"></span>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="passwordMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
									<div class="form-group" id="inputNewpassword">
										<label class="control-label col-sm-1 sr-only" for="Newpassword">再次输入密码</label>
										<div class="col-sm-8">
											<input type="password" class="form-control" name="Newpassword" id="Newpassword" placeholder="再次输入密码" onblur="check_Newpassword()" tabIndex="3">
											<span class="glyphicon glyphicon-ok form-control-feedback" id="NewpasswordSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="NewpasswordError" style="visibility:hidden"></span>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="NewpasswordMessage" style="color: red; margin: 0%"></p></span>
									</div>
									
									<div class="form-group" id="inputVerifyCode">
										<label class="control-label col-sm-1 sr-only" for="verifyCode">验证码</label>
										<div class="col-sm-4">
											<input class="form-control" type="text" name="verifyCode" id="verifyCode" placeholder="验证码" onblur="check_verifyCode()" tabIndex="4">
											<span class="glyphicon glyphicon-ok form-control-feedback" id="verifyCodeSuccess" style="visibility:hidden"></span>
                                    		<span class="glyphicon glyphicon-remove form-control-feedback" id="verifyCodeError" style="visibility:hidden"></span>
										</div>
										<div class="col-sm-4">
											<img src="${pageContext.request.contextPath}/servlet/VerifyCodeServlet" style="width: 100%" onclick="this.src=this.src + '?' + Math.random()"/>
										</div>
										<span class="col-sm-3" style="padding: 0"><p id="verifyCodeMessage" style="color: red; margin: 0%"></p></span>
									</div>
									<div class="form-group">
										<div class="col-xs-offset-1 col-xs-8">
											<button class="btn btn-lg btn-danger btn-block" type="button" onclick="submitRegister()" tabIndex="5">注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册</button>
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