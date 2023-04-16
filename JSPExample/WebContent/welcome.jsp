<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example</title>
</head>
<body>
<!--  JSP Scriptlet Tag  -->
<% 
String name = request.getParameter("uname");
out.print("Welcome: " + name + " to our jsp page");
%>
<br>

<%
String driver = config.getInitParameter("mysql-driver-class");
out.print("Mysql Driver:: "+ driver);

session.setAttribute("username", name);
session.setAttribute("mysql-driver", driver);
%>
<br>
<br>
<a href = "session.jsp">Session JSP</a>
<br>
<br>
<!--  JSP Expression Tag  -->
Current Time: <%= java.util.Calendar.getInstance().getTime() %>

<br>
<br>
<!--  JSP Declaration Tag  -->
<%! int cube(int n){
	return n * n * n;
} %>

<br>
<%= "Cube of number 5 is:: " + cube(5) %>

<br>
<br>


<%@ include file="include.html" %>

</body>
</html>