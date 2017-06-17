<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Attribute에 바인된 값을 가져옵니다..</h2>
<b>1~100까지의 합산의 결과 : 1)Basic Element :: </b>
<%= request.getAttribute("RESULT") %>
<%= session.getAttribute("RESULT") %>
<hr>
<p>
<b>1~100까지의 합산의 결과 : 2)EL ::</b>
${ requestScope.RESUIT } , ${ RESUIT }
${ sessionScope.RESUIT } 



<b>7더한값 : ${RESULT + 7}</b> 


<!--  EL표현식 내부에서는 '+'연산자는 숫자연산만 가능합니다. 사칙연산시 양쪽 변수를 정수로 취급하기 때문 입니다. -->

<!--  

* attribute

applicationScope > sessionScope > requestScope > pageScope 

${~Scope.value}

-->
<!-- 
* parameter

 ${param.value} 
 
 -->


</body>
</html>