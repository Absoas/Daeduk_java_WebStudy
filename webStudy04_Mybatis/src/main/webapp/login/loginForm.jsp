<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login/loginForm.jsp</title>
<script type="text/javascript">
	<c:if test="${not empty message}">
		alert("${message}");
		<c:remove var="message" scope="session" />
	</c:if>
</script>
</head>
<body>
<form action="<c:url value='/login/loginCheck.do' />" method="post">
	<ul>
		<li>
			<c:set var="savedId" value="${cookie['idCookie']['value'] }" />
			아이디 : <input type="text" name="mem_id" value="${savedId }" />
			<label>
			<input type="checkbox" name="idChecked" value="idSaved" ${not empty savedId ? "checked":"" }/>아이디기억하기
			</label>
		</li>
		<li>
			비밀번호 : <input type="text" name="mem_pass" />
			<input type="submit" value="로그인" />
		</li>
	</ul>
</form>
</body>
</html>




