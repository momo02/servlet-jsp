<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : <%= request.getParameter("id")%> </br>
	비밀번호 : <%= request.getParameter("pwd")%>
	<%-- request, response는 내장객체라서 import하지 않고도 사용할 수 있다. --%>
</body>
</html>