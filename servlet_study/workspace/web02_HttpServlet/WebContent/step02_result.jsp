<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- html주석 (브라우저창에서 소스보기하면 보임) -->
<%-- jsp주석 (브라우저창에서 소스보기해도 보이지않음) --%>
<%--
1.스크립틀릿 : 자바코드를 쓰는곳.
<% 자바코드가 들어간다. %>

2.익스프레션 : servlet 에서 out.print();
<%= 스크립틀릿 변수 %>


 --%>
</head>
<body>
 <% request.setCharacterEncoding("UTF-8"); %>
 이름 : <%= request.getParameter("name") %> <br>
 나이 : <%= request.getParameter("age") %>
  <%-- request, response는 내장객체라서 import하지 않고도 사용할 수 있다. --%>
</body>


</html>