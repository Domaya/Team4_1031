<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%

    // 세션값 초기화, 로그아웃할때 사용된다.

    session.invalidate();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그아웃되었습니다.</h3>
<a href="login.jsp">로그인하기</a>
</body>
</html>