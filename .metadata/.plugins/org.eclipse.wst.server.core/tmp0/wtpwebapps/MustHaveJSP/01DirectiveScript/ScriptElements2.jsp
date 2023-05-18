<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!public int add(int num1, int num2) {
		return num1 + num2;
	}%>

<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
	<%
	String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    int result = 0;

    if (num1 != null && num2 != null) {
        result = add(Integer.parseInt(num1), Integer.parseInt(num2));
    }
	%>
	덧셈 결과 1 :
	<%=result%>
	<br /> 덧셈 결과 2 :
	<%=add(30, 40)%>
</body>
</html>