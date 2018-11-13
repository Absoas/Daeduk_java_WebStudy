<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
<meta charset="UTF-8">
<!-- <meta http-equiv="Refresh" content="3; url=http://www.naver.com"> -->
<title>04/autoRequest.jsp</title>
</head>


<body>
<h4> 자동 요청을 발생시키는 방법 </h4>
<pre>
   1. 서버 사이드
      <%
//         response.setIntHeader("Refresh", 1);
      %>
   2. 클라이언트 사이드
       HTML : meta 태그 이용
       Javascript : 스케쥴링 함수 이용
</pre>
현재 서버의 시간 : <span id="severClock"></span> 

<script type="text/javascript">
   var severClock = $("#severClock");
   
   setInterval(function(){
      $.ajax({
         url : "<%=request.getContextPath()%>/05/getSeverTime.jsp",
         dataType : "json",
         success : function(resp) {
            severClock.html(resp.severTime);
         },
         error : function(resp) {
            console.log(resp.status  + " " + resp.responseText);
         }
      });
   },1000)
   
//    var wait = 3;
//    var count = 3;
//    var spanTag = document.getElementById("countArea");
//    setInterval(function(){
//       count--;
//       spanTag.innerHTML = count;
//    }, 1000);
//    setTimeout(function(){
//       location.reload();
// //      location.href="http://www.naver.com";
//    }, wait*1000);
</script>
</body>
</html>