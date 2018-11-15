<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function showList(command){
	    var form = document.show;
	    form.command.value = command;
	    form.submit();
	 }
</script>
</head>
<body>
<!-- 파일들의 목록이 directory라면  -->
<!-- parameter 설계 해서 2번을 클릭했다면 2번을 클릭햇다라는 정보를 보냄 -->

	<form name="show" action="<%=request.getContextPath()%>">

	</form>
	
</body>
</html>