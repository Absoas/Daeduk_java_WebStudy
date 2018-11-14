<%@page import="java.io.IOException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/applicationDesc.jsp</title>
</head>
<body>
<h4> ServletContext </h4>
<pre>
	<%=application.hashCode() %>
	<a href="<%=request.getContextPath() %>/06/ImplicitObject.jsp">impliciteObject.jsp 로 이동</a>
	<a href="<%=request.getContextPath()%>/desc">DescriptionServelet으로 가기</a>
	: 컨텍스트와 해당 컨텍스트를 운영(관리)중인 서버에 대한 정보를 가진 객체. 
	
	1. 서버에 대한 정보 획득
		<%=application.getServerInfo() %>
		<%=application.getMajorVersion() %>.<%=application.getMinorVersion() %>
		<%=application.getMimeType("test.hwp") %>
	2. 로그 기록
		<%
			application.log("명시적으로 기록한 로그 메시지");
		%>
	3. 컨텍스트 파라미터(어플리케이션의 초기화 파라미터) 획득
		<%=application.getInitParameter("param1")%>
		<%
			Enumeration<String> names =  application.getInitParameterNames();
			while(names.hasMoreElements()){
				out.println(application.getInitParameter(names.nextElement()));
			}
		%>
	4. 웹 리소스를 획득	: http://localhost/webStudy01/images/Koala.jpg
		<%=application.getRealPath("/images/Hydrangeas.jpg")%>
		<%
			String fileSystemPath = application.getRealPath("/images/Hydrangeas.jpg");
			File srcFile = new File(fileSystemPath);
			
		// 			String clonePath = application.getRealPath("/06/Hydrangeas.jpg");
			File targetFolder = new File(application.getRealPath("/06"));			
			File targetFile = new File(targetFolder,srcFile.getName());

			try(
				InputStream fis =  application.getResourceAsStream("/images/Koala.jpg");
				FileOutputStream fos = new FileOutputStream(targetFile);
			){
				int pointer = -1;
				byte[] buffer = new byte[1024];

				while ((pointer = fis.read(buffer)) != -1) {
					fos.write(buffer , 0 , pointer);
				}
	
				fis.close();
				fos.close();
			}
		%>
</pre>
<img src="<%=request.getContextPath() %>/06/Hydrangeas.jpg" />
<img src="<%=request.getContextPath() %>/images/Hydrangeas.jpg" />
</body>
</html>