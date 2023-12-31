<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<div id="layoutSidenav">
	<!-- ======= SiderNav ======= -->
	<jsp:include page="../layout/sideNavForBack.jsp"></jsp:include>
	<!-- End SiderNav -->


	<!DOCTYPE html>
	<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1 class="mb-3">書本庫存狀態資訊</h1>
	<form action="${contextRoot}/book/addBookInventory">
		<button type="submit" class="btn btn-primary mb-3">新增</button>
	</form>

	<table class="table table-striped" id="datatablesSimple">
		<thead class="thead-dark">
			<tr>
				<th scope="col">書本庫存Id</th>
				<th scope="col">書本ISBN</th>
				<th scope="col">書本名稱</th>
				<th scope="col">書本購買日期</th>
				<th scope="col">書本狀態</th>
				<th scope="col">編輯</th>
				
			</tr>

		</thead>

		<tbody>
			<c:forEach var="bookInventory" items="${bookInventoryList}">
				<tr>
					<td>${bookInventory.bookInventoryId}</td>
					<td>${bookInventory.book.bookISBN}</td>
					<td>${bookInventory.book.bookName}</td>
					<td>${bookInventory.bookPurchaseDate}</td>
					<td>${bookInventory.bookStatus.bookStatusName}</td>



					<td><c:if test="${empty member}">
							<a href="${contextRoot}/member/login" class="btn btn-primary">登入會員方可借書</a>
						</c:if>
						<c:if test="${not empty member}">
							<form:form action="${contextRoot}/book/editBook" method="get">
								<input type="hidden" name="bookISBN" value="${book.bookISBN}">
								<button type="submit" class="btn btn-primary">借閱</button>
						</form:form>
						</c:if>
						</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- ======= Footer ======= -->
	<jsp:include page="../layout/footerForBack.jsp"></jsp:include>
	<!-- End Footer -->

</body>
	</html>