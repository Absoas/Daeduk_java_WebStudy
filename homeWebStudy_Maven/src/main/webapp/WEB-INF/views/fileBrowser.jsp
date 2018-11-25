<%@page import="kr.or.ddit.web.ServerFileBrowser"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	File file = (File)request.getAttribute("file");
%>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
  
  
<script type="text/javascript">
	$(function(){
		$("ul").on("click", function() {
			alert($(this).val());
		});
	})
</script>
</head>
<body>
	<!-- 파일들의 목록이 directory라면  -->
	<!-- parameter 설계 해서 2번을 클릭했다면 2번을 클릭햇다라는 정보를 보냄 -->
	<form name="listForm" method="get" >
		<%
			String format = "<ul name='ulName'>%s</ul>";
			if(file !=null){
				for(File files : file.listFiles()){
					out.println(String.format(format,files.getName()));
				}
			}
		%>
	</form>
</body>
</html>