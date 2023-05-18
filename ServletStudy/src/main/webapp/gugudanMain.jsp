<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String ssel = request.getParameter("sel");
    String sval = request.getParameter("val");
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(ssel.equals("gugudanType1")){
		//response.sendRedirect("gugudan1.jsp?num=" + sval);
		request.getRequestDispatcher("gugudan1.jsp?num=" + sval).forward(request, response);
	} else {
		request.getRequestDispatcher("gugudan2.jsp?col=" + sval).forward(request, response);
		//response.sendRedirect("gugudan2.jsp?col=" + sval);
	}
	
%>

</body>
</html>