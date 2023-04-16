<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PROCESS JSP</title>
</head>
<body>
<%
String number1 = request.getParameter("n1");
String number2 = request.getParameter("n2");

int a = Integer.parseInt(number1);
int b = Integer.parseInt(number2);

int c = a/b;

out.print("division of " +  a + " and " + b + " is: " + c);
%>
</body>
</html>