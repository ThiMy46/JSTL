<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Comment</title>
</head>
<body>
	<h2>Comment</h2>
	<form action='AddComment' method='post'>
		<input type='text' name='Name' placeholder='Name' style='margin-bottom: 10px;' required/> <br/>
		<textarea name='Message' placeholder='Message' rows='5' cols='60' required></textarea>
		<input type='submit' name='Add' value='Add' margin-left: 0px;'>
	</form>
</body>
</html>


