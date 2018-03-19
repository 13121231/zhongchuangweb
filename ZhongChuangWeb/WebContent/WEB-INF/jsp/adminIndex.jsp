<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="java.sql.Connection"%>
 <%@page import="java.sql.*"%>
 <%@ page import="cn.edu.njupt.bigdata.bean.ProjectBean" %>
 <%@ page import="cn.edu.njupt.bigdata.bean.AdminPageBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<script src="${pageContext.request.contextPath}/PUBLIC/JSON/bootstrap-modal.js"></script>
<script src="${pageContext.request.contextPath}/JS/adminIndex.js"></script>
<%@ include file="/WEB-INF/jsp/adminHeader.jsp" %>
<div class="form-group" hidden>
	<input id="currentPage" value="${adminPageBean.currentPage}">
</div>
<div  class="col-lg-12">
	<div  class="rol">
		<form class="form-horizontal" method=post action="${pageContext.request.contextPath}/servlet/admin/ShowAdminIndexServlet" id="pageSizeForm" role="form">
				<div  class="col-lg-1">
					<div class="form-group" id="inputpageSize">
						<input type="text" class="form-control" id="pageSize" name="pageSize"  placeholder="pageSize" value="${adminPageBean.pageSize}" onblur="checkPageSize()">
					 </div>
				 </div>
				 <div  class="col-lg-1">
				 		<button type="button" class="btn btn-default btn-info" onclick="submit_pageSize()">SET</button>
				 </div>
		</form>
	</div>
</div>

