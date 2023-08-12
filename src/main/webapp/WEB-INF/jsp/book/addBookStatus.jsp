<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
    <style>
          #main-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh; /* 調整高度以使表單在中間 */
            padding-top: 60px; /* 與 navbar 高度相等 */
        }

        /* 內部容器用來置中表單 */
        .form-container {
            width: 400px;
        }

    </style>
</head>
<body class="sb-nav-fixed">
    <div id="layoutSidenav">
        <!-- ======= SiderNav ======= -->
        <jsp:include page="../layout/sideNavForBack.jsp"></jsp:include>
        <!-- End SiderNav -->
    </div>
    <div id="main-container">
        <main id="main" class="form-container">
            <h1 class="center-content">新增書籍狀態</h1>
            <div class="center-content">
                <form:form method="post" modelAttribute="bookStatus" action="${contextRoot}/book/postBookStatus">
                    <form:label path="bookStatusName">書本狀態名稱</form:label>
                    <form:input path="bookStatusName" type="text" required="true" />
                    <br>
                    <form:label path="bookStatusDesc">書本狀態敘述</form:label>
                    <form:input path="bookStatusDesc" type="text" required="true" />
                    <br>
                    
                    <button type="submit" value="確定">送出</button>
                </form:form>
            </div>
        </main>
    </div>
    <!-- ======= Footer ======= -->
    <jsp:include page="../layout/footerForBack.jsp"></jsp:include>
    <!-- End Footer -->
    
    
    
    
</body>
</html>
