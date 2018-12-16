<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type = "text/css">
   .green{color: green;}
   .yellow{color: yellow;}
   .silver{color: silver;}
   .aqua{color: aqua;}
   .orange{color: orange;}
   .red{ color: red;}


   .bckred{ background: red; color: white;}
   .bckblue{ background: blue; color: white;}
</style>

</head>
<body>
	
<!-- 	2단부터 9단까지 구구단을 승수 1~9 까지 table 태그로 출력 -->
<!-- 	첫번째 단은 파란색 배경 -->
<!-- 	네번째 단은 빨간색 배경 -->
<form>
	단 : <input type="number" name="dan"/><br>
	곱 : <input type="number" name="gob"/>
	<input type="submit" value="제출"/>
</form>

<c:set var="dan1" value="${param.dan }"></c:set>
<c:set var="gob1" value="${param.gob }"></c:set>

<c:if test="${not empty dan1 }">
<table>
	<c:forEach var="dan" begin="${dan1 }" end="${gob1 }" step="1" varStatus="lts">
		<c:choose>
			<c:when test="${lts.count eq 1}">
				<c:set var="bck" value="bckblue"></c:set>
			</c:when>
			
			<c:when test="${lts.count eq 4}">
				<c:set var="bck" value="bckred"></c:set>
			</c:when>
			
			<c:otherwise>
				<c:remove var="bck"/>
			</c:otherwise>
		</c:choose>
		
		<tr>
			<c:forEach var="gob" begin="1" end="9" step="1">
				<td class="${bck}"> ${dan} * ${gob} = ${dan * gob }</td>
			</c:forEach>
		</tr>
	</c:forEach>
</table>
</c:if>
	<form>
		당신의 나이는 <input type="number" name="age"/>
		<input type="submit" value="전송" />
	</form>
<!-- 	age 파라미터가 있다면. -->
<!-- 	1. age 가  20대면 "방갑다 친구~" green-->
<!-- 	2. age 가 30대면 "방가 행님~" yellow-->
<!-- 	3. age 가 40대면 "담배 끊고 건강관리" red-->
<!-- 	4. age 가 50대면 "아빠?" silver-->
<!-- 	5. age 가 그 이상이면 "무슨 일로 오셨나여?" aqua-->
<!-- 	6. age가 20대 미만이면 , "나가 놀아라~" orange-->
	<c:set var = "age" value = "${param.age}" ></c:set>
	<c:set var = "color" value = "orange"></c:set>
	
	<c:choose>
		<c:when test="${'10' le age and age lt '20' }">
      		<c:set var = "msg" value="나가 놀아라~"></c:set>
      		<c:set var = "color" value = "green"></c:set>
      	</c:when>
      	<c:when test="${'20' le age and age lt '30' }">
			<c:set var = "msg" value="방갑다 친구~"></c:set>
			<c:set var = "color" value = "yellow"></c:set>
      	</c:when>
      	
      	<c:when test="${'30' le age and age lt '40' }">
			<c:set var = "msg" value="방가 행님~"></c:set>
			<c:set var = "color" value = "red"></c:set>
      	</c:when>
      	
      	 <c:when test="${'40' le age and age lt '50' }">
      		<c:set var = "msg" value="담배 끊고 건강관리"></c:set>
      		<c:set var = "color" value = "silver"></c:set>
      	</c:when>
      	
      	 <c:when test="${'50' le age and age lt '60' }">
      		<c:set var = "msg" value="아빠?"></c:set>
      		<c:set var = "color" value = "aqua"></c:set>
      	</c:when>
      		
      	 <c:when test="${'60' le age  }">
      		<c:set var = "msg" value="무슨 일로 오셨나여?"></c:set>
      		<c:set var = "color" value = "orange"></c:set>
      	</c:when>
     </c:choose>
	
	<c:if test="${not empty age}">
		<div id="msgArea" class="${color }">
			${msg }
		</div>
	</c:if>
</body>
</html>