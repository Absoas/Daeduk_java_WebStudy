<%@page import="java.util.Objects"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%!
	String marshalling(Map<String, Object> originalData){
			StringBuffer result = new StringBuffer();
			result.append("{");
			String jsonPattern = "\"%s\":\"%s\",";
			for(Entry<String, Object> entry : originalData.entrySet()){
				String propName = entry.getKey();
				String propValue = Objects.toString(entry.getValue(),"");
				result.append(
					String.format(jsonPattern, propName, propValue)	
						);
			}
			int lastIndex = result.lastIndexOf(",");
			result.deleteCharAt(lastIndex);
			result.append("}");
			return result.toString();
	}
%>  
<%-- 
getServerTime.jsp 쪽으로 1초마다 비동기 요청을 발생시키고,
JSON형태로 전송된 응답데이터에서 serverTime 프로퍼티로 부터 확보.
serverClock span 태그에 현재 서버의 시각이 갱신되도록. 
--%> 

<%
   response.setIntHeader("Refresh", 1);
   Date now = new Date();
   Map<String, Object> javaObject = new LinkedHashMap<>();
   javaObject.put("serverTime", now);
   String json = marshalling(javaObject);
   out.print(json);
%>
