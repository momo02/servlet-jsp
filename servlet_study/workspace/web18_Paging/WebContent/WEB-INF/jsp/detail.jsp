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
    <title>게시물 상세</title>
    <style>
        th{
            background-color: aquamarine;
        }
    </style>
</head>
<body>
<div style="text-align: center; margin-top: 10%;">
    <h1>게시물 상세</h1>
    <table align="center" style="width: 600px;">
        <colgroup>
            <col style="width: 25%;" />
            <col style="width: 25%;" />
            <col style="width: 25%;" />
            <col style="width: 25%;" />
        </colgroup>
        <tr>
            <th>글쓴이</th>
            <td>${rvo.user_id}</td>
            <th>등록일</th>
            <td>${rvo.reg_date}</td>
        </tr>
        <tr>
            <th>제목</th>
            <td>${rvo.title}</td>
            <th>글번호</th>
            <td>${rvo.seq}</td>
        </tr>
        <tr>
            <td colspan="4">${rvo.content}</td>
        </tr>
    </table>
    <a href="index.jsp">홈으로</a>
</div>
</body>
</html>
