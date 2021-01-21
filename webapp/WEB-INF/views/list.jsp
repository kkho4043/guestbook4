<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>guest book</h1>
	<form action = "${pageContext.request.contextPath}/guest/write" method = "get">
		<table border = "1" width = 500>
			<tr>
				<td>이름</td>
				<td><input type ="text" name = "name"></td>
				<td>비밀번호</td>
				<td><input type ="text" name = "password"></td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea rows=10 cols=65 name = "content">
					</textarea>
 				</td>
			</tr>
			<tr>
				<td colspan="4"><button>확인</button></td>
			</tr>
		</table>
	</form>

	<c:forEach items="${requestScope.gList}" var= "guestVo">
	<br>
	<table border = 1 width = 500>
		<tr>
			<td>${guestVo.guestno} </td>
			<td>${guestVo.name}</td>
			<td>${guestVo.date}</td>
			<td><a href= "${pageContext.request.contextPath}/guest/confirmpassword/modifyForm/${guestVo.guestno}">수정</a></td>
			<td><a href= "${pageContext.request.contextPath}/guest/confirmpassword/delete/${guestVo.guestno}">삭제</a></td>
			
		</tr>
		<tr>
			<td colspan="5">${guestVo.content}</td>
		</tr>
	</table>
	</c:forEach>
	
</body>
</html>

