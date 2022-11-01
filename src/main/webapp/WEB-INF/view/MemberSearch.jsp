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
	<h3>회원검색페이지</h3>
	<table>
		<c:forEach var="member" items="${requestScope.searchMemberlist}" varStatus="status">
		<tr>
			<td>${member.id}</td>
			<td>${member.name}</td>
			<td>${member.email}</td>
		</tr>
		</c:forEach>
		<tr>
			<td>[${requestScope.searchvalue}]에 대한 회원목록 검색 결과</td>
		</tr>
	</table>
	<a href="admin.do">돌아가기</a>
</body>
</html>