<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.simplilearn.dao.RegisterDao"%>
    
<jsp:useBean id="obj" class="com.simplilearn.model.User"/>

<jsp:setProperty property="*" name="obj"/> 

<% 
int status=RegisterDao.register(obj);
if(status > 0)
	out.print("Registered Successfully !!!");
%>