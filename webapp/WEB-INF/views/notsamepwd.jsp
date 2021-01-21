<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	비밀번호가 틀렸습니다.<br>
	<a href= "${pageContext.request.contextPath}/guest/confirmpassword/${where}/${no}">다시입력하기</a>
	<a href= "${pageContext.request.contextPath}/guest/list">리스트로가기</a>
</body>
</html>