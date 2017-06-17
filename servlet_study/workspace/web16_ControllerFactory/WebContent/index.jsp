<%--
  Created by IntelliJ IDEA.
  User: chunkind
  Date: 2017. 4. 24.
  Time: PM 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.rvo}">
			<script>
			    location.href = "DispatcherServlet.do?page=login";
			</script>
		</c:when>
		<c:otherwise>
			<script>
			    location.href = "DispatcherServlet.do";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>

