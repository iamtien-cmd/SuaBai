<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<form action="${pageContext.request.contextPath}/admin/author/update"
      method="post" enctype="multipart/form-data">
	<input type="text"
		id="author_id" name="author_id" value="${author.author_id}" hidden="hidden"><br>
	<label for="fname">Name:</label> <br> 
	<input type="text"
		id="author_name" name="author_name" value="${author.author_name}"><br>
	<label for="fname">Date of birth:</label> <br> 
	<input type="date"
		id="date_of_birth" name="date_of_birth" value="${author.date_of_birth}"><br>
	<input
		type="submit" value="Sửa">
</form>

<!--  enctype="multipart/form-data" -->