<%--
  Created by IntelliJ IDEA.
  User: chunkind
  Date: 2017. 4. 24.
  Time: PM 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게시물 등록</title>
    <style>
    	th{
    		background-color: #D4F4FA;
    	}
    	td{
    		background-color: #FAF4C0;
    	}
    </style>
</head>
<body>
<div style="text-align: center; margin-top: 10%;">
    <h1>게시물 리스트</h1>
    <table align="center" style="width: 600px;">
        <colgroup>
            <col style="width: 10%;" />
            <col style="width: 50%;" />
            <col style="width: 20%;" />
            <col style="width: 20%;" />
        </colgroup>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>등록일</th>
        </tr>
        <c:forEach items="${list }" var="val" varStatus="status">
        	<tr>
        		<td>${val.seq }</td>
        		<td>${val.title }</td>
        		<td>${val.user_id }</td>
        		<td>${val.reg_date }</td>
        	</tr>
        </c:forEach>
    </table>
    <a href="index.jsp">홈으로</a>
</div>
</body>
</html>
