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
	<h3>메인페이지입니다</h3>
	<a href="login.jsp">로그인하기</a>
<a href="join.jsp">회원가입하기</a>
<c:choose>
		<c:when test="${!empty sessionScope.id }">
			<p>${id}님 어서오세요</p>
			<c:if test="${sessionScope.id =='admin'}">
				<a href="admin.do">회원관리</a>
			</c:if>
			<a href="logout.do">로그아웃</a>
		</c:when>
		<c:otherwise>
			<p>사이트 방문을 환영합니다 ^^ <br><a href="register.do">회원가입하러가기</a></p>
		</c:otherwise>
	</c:choose>
</body>
</html>