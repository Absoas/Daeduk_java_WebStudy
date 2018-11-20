<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="addr" class="kr.or.home.addr.vo.AddrBean" ></jsp:useBean>
<jsp:setProperty property="*" name="addr"/>
<jsp:useBean id="am" class="kr.or.home.addr.service.AddrManager" scope="application"></jsp:useBean>

<%
	am.add(addr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<H2>등록 내용</H2>
이름: <jsp:getProperty property="username" name="addr"/>
전화번호 : <jsp:getProperty property="tel" name="addr"/>
이메일: <jsp:getProperty property="email" name="addr"/>
성별: <jsp:getProperty property="sex" name="addr"/>

<hr>
<a href="addr_list.jsp">목록 보기</a>

</body>
</html>