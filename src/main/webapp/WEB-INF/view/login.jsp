<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post" name="loginform">

ID : <input type="text" name="id" id="id" placeholder="아이디"><br>
PWD : <input type="password" name="pwd" id="pwd" placeholder="비밀번호"><br>
<input type="submit" value="제출">
</form>
<div></div>

</body>
</html>