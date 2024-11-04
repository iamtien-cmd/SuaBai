<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%-- <form action="<c:url value='${pageContext.request.contextPath}/admin/author/insert'></c:url>"--%>
<form action="${pageContext.request.contextPath}/admin/author/insert"
	method="post" enctype="multipart/form-data">
	<label for="fname">Author name:</label> <br> <input type="text"
		id="author_name" name="author_name" value=""><br> 
		<label>Date of birth</label><br>
		<input type="date" id="date_of_birth" name="date_of_birth" value=""><br>
		
		<input type="submit" value="Insert">
</form>

<!--  enctype="multipart/form-data" -->