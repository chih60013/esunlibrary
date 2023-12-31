<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>
<html>

<head>
<style>
.center-content {
	display: flex;
	flex-direction: column;
	/* 垂直排列 */
	justify-content: center;
	align-items: center;
	height: 10vh;
	/* 可以調整高度，以保持表格在中間 */
}
</style>
</head>

<body class="sb-nav-fixed">
	<div id="layoutSidenav">

		<!-- ======= SiderNav ======= -->
		<jsp:include page="../layout/sideNavForBack.jsp"></jsp:include>
		<!-- End SiderNav -->

	</div>
	<div>
		<main id="main">

			<h1 class="center-content">驗證碼</h1>
			<div class="center-content">
				<form:form method="post" modelAttribute="member"
					action="${contextRoot}/member/post">
					<form:label path="memberPhoneNumber">會員電話(將會做帳號使用)</form:label>
					<form:input path="memberPhoneNumber" type="text" required="true" />
					<br>

					<c:if test="${not empty errorMessage}">
						<div style="color: red;">${errorMessage}</div>
					</c:if>
					<form:label path="memberPassword">會員密碼</form:label>
					<form:input path="memberPassword" type="password" required="true" />
					<br>
					<form:label path="memberName">會員姓名</form:label>
					<form:input path="memberName" type="text" required="true" />
					<br>

					<button type="submit" value="確定">送出</button>
				</form:form>


				<div class="form-group">
					<label for="verification">請輸入驗證碼:</label> <input type="text"
						class="form-control" id="verification" name="verification"
						required>
				</div>
			</div>

		</main>

	</div>

	<!-- ======= Footer ======= -->
	<jsp:include page="../layout/footerForBack.jsp"></jsp:include>
	<!-- End Footer -->




</body>

</html>