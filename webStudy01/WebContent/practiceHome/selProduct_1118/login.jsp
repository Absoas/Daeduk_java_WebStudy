<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>로그인</h2>
		<form name = "form1" method = "post" action="<%=request.getContextPath() %>/practiceHome/selProduct_1118/selProduct.jsp">
			<input type = "text" name = "username">
			<input type = "submit" value="로그인">
		</form>
</body>
</html>