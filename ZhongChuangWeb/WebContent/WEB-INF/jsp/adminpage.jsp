<%@ page language="java" contentType="text/html; charset=utf-8"
    import="java.util.*"  pageEncoding="utf-8"%>
 <%@page import="java.sql.Connection"%>
 <%@page import="java.sql.*"%>
 <%@ page import="cn.edu.njupt.bigdata.bean.ProjectBean" %>
 <%@ page import="cn.edu.njupt.bigdata.bean.AdminPageBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>管理员界面</title>
<link href="${pageContext.request.contextPath}/PUBLIC/bs/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/PUBLIC/JQuery/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/PUBLIC/bs/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/adminPage.js"></script>
</head>
<body onload="check_down()">
<div class="container" style="margin-top:7% ">
	<nav class="navbar navbar-default navbar-fixed-top">
		 <div class="container-fluid">
		    <div class="navbar-header">
			    <form class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/servlet/admin/AdminQueryPageServlet">
			    	<div class="form-group">
			      		<input type="text" class="form-control"  name="id"  placeholder="按ID搜索">
			        </div>
			        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i>查询</button>
	     		 </form>
		    </div>
		    <div class=" col-md-offset-5">
		    <p class="navbar-text navbar-center" >Welcome to ZhongChuangWeb</p> 
		    </div>	
		    <ul class="nav navbar-nav navbar-right">
	        	<li class="dropdown">
	          		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> AdminPage</span> <span class="caret"></span></a>
	          	    <ul class="dropdown-menu">
		            <li><a href="${pageContext.request.contextPath}/servlet/ShowAdminLoginPageServlet">Login out</a></li>
		             <li role="separator" class="divider"></li>	
		            <li><a href="${pageContext.request.contextPath}/servlet/ShowChangePasswordServlet">Admin Alter Password</a></li>
		             <li role="separator" class="divider"></li>	
		          </ul>
		        </li>
	       </ul>
	    </div>
	</nav>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							众创项目文件一览
						</h3>
					</div>
					<div class="panel-body">	
						<table	class="table table-hover table-striped table-bordered table-responsive">
							<thead>
								<tr>
									<th class="col-sm-1">项目编号</th>
									<th class="col-sm-2">名称</th>
									<th class="col-sm-1">类型</th>
									<th class="col-sm-1">申请人</th>
									<th class="col-sm-2">邮箱</th>
									<th class="col-sm-2">手机号码</th>
									<th class="col-sm-1">文件下载</th>
									<th class="col-sm-1">报销下载</th>
									<th class="col-sm-1">项目删除</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="project" items="${subResult}" >
									<tr>
										<td class="col-sm-1"><c:out value="${project.projectId}"></c:out>
										<div class="form-group" hidden>
										<input id="base" value="${project.projectId}">
										</div>
										</td>
										<td class="col-sm-2"><c:out value="${project.projectName}"></c:out></td>
										<td class="col-sm-1"><c:out value="${project.projectType}"></c:out></td>
										<td class="col-sm-1"><c:out value="${project.projectUser}"></c:out></td>
										<td class="col-sm-2"><c:out value="${project.projectEmail}"></c:out></td>
										<td class="col-sm-2"><c:out value="${project.projectMobile}"></c:out></td>
										<td class="col-sm-1">
											<a class="btn btn-success btn-sm" href=${pageContext.request.contextPath}/servlet/admin/DownProjectFileServlet?programNo=${project.projectId}&programName=${project.projectName}&author=${project.projectUser}><i class="glyphicon glyphicon-arrow-down"></i></a></td>
										<td class="col-sm-1">
											<c:if test="${project.path != null}">											  
											  <a class="btn btn-info btn-sm" id="expenseDownload" href=${pageContext.request.contextPath}/servlet/admin/DownProjectExpenseServlet?programNo=${project.projectId}&programName=${project.projectName}&author=${project.projectUser}><i class="glyphicon glyphicon-arrow-down"></i></a>
											</c:if>
										</td>
										<td class="col-sm-1">
											<a class="btn btn-danger btn-sm" onclick = "return deleteProject()" href=ShowAdminPageServlet?programNo=${project.projectId}&deleteFlag=1 id="deleteProject"><i class="glyphicon glyphicon-remove"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</div>
					   <c:if test="${adminPageBean.last<0 and adminPageBean.next<adminPageBean.totalRecord}">首页
						   <nav>	
							    <ul class="pager">
								    <li class=" disabled"><a href="#"><</a></li>
								    <li><a href="ShowAdminPageServlet?currentRecord=${adminPageBean.next}">></a></li>
							   </ul>
						   </nav>
					   </c:if>
					    
					    <c:if test="${adminPageBean.next>=adminPageBean.totalRecord and adminPageBean.last<0}">
						   <nav>	
							    <ul class="pager">
							  
								    <li class=" disabled"><a href="#"><</a></li>
								    <li class=" disabled"><a href="#">></a></li>
							 	 </ul>	
						 	 </nav>
					   </c:if>
					   
					   <c:if test="${adminPageBean.last>=0 and adminPageBean.next<adminPageBean.totalRecord}">
						   <nav>	
							    <ul class="pager">
								    <li><a href="ShowAdminPageServlet?currentRecord=${adminPageBean.last}"><</a></li>
								    <li><a href="ShowAdminPageServlet?currentRecord=${adminPageBean.next}">></a></li>
							 	 </ul>	
						 	 </nav>
					   </c:if>
					   
					   <c:if test="${adminPageBean.next>=adminPageBean.totalRecord and adminPageBean.last>=0}">
						   <nav>	
							    <ul class="pager">
								    <li><a href="ShowAdminPageServlet?currentRecord=${adminPageBean.last}"><</a></li>
								    <li class=" disabled"><a href="#">></a></li>
							 	 </ul>	
						 	 </nav>
					   </c:if>
				</div>
			</div>
		</div>
	
</div>

</body>
</html>