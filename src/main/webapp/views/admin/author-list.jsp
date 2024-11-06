<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
 <form action="${pageContext.request.contextPath}/admin/author/search" method="post">
        <input type="text" name="name" placeholder="Search by name" value="${name}">
        <button type="submit">Search</button>
    </form>
<a href="${pageContext.request.contextPath}/admin/author/insert">Add
	author</a>
<table border="1" , width=100%>
	<tr>
		<th>STT</th>
		<th>Author ID</th>
		<th>Author Name</th>
		<th>Date of birth</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${listauthor}" var="author" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>
			<td>${author.author_id}</td>
			<td>${author.author_name }</td>
			<td>${author.date_of_birth }</td>
			<td>
			<a
				href="<c:url value="/admin/author/update?id=${author.author_id }" />"
				class="center">Sửa </a> |
			<a
				href="<c:url value="/admin/author/delete?id=${author.author_id }"/>"
				class="center">Xóa </a></
				</td>
		</tr>
	</c:forEach>
</table>
<form action="">
Page size:
<select
name="size" id="size"
onchange="this.form.submit()">
<option ${authorPage.size == 6 ? 'selected':''} value="6">6</option>
</select>
</form>
<c:if test="${authorPage.totalPages > 0}">
<ul >
<c:forEach items="${pageNumbers}" var="pageNumber">
<c:if test="${authorPage.totalPages > 1}">
<li class="${pageNumber == authorPage.number + 1 ? 'page-item active' : 'page-item'}">
<a href="<c:url value='/admin/authors/searchpaginated?name=${name}&size=${authorPage.size}&page=${pageNumber}'/>">${pageNumber}</a>
</li>
</c:if>
</c:forEach>
</ul>
</c:if>
