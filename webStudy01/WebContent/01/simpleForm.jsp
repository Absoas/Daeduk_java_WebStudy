<%@page import="java.util.Map.Entry"%>
<%@page import="kr.or.ddit.web.SimpleFormProcessServlet"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 알바몬에서 알바생의 프로필을 입력받으려고함 ... -->
	<!-- 이름 , 나이 , 주소 , 전화번호 , 사진 , 성별 , -->
	<!-- 경력 , 학력 , 자기소개서, 자격증  -->
	<form action="<%=request.getContextPath()%>/albamon" method="get">

		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" /></td>
			</tr>

			<tr>
				<th>나이</th>
				<td><input type="number" name="age" min="15" max="40" /></td>
			</tr>

			<tr>
				<th>전번</th>
				<td><input type="text" name="tel" placeholder="000-0000-0000"
					pattern="\d{3}-\d{3,4}-\d{4}" /></td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" name="address" /></td>
			</tr>

			<tr>
				<th>성별</th>
				<td><label><input type="radio" name="gender" value="M" />남</label>
					<label><input type="radio" name="gender" value="F" />여</label></td>
			</tr>

			<tr>
				<th>학력</th>
				<td><select name="grade">
						<%
				String pattern = "<option value = '%s'>%s</option>";
				for(Entry<String, String> entry : SimpleFormProcessServlet.gradeMap.entrySet()){
						out.println(String.format(pattern, entry.getKey(), entry.getValue()));
				}
				
				%>
				</select></td>
			</tr>

			<tr>
				<th>경력</th>
				<td><textarea rows="3" cols="100" name="career"></textarea></td>
			</tr>

			<tr>
				<th>자격증</th>
				<td><select name="license" multiple="multiple" size="10">
						<%
					for(Entry<String, String> entry : SimpleFormProcessServlet.licenseMap.entrySet()){
							out.println(String.format(pattern,  entry.getKey(), entry.getValue()));
					}
				
				%>
				</select></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="등록" /> <input
					type="reset" value="취소" /> <input type="button" value="버튼" /></td>
			</tr>

		</table>
	</form>

</body>
</html>