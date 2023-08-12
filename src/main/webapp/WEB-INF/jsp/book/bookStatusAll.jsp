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
	<h1 class="mb-3">狀態資訊</h1>
	<form action="${contextRoot}/book/addBookStatus">
		<button type="submit" class="btn btn-primary mb-3">新增</button>
	</form>

	<table class="table table-striped" id="datatablesSimple">
		<thead class="thead-dark">
			<tr>
				<th scope="col">書本狀態序號</th>
				<th scope="col">書本狀態名稱</th>
				<th scope="col">書本狀態敘述</th>
				<th scope="col">編輯</th>
				<th scope="col">刪除</th>
			</tr>

		</thead>

		<tbody>
			<c:forEach var="bookStatus" items="${bookStatusList}">
				<tr>
					<td>${bookStatus.bookStatusId}</td>
					<td>${bookStatus.bookStatusName}</td>
					<td>${bookStatus.bookStatusDesc}</td>




					<td><form:form action="${contextRoot}/book/editBook"
							method="get">
							<input type="hidden" name="bookISBN" value="${book.bookISBN}">
							<button type="submit" class="btn btn-warning">編輯</button>


						</form:form></td>
					<td><form:form action="${contextRoot}/book/deleteBook"
							method="DELETE">
							<input type="hidden" name="bookISBN" value="${book.bookISBN}">
							<button type="submit" class="btn btn-danger">刪除</button>
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- ======= Footer ======= -->
	<jsp:include page="../layout/footerForBack.jsp"></jsp:include>
	<!-- End Footer -->

</body>
	</html>