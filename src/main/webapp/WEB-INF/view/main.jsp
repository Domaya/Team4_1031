<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="/common/top.jsp"></jsp:include>
	

	<div class="container justify-content-center mt-3">
	<div class="center-block d-grid gap-2 ">

	<c:choose>
		<c:when test="${!empty sessionScope.userid }">
		<h1 class="display-3">${sessionScope.userid}님 어서오세요</h1><br>
			<c:if test="${sessionScope.userid =='admin'}">
				<a class="btn btn-outline-primary btn-lg" href="admin.do" role="button">회원관리</a><br>
			</c:if>
				<a class="btn btn-outline-dark btn-lg" href="logout.do" role="button">로그아웃</a><br>
		</c:when>
		<c:otherwise>
			<a class="btn btn-secondary btn-lg" href="login.do" role="button">로그인</a><br>
			<a class="btn btn-secondary btn-lg" href="join.do" role="button">회원가입하러가기</a>
		</c:otherwise>
	</c:choose>
		<br>
		
		
		</div>
</div>
</body>
</html>