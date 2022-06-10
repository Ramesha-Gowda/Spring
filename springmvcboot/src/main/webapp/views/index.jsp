<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Boot</title>
</head>
<body>
	Welcome to Springs
	
	<!-- <form action="add">
		Enter 1st number : <input type="text" name="num1"/><br/>
		Enter 2nd number : <input type="text" name="num2"/><br/>
		<input type="submit"/><br>
	</form> -->
	
	<form action="addAlien" method="post">
		Enter your id : <input type="text" name="aid"/>
		<br/>
		Enter your name : <input type="text" name="aname"/>
		<br/>
		<input type="submit"/><br>
	</form>
	
	<form action="getAlien" method="get">
		Enter your id : <input type="text" name="aid"/>
		<br/>
		<input type="submit"/><br>
	</form>
	
	<form action="getAlienByName" method="get">
		Enter your Name : <input type="text" name="aname"/>
		<br/>
		<input type="submit"/><br>
	</form>
</body>
</html>