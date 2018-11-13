<%@page import="java.util.Arrays"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="kr.or.ddit.web.SimpleFormProcessServlet_SEM"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.catalina.util.ParameterMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 알바몬에서 알바생의 프로필을 입력받으려고 함. -->
	<!-- 이름, 나이, 주소, 전번, 성별,  -->
	<!-- 경력, 학력, 자기소개서, 자격증 -->
	<%
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("address");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String career = request.getParameter("career");
		String[] license = request.getParameterValues("license");
	%>
	<form action="<%=request.getContextPath()%>/albamon" method="post">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"
					value="<%=Objects.toString(name, "")%>" /></td>
			</tr>

			<tr>
				<th>나이</th>
				<td><input type="number" name="age" min="15" max="40"
					value="<%=Objects.toString(age, "")%>" /></td>
			</tr>

			<tr>
				<th>전번</th>
				<td><input type="text" required="required" name="tel"
					placeholder="000-0000-0000" pattern="\d{3}-\d{3,4}-\d{4}"
					value="<%=Objects.toString(tel, "")%>" /></td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" required="required" name="address"
					value="<%=Objects.toString(addr, "")%>" /></td>
			</tr>

			<tr>
				<th>성별</th>
				<td><label><input type="radio" name="gender" value="M"
						value="<%="M".equals(gender) ? "checked" : ""%>" />남</label> <label><input
						type="radio" name="gender" value="F"
						value="<%="F".equals(gender) ? "checked" : ""%>" />여</label></td>
			</tr>

			<tr>
				<th>학력</th>
				<td><select name="grade">
						<%
							String pattern = "<option value='%s' %s>%s</option>";
							for (Entry<String, String> entry : SimpleFormProcessServlet_SEM.gradeMap.entrySet()) {
								String selected = "";
								if (entry.getKey().equals(grade)) {
									selected = "selected";
								}
								out.println(String.format(pattern, entry.getKey(), selected, entry.getValue()));
							}
						%>
				</select></td>
			</tr>

			<tr>
				<th>경력</th>
				<td><textarea rows="3" cols="100" name="career"
						value="<%=Objects.toString(career, "")%>"></textarea></td>
			</tr>

			<tr>
				<th>자격증</th>
				<td><select name="license" multiple="multiple" size="10">
						<%
							if (license != null) {
								Arrays.sort(license);
							}

							for (Entry<String, String> entry : SimpleFormProcessServlet_SEM.licenseMap.entrySet()) {
								String selected = "";
								if (license != null && Arrays.binarySearch(license, entry.getKey()) > -1) {
									selected = "selected";
								}
								out.println(String.format(pattern, entry.getKey(), selected, entry.getValue()));
							}
						%>
				</select></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="등록"> <input
					type="reset" value="취소"> <input type="button"
					value="버튼아닌버튼"></td>
			</tr>


		</table>
	</form>
</body>
</html>