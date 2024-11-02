<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<label for="username"> Username:</label> 
		<input type="text"
			id="username" name="username" required><br> 
		<label
			for="password">Password:</label> 
		<input type="password" id="password"
			name="password" required><br>
		<button type="submit">Login</button>
	</form>
</body>
</html>