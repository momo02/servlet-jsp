<%--
  Created by IntelliJ IDEA.
  User: chunkind
  Date: 2017. 4. 24.
  Time: PM 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>선택하세요.</title>
</head>
<body>
	
	<%-- 
		if, choose 문에 들어가는 제어문
		==        :    eq
		!=        :    ne
		!= null   :    not empty
		== null   :    empty
	--%>
	<%-- <c:if test="${sessionScope.rvo ne null}"> --%>
	<%-- <c:if test="${sessionScope.rvo != null}"> --%>
	<c:if test="${not empty sessionScope.rvo}">
		<h1>${sessionScope.rvo.user_id} 님 환영합니다.</h1><br/>
		<a href="DispatcherServlet.do?page=do_logout">logout</a>
	</c:if>
	
    <div style="text-align: center; margin-top: 15%;">
        <a href="DispatcherServlet.do?page=do_selectAll">게시물 리스트 보기</a><br/>
        <a href="DispatcherServlet.do?page=insert">게시물 등록</a><br/>
        <a href="DispatcherServlet.do?page=search_update">게시물 수정</a><br/>
        <a href="DispatcherServlet.do?page=search_delete">게시물 삭제</a><br/>
        <a href="DispatcherServlet.do?page=search_selectOne">게시물 검색 보기</a><br/>
    </div>
</body>
</html>
