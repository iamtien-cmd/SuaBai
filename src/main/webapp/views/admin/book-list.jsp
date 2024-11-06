<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" , width=100%>
	<tr>
		<th>STT</th>
		<th>Book ID</th>
		<th>Description</th>
		<th>ISBN</th>
		<th>Price</th>
		<th>publish_date</th>
		<th>publisher</th>
		<th>quantity</th>
		<th>title</th>
		<th>cover_image</th>
		<th>Review(10)</th>
	</tr>
	<c:forEach items="${listbook}" var="book" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>
			<td>${book.bookid}</td>
			<td>${book.description}</td>
			<td>${book.isbn}</td>
			<td>${book.price}</td>
			<td>${book.publish_date}</td>
			<td>${book.publisher}</td>
			<td>${book.quantity}</td>
			<td>${book.title}</td>
			<td>${book.cover_image}</td>
			<td><a href="${pageContext.request.contextPath}/admin/book/details?id=${book.bookid}">Detail</a> </td>
			
		</tr>
	</c:forEach>
</table>
</body>
</html>