<div class="col-lg-12" style="margin-top:0%">
				<div class="panel panel-default">	
					<div class="panel-heading">
						<h3 class="panel-title">
							众创项目文件一览	第${adminPageBean.currentPage+1}页 
						</h3>
					</div>
					
					<div class="panel-body">	
					
						<table	class="table table-hover table-striped table-bordered table-responsive">
							<thead>
								<tr>
									<th class="col-sm-1" style="text-align:center;">编号</th>
									<th class="col-sm-3" style="text-align:center;">名称</th>
									<th class="col-sm-1" style="text-align:center;">类型</th>
									<th class="col-sm-1" style="text-align:center;">学号</th>
									<th class="col-sm-1" style="text-align:center;">负责人</th>
									<th class="col-sm-1" style="text-align:center;">文件</th>
									<th class="col-sm-1" style="text-align:center;">报销</th>
									<th class="col-sm-1" style="text-align:center;">审批</th>
									<!-- <th class="col-sm-1" style="text-align:center;">权限</th> -->
									<th class="col-sm-1" style="text-align:center;">删除</th>
									<th class="col-sm-1" style="text-align:center;">赋编号</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="project" items="${subResult}" >
									<tr>
										<td class="col-sm-1" style="text-align:center;">
											<c:choose>
												<c:when test="${project.adminState==1}">
													<input type="text" id="projectId" style="border:0px;padding:0px;margin:0px;width:60px;"value="${project.projectId}">
												</c:when>
												<c:otherwise>
													<c:out value="${project.projectId}"></c:out>
												</c:otherwise>
											</c:choose>
										</td>
										<td class="col-sm-2" style="text-align:center;"><c:out value="${project.projectName}">
											</c:out>
											<div class="form-group" hidden>
											<input id="base" value="${project.projectName}">
											</div>
										</td>
										<td class="col-sm-1" style="text-align:center;"><c:out value="${project.projectType}"></c:out></td>
										<td class="col-sm-1" style="text-align:center;"><c:out value="${project.userNo}">
										</c:out>
											<div class="form-group" hidden>
											<input id="base1" value="${project.userNo}">
											</div>
										</td>
										<td class="col-sm-1" style="text-align:center;"><c:out value="${project.projectUser}"></c:out></td>
										<td class="col-sm-1" style="text-align:center;">
										<c:choose>
											<c:when test="${project.fileState==1}">
												<a class="btn btn-danger btn-sm"  href="${pageContext.request.contextPath}/servlet/admin/DownProjectFileServlet?userNo=${project.userNo}&programName=${project.projectName}" ><i class="glyphicon glyphicon-arrow-down"></i></a>									
											</c:when>
											<c:otherwise>
												<a class="btn btn-default btn-sm disabled"><i >未上传</i></a>
											</c:otherwise>
										</c:choose>
										</td>
										<td class="col-sm-1" style="text-align:center;">
										<c:choose>
											<c:when test="${project.billState==1}">
											<a class="btn btn-info btn-sm"  href="${pageContext.request.contextPath}/servlet/admin/DownProjectExpenseServlet?userNo=${project.userNo}&programName=${project.projectName}" ><i class="glyphicon glyphicon-arrow-down"></i></a>
											</c:when>
											<c:otherwise>
												<a class="btn btn-default btn-sm disabled"><i >未上传</i></a>
											</c:otherwise>
										</c:choose>
										</td>
										<td class="col-sm-1" style="text-align:center;">
										<c:choose>
													<c:when test="${project.adminState==0 and project.fileState==1}">
														<a class="btn btn-warning btn-sm" id="checkProgram" onclick="return check_Program()" href ="${pageContext.request.contextPath}/servlet/admin/AdminStateServlet?userNo=${project.userNo}&programName=${project.projectName}&adminState=1&currentPage=${adminPageBean.currentPage}&pageSize=${adminPageBean.pageSize}"><i class="glyphicon glyphicon-check"></i></a>											 		
													</c:when>
													<c:when test="${project.adminState==0 and project.fileState==0}">
														<a class="btn btn-default btn-sm disabled"><i class="glyphicon glyphicon-check"> </i></a>											 		
													</c:when>
												 	<c:otherwise>
												 		<a  class="btn btn-danger btn-sm " href="${pageContext.request.contextPath}/servlet/admin/AdminStateServlet?userNo=${project.userNo}&programName=${project.projectName}&adminState=0&currentPage=${adminPageBean.currentPage}&pageSize=${adminPageBean.pageSize}"><i class="">已批阅</i></a>
												 	</c:otherwise>
										</c:choose>
										
										</td>
										<%-- <td class="col-sm-1" style="text-align:center;">
										<c:choose>
													<c:when test="${project.changeState==0}">
														<a class="btn btn-success btn-sm" id="quanxian" onclick="return quanxian_Program()" href ="${pageContext.request.contextPath}/servlet/admin/ChangeStateServlet?userNo=${project.userNo}&programName=${project.projectName}&changeState=1&currentPage=${adminPageBean.currentPage}&pageSize=${adminPageBean.pageSize}"><i class="glyphicon glyphicon-wrench"></i></a>
													</c:when>
												 	<c:otherwise>
												 		<a  class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/servlet/admin/ChangeStateServlet?userNo=${project.userNo}&programName=${project.projectName}&changeState=0&currentPage=${adminPageBean.currentPage}&pageSize=${adminPageBean.pageSize}"><i>可修改</i></a>
												 	</c:otherwise>
										</c:choose>
										</td> --%>
										<td class="col-sm-1" style="text-align:center;">
										<a class="btn btn-danger btn-sm" onclick="return delete_Program()" href ="${pageContext.request.contextPath}/servlet/admin/DeleteProgramServlet?userNo=${project.userNo}&programName=${project.projectName}&deleteFlag=1&currentPage=${adminPageBean.currentPage}&pageSize=${adminPageBean.pageSize}"><i class="glyphicon glyphicon-remove"></i></a>
										</td>
										<td class="col-sm-1" style="text-align:center;">
										<c:choose>
											<c:when test="${project.adminState==1}">
												<a class="btn btn-info btn-sm" id="changeProjectIdButton" href="javascript:void(0)" onclick="return change_projectId(this)"><i class="glyphicon">提交</i></a>
											</c:when>
											<c:otherwise>
												<a class="btn btn-default btn-sm disabled" id="changeProjectIdButton" href="javascript:void(0)"><i class="glyphicon">提交</i></a>
											</c:otherwise>
										</c:choose>
										
										</td>
									</tr>	
								</c:forEach>
							</tbody>
						</table>
					</div>
			</div>
		</div>
		 <div align = "center">
			<nav>
			  <ul class="pagination  pagination-lg">
				  	<c:choose>
				  			<c:when test="${adminPageBean.last<0}">
						    <li  class=" disabled">
						      <a>
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
						    </c:when>
						    <c:otherwise>
							    <li>
							      <a  href="${pageContext.request.contextPath}/servlet/admin/ShowAdminIndexServlet?currentPage=${adminPageBean.lastPage}&pageSize=${adminPageBean.pageSize}" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>
						    </c:otherwise>
				  	 </c:choose>		    
					    <%
					  		int i =(Integer)request.getAttribute("totalPage");
					    	for (int j=0;j<i;j++)
					    	{%>
					    
					    <li class="paginate_button" id="<%=j%>"><a  href="${pageContext.request.contextPath}/servlet/admin/ShowAdminIndexServlet?currentPage=<%=j%>&pageSize=${adminPageBean.pageSize}" onclick="chooseButtonClass(<%=j%>)"><%=j+1%> <span class="sr-only">(current)</span></a></li>
					   <%}%>
					    <c:choose>
					      	<c:when test="${adminPageBean.next>=adminPageBean.totalRecord}">
						      	 <li class="disabled">
							     	 <a>
							        <span aria-hidden="true">&raquo;</span>
							      	</a>
						  		  </li>
					      	</c:when>
					      	<c:otherwise>
					      		 <li class="">
							     	 <a  href="${pageContext.request.contextPath}/servlet/admin/ShowAdminIndexServlet?currentPage=${adminPageBean.nextPage}&pageSize=${adminPageBean.pageSize}" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      	</a>
						  		  </li>
					      	</c:otherwise>
					      </c:choose>
					  </ul>
			</nav>
		 </div> 
<%@ include file="/WEB-INF/jsp/footer.jsp"%>