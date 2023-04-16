<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session JSP</title>
</head>
<body>
	<% String name = (String)session.getAttribute("username");
	out.print("Username from session::" + name);
	%>
	<br>
	<br>
	<%
	String mysqlDriver =  (String)session.getAttribute("mysql-driver");
	out.print("Mysql Driver from session::" + mysqlDriver);
	%>
</body>
</html>