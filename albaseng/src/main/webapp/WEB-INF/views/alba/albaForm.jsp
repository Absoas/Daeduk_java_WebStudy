<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="prod" method="post">
		<input type="hidden" name="alba_code" value="${alba.alba_code}" />
		<table class="table">
			<tr>
				<th>알바생이름</th>
				<td><div class="input-group">
						<input type="text" name="alba_name" value="${alba.alba_name}" />
						<form:errors path="alba_name" element="span"
							cssClass="error input-group-text" />
					</div></td>
			</tr>
			<tr>
				<th>알바생나이</th>
				<td><div class="input-group">
						<input type="text" name="alba_age" value="${alba.alba_age}" />
						<form:errors path="alba_age" element="span"
							cssClass="error input-group-text" />
					</div></td>
			</tr>
			<tr>
				<th>알바생번호</th>
				<td><div class="input-group">
						<input type="text" name="alba_tel" value="${alba.alba_tel}" />
						<form:errors path="alba_tel" element="span"
							cssClass="error input-group-text" />
					</div></td>
			</tr>
			<tr>
				<th>알바생주소</th>
				<td><div class="input-group">
						<input type="text" name="alba_address"
							value="${alba.alba_address}" />
						<form:errors path="alba_address" element="span"
							cssClass="error input-group-text" />
					</div></td>
			</tr>
			<tr>
				<th>알바생학력</th>
				<td><div class="input-group">
						<select name="alba_grade">
							<option value="">분류선택</option>
							<c:forEach items="${gradeMap }" var="grade">
								<option value="${grade['CODENAME'] }">${grade["CODEVALUE"] }</option>
							</c:forEach>
						</select>
							
						<form:errors path="alba_grade" element="span"
							cssClass="error input-group-text" />
					</div></td>
			</tr>
			<tr>
				<th>알바생성별</th>
				<td><div class="input-group">
						<input type="text" name="alba_gender"
							value="${alba.alba_gender}" />
						<form:errors path="alba_gender" element="span"
							cssClass="error input-group-text" />
					</div></td>
			</tr>
			<tr>
				<th>알바생경력</th>
				<td><div class="input-group">
						<input type="text" name="alba_career"
							value="${alba.alba_career}" />
						<form:errors path="alba_career" element="span"
							cssClass="error input-group-text" />
					</div></td>
			</tr>
			
			<tr>
				<th>자격증</th>
				<td><div class="input-group">
						<select name="license" multiple="multiple">
							<option value="">분류선택</option>
							<c:forEach items="${licenseMap }" var="lic">
								<option value="${lic['CODENAME'] }">${lic["CODEVALUE"] }</option>
							</c:forEach>
						</select>
							
						<form:errors path="alba_grade" element="span"
							cssClass="error input-group-text" />
					</div></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="등록"> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>