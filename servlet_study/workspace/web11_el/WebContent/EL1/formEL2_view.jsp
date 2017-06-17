<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	String id = request.getParameter("id");
	//check box에 담긴 값은 이렇게 받는다.
	String[] pets = request.getParameterValues("pet");

	for(String p : pets){
		
		out.println(p + "<br/>");
		
	}
%>

아이디 : ${param.id} <br/>
선택한 얘완동물 : ${paramValues.pet[0]} <br/>
선택한 얘완동물 : ${paramValues.pet[1]} <br/>
선택한 얘완동물 : ${paramValues.pet[2]} <br/>
선택한 얘완동물 : ${paramValues.pet[3]} <br/>
선택한 얘완동물 : ${paramValues.pet[4]} <br/>
선택한 얘완동물 : ${paramValues.pet[5]} <br/>
선택한 얘완동물 : ${paramValues.pet[6]} <br/>
</body>
</html>