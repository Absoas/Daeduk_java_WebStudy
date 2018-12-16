<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--     1. 파라미터 확보 -->
<!--     2. 검증(필수 데이터 검증, 유효데이터 검증) -->
<!--     3. 불통 -->
<!--     	1) 필수데이터 누락 -->
<!--     	2) 우리가 관리하지 않는 멤버를 요구한 경우 -->
<!--     4. 통과 -->
<!--     	이동(맵에 있는 개인 페이지, 클라이언트가 멤버 개인 페이지의 주소를 모르도록.) -->
<!--     	이동(맵에 있는 개인 페이지, getBts 에서 원본 요청을 모두 처리했을 경우 , UI 페이지로 이동할 때 .) -->
 
 <%!
	public Map<String, String[]> singerMap = 
	new	LinkedHashMap<>();
	
	{
		singerMap.put("B001",new String[]{"이해리","/WEB_INF/davichi/haeli.jsp"});
		singerMap.put("B002",new String[]{"강민경","/WEB_INF/davichi/minkeong.jsp"});
	}
 %>
 
 <%
  	String goPage = null;
     	String member =request.getParameter("member");
     	int statusCode  =  0;
     	
     	if(member == null || member.trim().length() == 0){
  		statusCode = HttpServletResponse.SC_BAD_REQUEST;
     	}else if(!singerMap.containsKey(member)){
     		statusCode = HttpServletResponse.SC_NOT_FOUND;
     	}
     
    	if(statusCode != 0){
    		response.sendError(statusCode);
  		return;
    	}
    	
    String[] value = singerMap.get(member);
    goPage = value[1];
    response.sendRedirect(request.getContextPath() + goPage);
//     RequestDispatcher rd = request.getRequestDispatcher(goPage);
//     rd.forward(request, response);
    
  %>
 
 
