<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login페이지</title>
</head>
<body>
<div>context.getAttribute("message")</div>
<div></div>

<!-- 이것은 html주석 -->
<%-- 이것은 jsp주석 :소스보기로 안보임,   자바주석으로 변경됨 --%> 

<!-- config, pageContext, application 은 내장객체 .. 
나중에 jsp가  java로 변경될떄 이 객체들은 이미 import되어있기때문에 이렇게 바로 사용할 수 있다.
-->

<%= config.getServletContext().getAttribute("message") %>
<%= pageContext.getServletContext().getAttribute("message") %>
<%= application.getAttribute("message") %>


<!-- el : applicationScope > sessionScope > requestScope(디폴트) > pageScope -->

<div>${applicationScope.message}</div>


<div>${send}</div> <!-- requestScope.send 인데 requestScope가 디폴트이므로 생략가능  -->

</body>
</html>
