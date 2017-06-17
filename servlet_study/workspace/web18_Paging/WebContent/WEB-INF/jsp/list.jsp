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
    <script type="text/javascript">
    function fn_detail(seq){
    	location.href = "DispatcherServlet.do?page=do_selectOne&seq=" + seq;
    }
    </script>
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
        	<tr onclick="fn_detail('${val.seq}')" style="cursor: pointer;">
        		<td>${val.seq }</td>
        		<td>${val.title }</td>
        		<td>${val.user_id }</td>
        		<td>${val.reg_date }</td>
        	</tr>
        </c:forEach>
    </table>
    
    <!-- new paging 추가 -->
    <div>
	<%-- 이전 페이지 그룹이 있으면 이미지 보여준다.
	  이미지 링크는 현 페이지 그룹 시작페이지 번호 -1 =>
	   이전 페이지 그룹의 마지막 페이지 번호로 한다. 
	 --%>
	<c:if test="${paging.previousPageGroup}">
		<a href="DispatcherServlet.do?page=do_selectAll&currentPg=${paging.startPageOfPageGroup-1}">◀</a>
	</c:if>
	<%-- PagingBean 을 이용해서 현재 페이지에 해당되는 페이지그룹의
	   시작페이지~~마지막페이지까지 화면에 보여준다. 
	   이 때 현재 페이지를 제외한 나머지 페이지는 링크를 걸어
	   해당 페이지에 대한 게시물 리스트 조회가 가능하도록 한다. 
	 --%>
	<c:forEach var="i" begin="${paging.startPageOfPageGroup}" end="${paging.endPageOfPageGroup}">
		<c:choose>
			<c:when test="${paging.nowPage!=i}">
				<a href="DispatcherServlet.do?page=do_selectAll&currentPg=${i}">${i}</a>
			</c:when>
			<c:otherwise>
				${i}
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<%-- 다음 페이지 그룹이 있으면 화살표 이미지를 보여준다.
		이미지 링크는 현재 페이지 그룹의 마지막 번호 + 1 => 
		다음 그룹의 시작 페이지로 링크한다. 
		right_arrow_btn.gif
	 --%>
	<c:if test="${paging.nextPageGroup}">
		<a href="DispatcherServlet.do?page=do_selectAll&currentPg=${paging.endPageOfPageGroup+1}">▶</a>
	</c:if>
	</div>
    <!-- //new paging 추가 -->
    
    <a href="index.jsp">홈으로</a>
</div>
</body>
</html>
