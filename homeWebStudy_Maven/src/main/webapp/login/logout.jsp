<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 	session.removeAttribute("loginId");
	session.invalidate();
	// 이동 (index.jsp , redirect)
	response.sendRedirect(request.getContextPath()+"/");
	
%>
