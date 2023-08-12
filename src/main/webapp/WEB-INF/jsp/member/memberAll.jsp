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
			<h1 class="mb-3">會員資訊後台</h1>
			<form action="${contextRoot}/member/register">
				<button type="submit" class="btn btn-primary mb-3">新增</button>
			</form>

	<table class="table table-striped" id="datatablesSimple">
		<thead class="thead-dark">
			<tr>
				<th scope="col">會員序號</th>
				<th scope="col">會員手機</th>
				<th scope="col">會員密碼</th>
				<th scope="col">會員姓名</th>
				<th scope="col">會員註冊日期</th>
				<th scope="col">會員最後登入日期</th>
				<th scope="col">編輯</th>
				<th scope="col">刪除</th>
			</tr>

		</thead>

		<tbody>
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td>${member.memberId}</td>
					<td>${member.memberPhoneNumber}</td>
					<td>${member.memberPassword}</td>
					<td>${member.memberName}</td>
					<td>${member.memberRegistrationTime}</td>
					<td>${member.memberLastLoginTime}</td>
					
					
					<td><form:form
							action="${contextRoot}/Store/Commodity/editCommodity"
							method="get">
							<input type="hidden" name="memberId"
								value="${member.memberId}">
							<button type="submit" class="btn btn-warning">編輯</button>


						</form:form></td>
					<td><form:form action="${contextRoot}/Store/Commodity/delete"
							method="DELETE">
							<input type="hidden" name="memberId"
								value="${member.memberId}">
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