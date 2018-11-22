<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public Map<String, String[]> singerMap = 
			new	LinkedHashMap<>();

	{
		singerMap.put("B001",new String[]{"이해리","/WEB_INF/davichi/haeli.jsp"});
		singerMap.put("B002",new String[]{"강민경","/WEB_INF/davichi/minkeong.jsp"});
	}
%>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/davichiForm.jsp</title>

<script type = "text/javascript">
	function eventHandler() {
		var form = document.forms[0];
		form.submit();
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath() %>/05/getDavichi.jsp">
		<select name = "member" onchange="eventHandler()">
			<option value = ""> 멤버 선택</option>
			<%
			for(Entry<String, String[]> entry : singerMap.entrySet()){
				String key = entry.getKey();
				String[] value = entry.getValue();
				String pattern = "<option value = '%s'>%s</option>";
				out.println(String.format(pattern, key, value[0]));
			}
			%>
		</select>
	</form>
</body>
</html>