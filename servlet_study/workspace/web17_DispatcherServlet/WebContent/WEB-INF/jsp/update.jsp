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
    <title>게시물 수정</title>
</head>
<body>
<div style="text-align: center; margin-top: 10%;">
    <h1>게시물 수정</h1>
    <form action="DispatcherServlet.do?page=do_update" method="post">
        <label for="user_id" >글쓴이 : </label>
        <input type="text" name="user_id" id="user_id" value="${rvo.user_id }" />
        <label for="reg_date">등록일 : </label>
        <input type="text" name="reg_date" id="reg_date" readonly="readonly" value="${rvo.reg_date}" /><br/>
        <label for="title">제목 : </label>
        <input type="text" name="title" id="title" value="${rvo.title }" />
        <label for="seq">글번호 : </label>
        <input type="text" name="seq" id="seq" readonly="readonly" value="${rvo.seq}" /><br/>
        <textarea name="content" cols="25" rows="20" >${rvo.content }</textarea><br/>
        <input type="submit" value="글수정" />
    </form>
</div>
</body>
</html>
