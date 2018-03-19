<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成功页面</title>
<link href="${pageContext.request.contextPath}/PUBLIC/bs/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/PUBLIC/JQuery/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/PUBLIC/bs/dist/js/bootstrap.min.js"></script>
<script>
	var forwardSecond = ${requestScope.forwardSecond};
	var downCount = function() {
		forwardSecond = forwardSecond - 1;
		document.getElementById("downCount").innerHTML = forwardSecond;
	}
	var timer = window.setInterval("downCount();", 1000);
</script>
</head>
<body>
	<div class="container" style="margin-top: 5%">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">成功信息</h3>
					</div>
					<div class="panel-body">
						<h1 class="text-success">
							:) ${requestScope.tip}
							<small id="downCount">3</small>
						</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>