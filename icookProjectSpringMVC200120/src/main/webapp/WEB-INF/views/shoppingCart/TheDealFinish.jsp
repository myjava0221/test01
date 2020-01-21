<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/css/bootstrap2.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<link
	href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragment/TopNav.jsp" />
	
	<div class="services-breadcrumb">
		<div class="container">
			<ul>
				<li> < 訂購完成 > </li>
			</ul>
		</div>
	</div>
	
	<div align="center">
	<br><br><br><br><br><br><br>
		<h2>感謝您的訂購<br>
		<%
			int mem;
			mem = (int)session.getAttribute("UID");
			out.print("您的訂單編號 : " + mem + "<br>");
			String packageName = "icookProjectSpringMVC200112";
		%>
		您可至會員中心查看您的訂單
		</h2>
		<br><br>
		<input type="button" class="btn btn-default" onclick="javascript:location.href='/<%=packageName%>/MyOrders/Orders?page=1'"  name="OrderDetails" value="訂單">
	</div>
</body>
</html>