<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.ddit.or.kr/loopTag" prefix="loop" %>  
<%@ taglib uri="http://www.ddit.or.kr/makeSelect" prefix="ms" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeHandler(event){
		alert(event.target.value);
	}
</script>
</head>
<body>
	<loop:myforEach loopCount="5" data="테스트"/>
	<hr />
	<c:set var="test" value="locParam" />
	<ms:makeLocaleSelect name="${test }"/>
	<ms:makeTimeZoneSelect name="timeZoneParam" onchangeFuncName="changeHandler"/>
</body>
</html>