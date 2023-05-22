<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="common.JDBCConnect_new" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 목록 조회 테스트</h2>
	<%
		JDBCConnect_new jdbc = new JDBCConnect_new();
		Connection con = jdbc.getConnection();
		if(con == null){
			out.print("");
			return;
		}
		String sql = "Select * from member";
		Statement stmt =con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			String id = rs.getString("id");
			String pass = rs.getString("pass");
			String name = rs.getString("name");
			java.sql.Date regidate = rs.getDate("regidate");
			out.println(String.format("%s %s %s %s", id, pass, name, regidate) + "<br/>"); 
			
		}
		
		jdbc.closeConnection(con);
	%>
</body>
</html>