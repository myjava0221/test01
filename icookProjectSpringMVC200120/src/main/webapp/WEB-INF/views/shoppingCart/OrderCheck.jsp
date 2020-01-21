<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, java.text.SimpleDateFormat, java.util.Date, com.icook.model.orderDetail, com.icook.model.orderBean, com.icook.model.MemberBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function cancelOrder() {
		if (confirm("確定取消此份訂單 ? ")) {
			// 接收此資料的Servlet會使用 finalDecision 參數的值
			document.forms[0].finalDecision.value = "CANCEL";
			document.forms[0].action = "<c:url value='/ShoppingCar/CheckOrder'/>";
			document.forms[0].method = "GET";
			document.forms[0].submit();
			return;
		} else {
			return;
		}
	}
	function reconfirmOrder() {
		// 	var sa = document.getElementById('ShippingAddress').value;
		var sa = $('#SAddress').val();
		if (sa === "") {
			window.alert('出貨地址不能是空白');
			return;
		}
		if (confirm("確定送出此份訂單 ? ")) {
			// 接收此資料的Servlet會使用 finalDecision 參數的值
			document.forms[0].finalDecision.value = "ORDER";
			document.forms[0].action = "<c:url value='/ShoppingCar/CheckOrder'/>";
			document.forms[0].method = "GET";
			document.forms[0].submit();
			return;
		} else {
			return;
		}
	}
</script>
<meta charset="UTF-8">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li> < 訂單資訊 > </li>
			</ul>
		</div>
	</div>
	<br>
	<div align='center'>
		<h3>請確認下列訊息：</h3>
		<br>
		<form action="<c:url value='OrderServlet.do' />" method="POST">
			<table class="table table-striped" style="width: 60%; max-width: 87%; margin-bottom: 20px;">
				<thead>
					<tr>
						<th>商品名稱
						<th>優惠
						<th>單品價格
						<th>數量
						<th>小計
					</tr>
				</thead>
				<tbody>
					<%
						MemberBean mem = new MemberBean();
						mem = (MemberBean) session.getAttribute("LogOK");
						List<orderDetail> SCar = new LinkedList<>();
						SCar = (List<orderDetail>) session.getAttribute("ShoppingOrder");
						double freight = 20;
						double total = 0;
						for (int i = 0; i < SCar.size(); i++) {
							double unitPrice = SCar.get(i).getUnitPrice();
							out.print("<tr><td>" + SCar.get(i).getDescribe());
							out.print("<td id='discount" + i + "'>");
							out.print("<td>" + SCar.get(i).getUnitPrice());
							out.print("<td>" + SCar.get(i).getQty());
							if (SCar.get(i).getDiscount() == null) {
								out.print("<td> NT$ " + SCar.get(i).getUnitPrice() * SCar.get(i).getQty());
								total += unitPrice * SCar.get(i).getQty();
							} else {
								double discount = Double.valueOf(SCar.get(i).getDiscount()) / 10;
								for (double j = 1.0; j <= 9.0; j++) {
									if ((discount * 10) == j) {
										out.print("<script> $('#discount" + i + "').text('" + Math.round((discount * 10))
												+ "折') </script>");
										break;
									} else {
										out.print("<script> $('#discount" + i + "').text('" + discount * 10 + "折') </script>");
									}
								}
								out.print("<td> NT$ " + unitPrice * discount * SCar.get(i).getQty());
								total += unitPrice * discount * SCar.get(i).getQty();
							}
						}
						out.print("<tr><td colspan='4' align='right'>合計金額 ：             ");
						out.print("<td> NT$" + total);
						out.print("<tr><td colspan='4' align='right'>運費：             </td>");
						out.print("<td> NT$" + freight);
						out.print("<tr><td colspan='4' align='right'>總計金額：             </td>");
						total = total + freight;
						out.print("<td> NT$" + total);
						session.setAttribute("total", total);
					%>
					<br>
				</tbody>
			</table>

			<div>
				<table class="table" id="tab2" style="width: 60%; max-width: 87%; margin-bottom: 20px;">
					<thead>
						<tr>
							<th>
							<th>
						</tr>
					</thead>
					<tbody>
						<tr><td>
							<%
								if (mem.getAddress() != null) {
									out.print("<tr><td align='center'>送貨地址 : <td><input type='text' size = '70' style='width: 70%' id='SAddress' name='ShippingAddress' value='"+ mem.getAddress() +"'  class='form-control' aria-describedby='basic-addon1'>");
								} else {
									out.print("<tr><td align='center'>送貨地址 : <td><input type='text' size = '70' style='width: 70%' id='SAddress' name='ShippingAddress' value=''  class='form-control' aria-describedby='basic-addon1'>");
								}
							%>		
						<tr>
							<td align='center'>統一編號 :
							<td><input style="width: 70%" type='text' name='BNO' value=''class="form-control" aria-describedby="basic-addon1">
						<tr>
							<td align='center'>發票抬頭 :
							<td><input type='text' style="width: 70%" name='invoiceTitle'
								value='' class="form-control" aria-describedby="basic-addon1">
					</tbody>
				</table>
			</div>
			<br> 
			<input type="hidden" name="finalDecision" value="">
			<input type="button" class="btn btn-default" name="OrderBtn" value="確定送出" onclick="reconfirmOrder()"> 
			<span>&nbsp;&nbsp;&nbsp;</span>
			<input type="button" class="btn btn-default" name="CancelBtn" value="取消訂單" onclick="cancelOrder()">
			<br><br>
		</form>
	</div>
</body>
</html>