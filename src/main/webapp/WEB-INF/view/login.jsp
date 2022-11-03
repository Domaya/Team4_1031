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


	<div class="container justify-content-center" style="float: none; margin:100 auto;">
		<form class="mt-3" action="loginok.do" method="POST" name="loginform">

			  <label for="ID" class="form-label col-6">ID</label>
			  <input type="text" class="form-control  col-6" id="id" name="id" placeholder="아이디를 입력하세요">
			  <label for="PASSWORD" class="form-label ">PASSWORD</label>
			  <input type="password" class="form-control col-6" id="pwd"  name="pwd" placeholder="비밀번호를 입력하세요">

			  	<input type="submit" class="btn btn-outline-dark col-2 mt-3 mb-3" name="searchvalue" value="로그인">
		</form>
		<a href="main.do">돌아가기</a>
	</div>
</body>
</html>
