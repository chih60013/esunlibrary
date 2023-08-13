<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<div id="layoutSidenav">



	<!DOCTYPE html>
	<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1 class="mb-3">修改書本庫存狀態資訊</h1>
	<form action="${contextRoot}/book/addBookInventory">
		<button type="submit" class="btn btn-primary mb-3">新增</button>
	</form>

	<form:form modelAttribute="bookInventory" method="put"
		action="${contextRoot}/book/editBookInventory"
		enctype="multipart/form-data">

		<form:label path="bookInventoryId">書本庫存Id</form:label>
		<form:input path="bookInventoryId" readonly="true" />
		<br>

		<form:label path="bookStatus">書籍狀態</form:label>
		<form:select path="bookStatus">

			<c:forEach items="${bookStatusList}" var="bookStatus">

				<c:choose>
					<c:when
						test="${bookInventory.bookStatus.bookStatusId == bookStatus.bookStatusId}">
						<form:option value="${bookStatus.bookStatusId}"
							selected="selected">${bookStatus.bookStatusName}</form:option>
					</c:when>
					<c:otherwise>
						<form:option value="${bookStatus.bookStatusId}">${bookStatus.bookStatusName}</form:option>
					</c:otherwise>


				</c:choose>
			</c:forEach>
		</form:select>


		<button type="submit">送出</button>
	</form:form>



	<!-- ======= Footer ======= -->
	<jsp:include page="../layout/footerForBack.jsp"></jsp:include>
	<!-- End Footer -->

</body>
	</html>