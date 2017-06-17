<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<h1>로그인 페이지</h1>
	<form method="post" action="DispatcherServlet.do">
		<input type="hidden" name="page" value="do_login"/>
		<label for="">아이디</label>
		<input type="text" name="user_id" /><br/>
		<label for="">비밀번호</label>
		<input type="password" name="user_pw" /><br/>
		<input type="submit" value="login" />
	</form>
</body>
</html>