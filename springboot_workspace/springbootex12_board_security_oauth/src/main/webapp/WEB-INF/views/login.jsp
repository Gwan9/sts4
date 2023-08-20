<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>커스텀 로그인</h2>
	
	<form action="/login" method="post">
		<input type="text" name="username" id="" />
		<input type="password" name="password" id="" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit" value="로그인" />
		
		<a href="oauth2/authorization/google">구글</a>
	</form>
</body>
</html>