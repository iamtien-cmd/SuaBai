<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath }/admin/author/add"
	method="post" enctype="multipart/form-data">
   
	<label for="author_name">Author name:</label><br>
	<input type="text" id="author_name" name="author_name" value=""><br> 
	<input type="date" id = "date_of_birth" name="date_of_birth" value=""><br>
	 
	<input type="submit" value="add">
</form>