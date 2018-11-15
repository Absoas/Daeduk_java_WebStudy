<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 	
		1. 파라미터 확보
		2. 검증(필수 데이터)
		3. 불통
   			이동(loginForm.jsp, 기존에 입력했던 아이디를 그대로 전달할 수 있는 방식)
		4. 통과
   		4-1. 인증(아이디 == 비번)
      		4-2. 인증 성공 : 웰컴 페이지로 이동(원본 요청을 제거하고 이동.)
      		4-3. 인증 실패 : 이동(loginForm.jsp, 기존에 입력했던 아이디를 그대로 전달.) -->
<%
	//test01
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("mem_id");
	String pass = request.getParameter("mem_pass");
	String goPage = null;
	boolean redirect = false;
	
	if(id == null || id.trim().length()==0 ||pass == null || pass.trim().length()==0){
	   goPage = "/login/loginForm.jsp";
	   redirect = true;
	   session.setAttribute("error", 1);
	}else{
	   
	   if(id.equals(pass)){
	      goPage = "/";
	      redirect = true;
	   }else{
	      goPage = "/login/loginForm.jsp";
	      redirect = true;
	      session.setAttribute("error", 1);
	   }
	}
	if(redirect){
	   response.sendRedirect(request.getContextPath() + goPage);
	}else{
	   RequestDispatcher rd = request.getRequestDispatcher(goPage);
	   rd.forward(request, response);
	}

 %>
 
<%

// 	request.setCharacterEncoding("UTF-8");

// 	String id = request.getParameter("mem_id");
// 	String pass = request.getParameter("mem_pass");
	
// 	System.out.println(id + "" + pass);
	
// 	boolean valid = true;
	
// 	if(id == null || pass == null || id.isEmpty()|| pass.isEmpty()){
// 		valid = false;
// 	}
	
// 	if(valid == false){
// 		RequestDispatcher rd =  request.getRequestDispatcher("/login/loginForm.jsp");
// 		rd.forward(request, response);
// 		return;
// 	}
	
	
// 	if(id.equals(pass)){
// 		response.sendRedirect(request.getContextPath() + "/index.jsp");	
// 	}else{
// 		RequestDispatcher rd =  request.getRequestDispatcher("/login/loginForm.jsp");
// 		rd.forward(request, response);
// 	}
	
%>