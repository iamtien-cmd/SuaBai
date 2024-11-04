<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Author List</title>
</head>
<body>
<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Author ID</th>
        <th>Author Name</th>
        <th>Date of birth</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listauthor1}" var="author" varStatus="STT">
        <tr>
            <td>${STT.index + 1}</td>
            <td>${author.author_id}</td>
            <td>${author.author_name}</td>
            <td>${author.date_of_birth}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/author/update?id=${author.author_id}" class="center">Sửa</a> |
                <a href="${pageContext.request.contextPath}/admin/author/delete?id=${author.author_id}" class="center">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
