<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.ddit.or.kr/loopTag" prefix="loop" %>
<%@taglib uri="http://www.ddit.or.kr/makeSelect" prefix="mSel"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function changeHandler(){
		document.selectForm.submit();
	}
</script>
</head>
<body>
	<loop:myforEach loopCount="5" data="test"/>
	<hr />
	<c:set value="locParam" var="test"/>
	<mSel:makeLocaleSelect name="${test}"/>
	<form name = "selectForm">
		<mSel:makeTimeSelectTag name="${test}" onchangeFunc="changeHandler()"/>
	</form>
</body>
</html>