<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>用户界面</title>
		<base href="${pageContext.request.contextPath}">
		<link href="${pageContext.request.contextPath}/PUBLIC/bs/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/PUBLIC/bootstrap-admin-pk/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/PUBLIC/bootstrap-admin-pk/dist/css/sb-admin-2.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/PUBLIC/bootstrap-admin-pk/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/PUBLIC/button/button.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/PUBLIC/JQuery/jquery-2.1.4.min.js"></script>
		<script src="${pageContext.request.contextPath}/PUBLIC/bs/dist/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/PUBLIC/bootstrap-admin-pk/bower_components/metisMenu/dist/metisMenu.min.js"></script>
		<script src="${pageContext.request.contextPath}/PUBLIC/bootstrap-admin-pk/dist/js/sb-admin-2.js"></script>
		<script src="${pageContext.request.contextPath}/PUBLIC/JSON/json_parse.js"></script>
		
	</head>

	<body>
		<div id="wrapper">
	        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	            <div class="navbar-header">
	                <img alt="学校图片" src="${pageContext.request.contextPath}/logo_school.png" style="height:40px;width:256px;margin:5px;"/>
	            </div>
	             <div class="col-md-offset-5">
	                <h3 class="navbar-text " style="font-family:楷体;font-size:19px;color:MediumBlue;letter-spacing:2px;">欢迎来到用户管理界面</h3>
	              </div> 
	             <ul class="nav navbar-top-links navbar-right">
		        	<li class="dropdown">
		          		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> ${author} 欢迎您！</span> <span class="caret"></span></a>
		          	    <ul class="dropdown-menu">
				            <li><a href=${pageContext.request.contextPath}/servlet/user/ShowChangeUserPasswordServlet>修改密码</a></li>
				            <li role="separator" class="divider"></li>	
				            <li><a href="${pageContext.request.contextPath}/servlet/user/LogoutServlet" id="test">注销</a></li>
			          	</ul>
			        </li>
			     </ul>
		</div>
	            <div class="navbar-default sidebar" role="navigation">
	                <div class="sidebar-nav navbar-collapse">
	                    <ul class="nav" id="side-menu">
	                        <li>
	                           <a href="#"><i class="fa fa-plus-circle"></i> 众创项目<span class="fa arrow"></span></a>
		                       <ul class="nav nav-second-level">
		                       		<li>
	                                     <a href="${pageContext.request.contextPath}/servlet/user/ShowIndexPageServlet">众创项目一览</a>
	                                </li>
	                                <li>
	                                      <a href="${pageContext.request.contextPath}/servlet/user/ShowUI1PageServlet">添加项目信息</a>
	                                </li>
                                </ul>
	                        </li>
	                    </ul>
	                </div>
	            </div>
	        </nav>
	        <div id="page-wrapper">