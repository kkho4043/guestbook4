<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "${pageContext.request.contextPath}/guest/notsamepwd/${where}/${no}" method="get" >
			비밀번호: <input type="text" name = "pwd">
			<button type = "submit">확인</button>	
	</form>
	<a href= "${pageContext.request.contextPath}/guest/list">리스트로가기</a>
</body>
</html>