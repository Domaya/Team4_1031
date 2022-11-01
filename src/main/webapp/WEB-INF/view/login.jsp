<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="/common/top.jsp"></jsp:include>

<a href="main.do">돌아가기</a>

<form class="row g-3" action="loginok.do" method="post" name="loginform">
<div class="mb-3 col-auto">
  <label for="ID" class="form-label">ID</label>
  <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="아이디를 입력하세요">
</div>
<div class="mb-3 col-auto">
  <label for="PASSWORD" class="form-label">PASSWORD</label>
  <input type="password" class="form-control" id="exampleFormControlTextarea1"  placeholder="비밀번호를 입력하세요"></textarea>
</div>
	<input type="submit" value="제출">
</form>

</body>
</html>
