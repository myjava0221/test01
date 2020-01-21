<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	import="com.icook.model.orderItem"
	import="com.icook.model.ShoppingCart"
	import="com.icook.model.ProductTypeBean"
	import="com.icook.model.ProductBean"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>市集</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Truckage Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/css/shoppingCart.css"
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- load-more -->
<link
	href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<jsp:include page="/WEB-INF/views/fragment/TopNav.jsp" />
	<!-- 搜尋功能 -->
	<div class="contain align-items-center">
		<fieldset >
			<form  method="GET" action="productList" class="form-horizontal" style="text-align: center">
				<div class="form-group row">
				<input class="form-control" type="text" id="productName"
					placeholder="請輸入關鍵字" aria-label="Search" name="productName"/>
				&nbsp;&nbsp;<button class="btn btn-outline-success">Search</button>
				</div>
			</form>
		</fieldset>
	</div>
	llllll	
	5555BXXXXXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlexXlex
<!-- 	<p>1第一層迴圈forEach取productBean</p> -->
<!-- 	<p>2 迴圈中用core的Set設定ProductBean的type資料(Set陣列)</p> -->
<!-- 	<p>3用將此Set用toArray(new ProductTypeBean)轉成陣列後，放入List,放入sessionScope</p> -->
<!-- 	<p>4第二層迴圈 forEach取producTypetBean的資料</p> -->
		<c:forEach items="${prosList}" var="pros" varStatus="vs">
			<c:set var="prodsSet" value="${pros.type}"></c:set>
			<c:set var="pros" value="${pros}" scope="session"></c:set>
			<c:set var="imgArray" value="${ImgList[vs.index]}"></c:set>
			
			<c:forEach items="${prodsSet}" var="pbt" varStatus="vs">
			<div class="col-md-3 top_brand_left">
			<div class="agile_top_brand_left_grid">
			<div class="agile_top_brand_left_grid1">
			<form:form method="post" modelAttribute="orderItem" enctype="multipart/form-data">
				<c:set var="image1" value="${pageContext.request.contextPath}/${imgArray[vs.index]}" scope="session"></c:set>				
				<p><img width="200px" height="200" src="${pageContext.request.contextPath}/${imgArray[vs.index]}"></img></p>
				<c:set var="pbt" value="${pbt}" scope="session"></c:set>
				<p>${pros.productName}</p>
				<p>${pros.category}</p>
				<p>${pbt.unitPrice}</p>
				<p><form:input type="number" id="qty" path="qty" value="1" min="1" max="99" /></p>
				<form:input type="hidden" id="productId" path="productId" name="productId" value="${pros.productID}" />
				<form:input type="hidden" id="typeId" path="typeId" name="typeId" value="${pbt.typeID}" />
				<form:input type="hidden" id="image1" path="image1" name="image1" value="${pros.image1}" />
				<form:input type="hidden" id="unitPrice" path="unitPrice" name="unitPrice" value="${pbt.unitPrice}" />
				<form:input type="hidden" id="describe" path="describe" name="describe" value="${pros.productName}(${pbt.typeTitle})" />
				<input type="hidden" name="listIndex" value="${vs.index}" />
				<input type="hidden" name="listCount" value="${vs.count}" />
				<button name="cmd" value="add" class="rt-button rt-button-xlarge list-cart-submit rt-button-submit">
					Add To Car
				</button>	
			</form:form>
    				<div class="col-sm-10" style="width:160px;">
    					<div class="wthree_more wthree_more2" style="width:300px;">
						<a href="<spring:url value='/productDetail?productID=${pros.productID}&type=${pbt.typeID}' />" 
							class="button--wayra button--border-thick button--text-upper button--size-s">詳細資訊
						</a>	
						</div>
    				</div>
				
				</div>
				</div>
				</div>
			</c:forEach>
		</c:forEach>
		<!-- for bootstrap working -->
		<script src="js/bootstrap.js"></script>
		<!-- //for bootstrap working -->
</body>
</html>