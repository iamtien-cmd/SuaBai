<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<input type="text"
		id="bookid" name="bookid" value="${book.bookid}" hidden="hidden"><br>
	<label for="fname">ISBN:</label> <br> 
	<input type="text"
		id="isbn" name="isbn" value="${book.isbn}"><br>
	<label for="fname">Publisher:</label> <br> 
	<input type="text"
		id="publisher" name="publisher" value="${book.publisher}"><br>
	<input type="date"
		id="date_of_birth" name="date_of_birth" value="${book.publisher_date}"><br>
	<input
		type="submit" value="Sửa">
</body>
</html>