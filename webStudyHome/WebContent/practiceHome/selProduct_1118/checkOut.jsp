<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H2>계산</H2>
	선택한 상품 목록
	<HR>
	<%
		ArrayList list = (ArrayList)session.getAttribute("productlist");
		if(list == null){
			out.println("선택한 상품이 없습니다. !!!");
		}else{
			for(Object productname : list){
				out.println(productname + "<BR>");
			}
		}
		
	
	%>
</body>
</html>