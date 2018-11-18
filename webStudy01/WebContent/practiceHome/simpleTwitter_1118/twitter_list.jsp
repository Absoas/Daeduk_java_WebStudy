<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%
		request.setCharacterEncoding("UTF-8");
		// HTML 폼에서 username 으로 전달된 값을 가지고 옴
		String username = request.getParameter("username");
		
		//username이 null이 라닌 경우 세션에 값을 저장
		if(username!=null){
			session.setAttribute("user", username);
		}
	%>
</head>
<body>
	<div align = center>
		<H4>my simple twitter!!</H4>
		<hr>
		<form action = "tweet.jsp" method="post">
			<!-- 세션에 저장된 이름 출력 -->
			@<%=session.getAttribute("user") %> : <input type="text" name="msg">
			<input type="submit" value="Tweet">
		</form>
		
		<hr>
		
		<div align ="left">
			<ul>
				<%
					//application 내장객체를 통해 msgs이름으로 저장된 ArrayList를 가지고옴
					ArrayList<String> msgs = (ArrayList<String>) application.getAttribute("msgs");

					//msgs가 null 이 아닌경우애만 목록 출력

					if (msgs != null) {
						for (String msg : msgs) {
							out.println("<LI>" + msg + "</LI>");
						}
					}
				%>
			</ul>
		</div>
	</div>
</body>
</html>