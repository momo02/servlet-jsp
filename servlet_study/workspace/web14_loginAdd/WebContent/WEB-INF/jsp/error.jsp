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
    <title>에러페이지</title>
</head>
<body>
    <div style="text-align: center; margin-top: 10%;">
        <script>
            var msg = '${message}';
            if(''!=msg && 'null'!=msg){
                alert(msg);
            }
        </script>
        <h1>에러 페이지 입니당~</h1>
        <a href="index.jsp">홈으로...</a>
    </div>
</body>
</html>
