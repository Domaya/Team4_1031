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
<h3>회원관리 페이지(관리자용)</h3>
	<table class="table table-hover">
	<thead>
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>회원아이피</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="member" items="${requestScope.memberlist}">
		<tr>
			<td name="${member.name}">${member.name}</td>
			<td name="${member.id}">${member.id}</td>
			<td>${member.ip}</td>
			<td><a href="memberDelete.do?id=${member.id}">[삭제]</a></td>
			<td><a href="memberUpdateForm.do?id=${member.id}">[수정]</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<hr>
	<form action="memberSearch.do" method="post">
			<label for="nameinput" class="form-label m-3">이름 검색하기</label>
			<input type="text" class="col-xs-3" id="nameinput"  name="search">
			<input type="submit" class="btn btn-outline-dark m-3" name="searchvalue" value="검색">
	</form>
</body>
</html>