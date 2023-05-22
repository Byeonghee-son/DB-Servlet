<%@ page import ="java.sql.PreparedStatement" %>
<%@ page import ="java.sql.Connection" %>
<%@ page import ="common.JDBCConnect_new" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 추가 테스트(ExecuteUpdate() 사용)</h2>
	<%
	JDBCConnect_new jdbc = new JDBCConnect_new();
	
	String id = "test1";
	String pass = "1111";
	String name = "테스트1 회원";
	
	Connection con = jdbc.getConnection();
	if(con == null){
		out.print("");
		return;
	}
	String sql = "Insert into member(id, pass, name) VALUES (?,?,?)";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, id);
	ps.setString(2, pass);
	ps.setString(3, name);
	
	int inResult = ps.executeUpdate();
	out.println(inResult + "행이 입력 되었습니다.");
	
	jdbc.closeConnection(con);
	%>
</body>
</html>