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
		Map<String, String>  files =  ServerFileBrowser.fileList;
		File[] liFiles = (File[])request.getAttribute("liFiles");
	%>
<script type="text/javascript">
	function showList(command){
	    var form=document.listForm;
	    form.command.value = command;
		sd = command;
	    form.submit();
	 }
</script>
</head>
<body>
<!-- 파일들의 목록이 directory라면  -->
<!-- parameter 설계 해서 2번을 클릭했다면 2번을 클릭햇다라는 정보를 보냄 -->
	<form name="listForm">
	<%
		
		String format = "<ul onclick=\"javascript:showList('%s')\">%s";	
		String liFormat = "<li>%s</li>";
		for(Entry<String,String> entry : files.entrySet()){
			out.println(String.format(format,  entry.getKey(), entry.getKey())); 
			if(liFiles != null){
				for(File li : liFiles){
					if(li.getParentFile().getName().equals(entry.getKey())){
						if(li.isDirectory()){
							for(Entry<String,String> entry1 : ServerFileBrowser.fileList.entrySet()){
								ServerFileBrowser.fileList.put(li.getName(), li.getAbsolutePath());
								System.out.println(li.getName());
								out.println("</ul>");
								out.println(String.format(format, li.getName(), li.getName()));
								out.println("</ul>");
								continue;
							}
						}
						out.println(String.format(liFormat,li.getName()));
					}
				}
			}
			
			out.println("</ul>");
		}
	%>
		<input type="hidden" name="command" value = "">
	</form>
</body>
</html>