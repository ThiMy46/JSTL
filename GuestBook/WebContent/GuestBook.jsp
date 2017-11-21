<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<%-- set data source--%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost/GuestBook"
	user="root"
	password="12345" />
<%-- query --%>
<sql:query var="items" sql="SELECT * FROM `guestbook1111`" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List guest book</title>
</head>
<body>

	<table border='1'>
		<tr><th>Key</th><th>Name</th><th>Message</th></tr>
		<c:forEach items="${items.rows}" var="row">
		<tr>
				<td>${row.Key }</td>
				<td>${row.Name }</td>
				<td>${row.Message }</td>
				<td><a href="EditComment.jsp?Key=${row.Key}&Name=${row.Name}&Message=${row.Message}">Edit</a>
				|<a href="DeleteGuestBook?Key=${row.Key}">Delete</a></td>

		</tr>
				
		</c:forEach>
	</table>
	<p><a href='AddComment.jsp'>Leave a comment</a></p>
	
</body>
</html>