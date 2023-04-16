<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX JSP</title>
</head>
<body>
<h1><u>USER REGISTRATION FORM</u></h1>
<form action="process.jsp">
<input type="text" name="uname" value="Name: " onclick="this.value''"/>
<input type="text" name="uemail" value="Email ID: " onclick="this.value''"/>
<input type="password" name="upass" value="Password: " onclick="this.value''"/>
<input type="submit" value="REGISTER">
</form>
</body>
</html>