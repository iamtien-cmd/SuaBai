<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-9 col-sm-8">
		<div style="height: 300px; overflow-y: auto; border: 1px solid #ccc;">
			<table border="1" , width=100%>
				<tr>
					<th>STT</th>
					<th>Mã</th>
					<th>Tên tác giả</th>
					<th>Ngày sinh</th>
				</tr>
				<c:forEach items="${listauthor}" var="author" varStatus="STT">
					<tr>
						<td>${STT.index+1 }</td>
						<td>${author.author_id}</td>
						<td>${author.author_name }</td>
						<td>${author.date_of_birth }</td>
						<td>${author.active ? "Hoạt động" : "Khóa"}</td>

					</tr>
				</c:forEach>
			</table>
		</div>

		<form action="<c:url value='/admin/author/searchpaginated' />"
			method="get">
			<input type="hidden" name="name" value="${name}" /> Page size: <select
				name="size" id="size" onchange="this.form.submit()">
				<option value="3"
					<c:if test="${authorPage.size == 3}">selected</c:if>>3</option>
				<option value="5"
					<c:if test="${authorPage.size == 5}">selected</c:if>>5</option>
				<option value="10"
					<c:if test="${authorPage.size == 10}">selected</c:if>>10</option>
				<option value="15"
					<c:if test="${authorPage.size == 15}">selected</c:if>>15</option>
				<option value="20"
					<c:if test="${authorPage.size == 20}">selected</c:if>>20</option>
			</select>
		</form>

		<p>Số trang của page size</p>

		<c:if test="${authorPage.totalPages > 0}">
			<nav>
				<ul class="pagination">
					<c:forEach var="pageNumber" items="${pageNumbers}">
						<li
							class="page-item ${pageNumber == authorPage.number + 1 ? 'active' : ''}">
							<a class="page-link"
							href="<c:url value='/admin/categories/searchpaginated'>
                        <c:param name='name' value='${name}' />
                        <c:param name='size' value='${authorPage.size}' />
                        <c:param name='page' value='${pageNumber}' />
                    </c:url>">
								${pageNumber} </a>
						</li>
					</c:forEach>
				</ul>
			</nav>
		</c:if>
		</div>
</body>
</html>