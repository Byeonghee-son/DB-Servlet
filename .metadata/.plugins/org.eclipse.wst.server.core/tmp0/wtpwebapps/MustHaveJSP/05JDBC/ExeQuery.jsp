<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="common.JDBConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>목록 조회 테스트</h2>
	<%
		JDBConnect jdbc = new JDBConnect();
		
		String sql = "Select * from board";
		Statement stmt = jdbc.con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			int num = rs.getInt("num");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String id = rs.getString("id");
			java.sql.Date postdate = rs.getDate("postdate");
			int visitcount = rs.getInt("visitcount");
			out.println(String.format("%d %s %s %s %s %s", num, title, content, id, postdate, visitcount) + "<br/>"); 
			
		}
		
		jdbc.close();
	%>
</body>
</html>