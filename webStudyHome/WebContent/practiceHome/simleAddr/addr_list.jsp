<%@page import="kr.or.home.addr.vo.AddrBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="am" class="kr.or.home.addr.service.AddrManager" scope="application" ></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>주소록</h2>
		<hr>
		<a href="addr_form.html">주소추가</a>
		<table border = 1 width=500 >
			<tr>
				<td>이름</td>
				<td>전화번호</td>
				<td>이메일</td>
				<td>성별</td>
			</tr>
			
			<%
				String format = "<td>%s</td><td>%s</td><td>%s</td><td>%s</td>";
				
				for (AddrBean ab : am.getAddrList()) {
					out.println("<tr>");
					out.println(String.format(format, ab.getUsername(),ab.getTel(),ab.getEmail(),ab.getSex()));
					out.println("</tr>");
				}
			%>
			
		</table>
	</div>
</body>
</html>