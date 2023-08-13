<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<div id="layoutSidenav">
	<!-- ======= SiderNav ======= -->
	<jsp:include page="../layout/sideNavForBack.jsp"></jsp:include>-->
	<!-- End SiderNav -->


	<!DOCTYPE html>
	<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1 class="mb-3">書本資訊</h1>
	<form action="${contextRoot}/book/addBook">
		<button type="submit" class="btn btn-primary mb-3">新增</button>
	</form>

	<table class="table table-striped" id="datatablesSimple">
		<thead class="thead-dark">
			<tr>
				<th scope="col">書本ISBN序號</th>
				<th scope="col">書本名稱</th>
				<th scope="col">書本作家</th>
				<th scope="col">書本敘述</th>
				
				

			</tr>

		</thead>

		<tbody>
			<c:forEach var="book" items="${bookList}">
				<tr>
					<td>${book.bookISBN}</td>
					<td>${book.bookName}</td>
					<td>${book.bookAuthor}</td>
					<td>${book.bookIntroduction}</td>
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- ======= Footer ======= -->
	<jsp:include page="../layout/footerForBack.jsp"></jsp:include>
	<!-- End Footer -->

</body>
	</html>