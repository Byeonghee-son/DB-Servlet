<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>한번의 매핑으로여러가지 요청처리하기</h3>
	${ resultValue }
	<ol>
		<li>URI : ${ uri }
		<li>요청명 : ${commandStr }</li>
	</ol>
	<ul>
		<li><a href="./13Servlet/regist.one">회원가입</a></li>
		<li><a href="./13Servlet/login.one">로그인</a></li>
		<li><a href="./13Servlet/freeboard.one">자유게시판</a></li>
	</ul>
</body>
</html>