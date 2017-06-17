<%--
  Created by IntelliJ IDEA.
  User: chunkind
  Date: 2017. 4. 24.
  Time: PM 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 찾기</title>
</head>
<body>
<div style="text-align: center; margin-top: 10%;">
    <form method="post" action="boardSelectServlet.go">
        <h1>게시물 번호를 입력하시오.</h1>
        <input type="text" name="seq" />
        <input type="hidden" name="page" value="${page}" />
        <input type="submit" value="${page}" />
    </form>
</div>
</body>
</html>
