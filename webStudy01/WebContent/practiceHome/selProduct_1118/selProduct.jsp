<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//HTMl 폼에서 전달된 데이터의 한글 인코딩
		request.setCharacterEncoding("UTF-8");
	
// 		session 에 username 이름으로 HTML 폼의 <input type = "text" name = "username"/>
		session.setAttribute("username", request.getParameter("username"));
	%>
	
	<H2>상품 선택</H2>
	<HR>
	<%=session.getAttribute("username") %>님이 로그인한 상태입니다.
	<Hr>
	<form name="form1" method="post" action="<%=request.getContextPath() %>/practiceHome/selProduct_1118/add.jsp">
		<select name = "product">
			<option>사과</option>
			<option>귤</option>
			<option>파인애플</option>
			<option>자몽</option>
			<option>레몬</option>
		</select>
		<input type="submit" value="추가"/>
	</form>	
	<a href="checkOut.jsp">계산</a>
</body>
</html>