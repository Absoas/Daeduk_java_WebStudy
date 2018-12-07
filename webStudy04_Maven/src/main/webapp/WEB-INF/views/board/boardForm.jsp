<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cPath" value="${pageContext.request.contextPath}"
	scope="application" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script type="text/javascript" src="${cPath}/js/jquery-3.3.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="${cPath}/js/ckeditor/ckeditor.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='<c:url value = '/board/boardInsert.do'/>' method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="bo_ip"
			value="${pageContext.request.remoteAddr }" /> <input type="hidden"
			name="bo_no" value="${board.bo_no}" />
		<table class="table">
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="bo_title"
						value="${board.bo_title}" /><span class="error">${errors.bo_title}</span></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="bo_writer"
						value="${board.bo_writer}" /><span class="error">${errors.bo_writer}</span></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="bo_pass" value="${board.bo_pass}" /><span
						class="error">${errors.bo_pass}</span></td>
				</tr>
				<tr>
					<th>메일</th>
					<td><input type="text" name="bo_mail"
						value="${board.bo_mail} " /><span class="error">${errors.bo_mail}</span></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea id="bo_content" rows="" cols=""  name="bo_content"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<ul>
			<li>업로드 할 파일 : <br>
			<input type="file" name="bo_file" /> <br>
			<input type="file" name="bo_file" /> <br>
			<input type="file" name="bo_file" /> <br>
			</li>
		</ul>
		<input type="submit" value="저장" /> <input type="reset" value="취소" /> <input
			type="button" onclick="history.back()" value="뒤로가기" />
	</form>
	
	<script type="text/javascript">
	   CKEDITOR.replace('bo_content');
	</script>
</body>
</html>