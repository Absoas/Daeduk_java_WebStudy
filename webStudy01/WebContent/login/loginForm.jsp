<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String failedId = request.getParameter("mem_id");
   Integer error = (Integer)session.getAttribute("error");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   <%
      if(error != null){
               
   %>
         alert("아이디,비밀번호가 틀렸습니다.");
   <%
         session.removeAttribute("error");
      }
   %>
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/login/loginCheck.jsp" method="post">
   <ul>
      <li>
         아이디 :<input type="text" name="mem_id" value="<%=Objects.toString(failedId,"")%>"/>
      </li>
      <li>
         비밀번호 : <input type="password" name="mem_pass" />
         <input type="submit" value="로그인"/>
      </li>
   </ul>
</form>
</body>
</html>