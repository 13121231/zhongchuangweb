<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.edu.njupt.bigdata.bean.ProjectBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>按学号查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="${pageContext.request.contextPath}/PUBLIC/bs/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/PUBLIC/JQuery/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/PUBLIC/bs/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/adminlogin.js"></script>
  </head>
  
  <body>
  	<div class="row">
		<div class="col-lg-offset-1 col-lg-10">
			<div class="panel panel-default">
				<div class="panel-heading">	
				    <br>
				        <h3>符合条件的学生信息</h3><hr> 
				    <br>
				     <table 	class="table table-hover">
				    <tr>
				    <td>项目编号</td>
				    <td>项目名称</td>
				    <td>项目类型</td>
				    <td>项目负责人</td>
				    <td>项目负责人邮箱</td>
				    <td>项目负责人手机号码</td>
				    </tr>
					    <%
					     response.setCharacterEncoding("UTF-8");
					     request.setCharacterEncoding("UTF-8");
					     
					     ArrayList<ProjectBean> result=new ArrayList<ProjectBean>();    
					     result=(ArrayList<ProjectBean>)request.getAttribute("result");
					       
					       if(!result.isEmpty()){
					       for(int i=0;i<result.size();i++){
					    	   ProjectBean st=result.get(i);
					            out.print("<tr>");
					            out.print("<td>"+st.getProjectId()+"</td>");
					            out.print("<td>"+st.getProjectName()+"</td>");
					            out.print("<td>"+st.getProjectType()+"</td>");
					            out.print("<td>"+st.getProjectUser()+"</td>");
					            out.print("<td>"+st.getProjectEmail()+"</td>"); 
					            out.print("<td>"+st.getProjectMobile()+"</td>"); 
					     %>
   
					  	<% 
					    out.print("</tr>");
					            }
					       }
   						 %>
     					 </table>
			      <br><br>
			      <h4>
			      <%  out.print("<a href='${pageContext.request.contextPath}/servlet/admin/AdminPageServlet?methodName=1'>返回查询页面</a>|");%>
			     </h4>
			   		</div>
      			</div>
      		</div>
      </div>
  </body>
</html>