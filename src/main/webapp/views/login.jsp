<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
 <p><i>${alert}</i></p>
	 <form action="${pageContext.request.contextPath}/login" method="post"> <!-- khi nhấn submit thì chuyển sang link  -->      
        <label class="pad_top">Email:</label>
        <input type="email" name="username" value="${user.email}"><br>
        <label class="pad_top">Password:</label>
        <input type="password" name="password" value="${user.lastName}"><br>        
        <label>&nbsp;</label>
        <input type="submit" value="Login" class="margin_left">
    </form>
</body>
</html>