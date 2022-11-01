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
	<h3>메인페이지입니다</h3>	
<c:choose>
		<c:when test="${!empty sessionScope.userid }">
			<p>${id}님 어서오세요</p>
			<c:if test="${sessionScope.userid =='admin'}">
				<a href="admin.do">회원관리</a>
			</c:if>
			<a href="logout.do">로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="login.do">로그인</a><br>
			<a href="join.do">회원가입하러가기</a>
		</c:otherwise>
	</c:choose>
</body>
</html>