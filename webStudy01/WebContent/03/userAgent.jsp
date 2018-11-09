<%@page import="kr.or.ddit.web.useragent.SystemType"%>
<%@page import="kr.or.ddit.web.useragent.BrowserType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String header = request.getHeader(("user-agent"));
	
	String info = header.toUpperCase();
	String chkBrowser = "당신의 브라우저는 %s 입니다.";
	String chkSystem = "당신의 시스템은 %s 입니다.";
	
	BrowserType browser = BrowserType.geBrowserType(header);
	SystemType system = SystemType.getSystemFile(header);
	String systemName = system.getSystemName();
	String name = browser.getBrowserName();
%>
<html>
<head>
<meta charset="UTF-8">
<title>03/userAgent.jsp</title>
</head>
<body>
<!-- 클라이언트의 시스템과 브라우저에 대한 정보를 확인. -->
<!-- 클라이언트의 시스템이 데스크탑이라면 , "당신의 시스템은 데스크탑입니다." -->
<!-- 브라우저가 chrome이라면 "당신의 브라우저는 크롬입니다." -->
<!-- 브라우저가 firefox이라면 "당신의 브라우저는 파이어폭스입니다." -->
<!-- 와 같은 형태의 메시지를 출력. -->

<div id= "msgArea">
	<%=String.format(chkBrowser, name)%>
	<%=String.format(chkSystem, systemName)%>
</div>

</body>
</html>