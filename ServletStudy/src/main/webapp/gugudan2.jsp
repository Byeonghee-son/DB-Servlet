<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%     
    String type = request.getParameter("type");
    String scol = request.getParameter("col");
    
    if(type == null) type = "list";
    else{
    	if(!type.equals("table")) type = "list";
    }
    
    int col = 3;
    if(scol != null) col = Integer.parseInt(scol);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan Type2 (JSP)</title>
</head>
<body>
	<h2>구구단 타입 1</h2>
<% 
	for(int i = 2; i < 10; i+=col){
		for(int k = 1; k < 10; k++) {
		 for(int j = 0; j < col; j++){ 
				if(9 < i + j) break; 
					out.print(String.format("%d*%d=%d " , i+j, k, (i+j)*k));
			} 
				out.print("<br>");
		} 
			out.print("<br>");
	} 
	
%>

</body>
</html>