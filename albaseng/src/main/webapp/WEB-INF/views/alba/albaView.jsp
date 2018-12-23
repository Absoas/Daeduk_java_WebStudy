<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr><th>알바생이름</th><td>${alba.alba_name}</td></tr>
		<tr><th>알바생나이</th><td>${alba.alba_age}</td></tr>
		<tr><th>알바생번호</th><td>${alba.alba_tel}</td></tr>
		<tr><th>알바생주소</th><td>${alba.alba_address}</td></tr>
		<tr><th>알바생학력</th><td>${alba.alba_grade}</td></tr>
		<tr><th>알바생성별</th><td>${alba.alba_gender}</td></tr>
		<tr><th></th><td>${alba.alba_career}</td></tr>
	</table>
	
	<input type="button" value="알바생 수정" class="btn btn-info"
		onclick="location.href='${pageContext.request.contextPath }/alba/albaUpdate.do?who=${alba.alba_code}'"
	/>
	
	<input type="button" value="알바생 삭제" class="btn btn-info"
		onclick="location.href='${pageContext.request.contextPath }/alba/albaDelete.do?who=${alba.alba_code}'"
	/>
	
</body>
</html>