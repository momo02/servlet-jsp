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
    <title>게시물 찾기</title>
</head>
<body>
<div style="text-align: center; margin-top: 10%;">
    <form method="post" action="DispatcherServlet.do">
        <h1>게시물 번호를 입력하시오.</h1>
        <input type="text" name="seq" />
        <c:choose>
        	<c:when test="${page eq 'search_update'}">
        		<input type="hidden" name="page" value="update" />
        		<input type="submit" value="수정" />
        	</c:when>
        	<c:when test="${page eq 'search_delete'}">
        		<input type="hidden" name="page" value="do_delete" />
        		<input type="submit" value="삭제" />
        	</c:when>
        	<c:otherwise>
        	<%-- search_selectOne --%>
        		<input type="hidden" name="page" value="do_selectOne" />
        		<input type="submit" value="검색" />
        	</c:otherwise>
        </c:choose>
    </form>
</div>
</body>
</html>
