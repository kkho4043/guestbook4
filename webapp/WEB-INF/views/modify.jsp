<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "${pageContext.request.contextPath}/guest/modify" method="get"> 
	<input type="hidden" name = "guestno" value = "${gList.guestno}">
	이름 : <input type="text" name = "name"  value = "${gList.name}"> <br>
	내용 : <input type="text" name = "content" value = "${gList.content}"> <br>
	<button type = "submit">변경</button>	
	</form>
</body>
</html>