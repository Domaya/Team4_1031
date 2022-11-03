<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
 <jsp:include page="/common/top.jsp"></jsp:include>
 <div class="container"  style="float: none; margin:100 auto;"></div>
				<form action="memberUpdate.do" method="post">
					<h3 style="text-align: center;">회원정보수정</h3>
					<div>
						<table
							style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
							<tr>
								<td>아이디</td>
								<td>
								  	<input type="text" name="id" value="${member.id }" readonly>
								</td>
							</tr>
							<tr>
								<td>비번</td>
								<td>"${member.pwd}"</td>							</tr>
							<tr>
								<td>이름</td>
								<td>
									<input type="text" name="name" value="${member.name}" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>나이</td>
								<td>
									<input type="text" name="age" value="${member.age}" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>성별</td>
								<td>
								
									
									[${member.gender}]
                             <input type="radio" name="gender" id="gender" value="여"
                             <c:if test ="${member.gender eq '여 '}">
                             checked
                             </c:if>>여자
                           <input type="radio" name="gender" id="gender" value="남"
                           <c:if test ="${member.gender eq '남 '}">
                             checked
                             </c:if>>남자
							

							
							
								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>
									<input type="text" name="email" value="${member.email}" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="submit" value="수정하기">
								<a href="admin.do">리스트 이동</a></td>
						</table>

					</div>
				</form>

</body>
</html>