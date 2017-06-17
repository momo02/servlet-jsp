<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="loginServlet.do"> <!-- /써주지않을것 주의!!! -->
		<input type="text" name="id" />
		<input type="password" name="pass" />
		<button type="submit">로그인</button>
	</form>
</body>
</html>