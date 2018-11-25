<%@page import="kr.or.ddit.utils.CookieUtils"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String failedId = request.getParameter("mem_id");
   String message = (String)session.getAttribute("message");
   CookieUtils cookie = new CookieUtils(request);
   String cookieValue = cookie.getCookieValue("idCookie");
   
   
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login/loginForm.jsp</title>
<script type="text/javascript">
   <%
      if(StringUtils.isNotBlank(message)){
   %>
      alert("<%=message%>");
   <%
         session.removeAttribute("message");
      }
   %>
   
   
</script>
</head>
<body>
<form action="<%=request.getContextPath() %>/login/loginCheck.jsp" method="post">
   <ul>
      <li>
         아이디 : <input type="text" name="mem_id" value="<%= Objects.toString(failedId, Objects.toString(cookieValue, "")) %>" />
         <label>
            <input type= "checkbox" name = "idChecked" value = "idSaved" <%=StringUtils.isNotBlank(cookieValue)?"checked":"" %>/>아이디 기억하기
         </label>
<!--          2개 혹은 3개의 파라미터가 넘어간다. 
            체크했을때는 3개  (idCheckd, isSaved)
            체크를 안했을 때는 2개의 파라미터
            
            1. 체크를 안했을 경우 
               mem_id
               mem_pass
               
               로그인에 성공했을 때 
               쿠키를 안남기고 싶다.
               혹시라도 그전에 남겨둔 쿠키가 있다면 그 이전에 남겨진 쿠키까지 지워야한다.
               
            2. 체크
            
               mem_id
               mem_pass
               idChecked : idSaved   
               
               체크를 한다면 로그인에 성공했을 때
               다음에 로그인했을 떄는 인증에 성공한 ID를 쿠기로 등록(1주일 기한)
                
               1주일 뒤에 쿠키로 남겨놨던 ID가 input 태그에 남겨져야한다. 
               또한 check 상태 유지
               
               hint redirict 하기 전에 작업 처리
               
               체크를 하냐 마냐에 따라
               maxAge를 다르게
               남길거면 1주일
               지울거면 0
 -->
      </li>
      <li>
         비밀번호 : <input type="password" name="mem_pass" />
         <input type="submit" value="로그인" />
      </li>
   </ul>
</form>
</body>
</html>