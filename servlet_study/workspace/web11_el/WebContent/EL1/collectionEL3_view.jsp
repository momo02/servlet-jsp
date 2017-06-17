<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">1.우승자 명단</h2>

1등 : ${requestScope.winner[1]}
2등 : ${requestScope.winner[2]}
3등 : ${requestScope.winner[0]}
<hr>
<h2 align="center">2.이 달에 가장 많이 팔린 과일..(사과, 포도, 레몬순)</h2>
${requestScope.items[0]} <br/>
${requestScope.items[1]} <br/>
${requestScope.items[2]} <br/>
<hr>
<h2 align="center">3. Edgr의 주소를 출력</h2>
James의 주소는 :: ${sessionScope.map["James"]} <br/>
이렇게도 나옵니다.
${map["James"] }
${map.get("James") }
<br/>

Gosling의 주소는 :: ${sessionScope.map["Gosling"]} <br/>

Edgr가 사는 곳은 ${sessionScope.map["Edgar"]} 입니다.<br/>
${param.name}가 사는 곳은 ${map[param.name]}입니다.  <br/>



</body>
</html>