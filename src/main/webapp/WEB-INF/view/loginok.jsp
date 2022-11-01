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
<c:set var="userid" value="${requestScope.id}" />
<c:set var="id" value="${requestScope.id}" />
<c:set var="pwd" value="${requestScope.pwd}" />

				<%
					String id = null;
					id = (String)session.getAttribute("userid");
					
					if(id != null){
						//회원
						out.print(id + " 회원님 어서오세용<br>");
						if(id.equals("admin")){
							out.print("<a href='admin.do'>회원관리</a>");
						}
					}else{
						//로그인 하지 않은 사용자
						//메인 페이지는 회원만 볼수 있어요 (강제 링크 추가)
						out.print("사이트 방문을 환영합니다 ^^ <br>");
					}
				%>

<h3>로그인성공</h3><br>
${id}<br> 
${pwd }<br>
<a href="logout.jsp">로그아웃</a>
<hr>
<%=request.getAttribute("id") %>
<%=request.getAttribute("pwd") %>
</body>
</html>