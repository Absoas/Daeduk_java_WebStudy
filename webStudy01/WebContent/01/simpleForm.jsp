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
			<td>
				<input type = "text" name = "name" />			
			</td>
		</tr>
		
		<tr>
			<th>나이</th>
			<td>
				<input type = "number" name = "age" min = "15" max = "40"/>			
			</td>
		</tr>
		
		<tr>
			<th>전번</th>
			<td>
				<input type = "text" name = "tel" placeholder="000-0000-0000" pattern="\d{3}-\d{3,4}-\d{4}"/>			
			</td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td>
				<input type = "text" name = "address"/>			
			</td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td>
				<label><input type = "radio" name = "gender" value="M"/>남</label>			
				<label><input type = "radio" name = "gender" value="F"/>여</label>			
			</td>
		</tr>
		
		<tr>
			<th>학력</th>
			<td>
				<select name = "grade">
					<option value="">학력</option>
					<option value="g001">고졸</option>
					<option value="g002">대졸</option>
					<option value="g003">석사</option>
					<option value="g004">박사</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>경력</th>
			<td>
				<textarea rows="3" cols="100" name="career"></textarea>
			</td>
		</tr>
		
		<tr>
			<th>자격증</th>
			<td>
				<select name = "license" multiple="multiple" size="10">
					<option value="L001">정보처리산업기사</option>
					<option value="L002">정보처리기사</option>
					<option value="L003">정보보안산업기사</option>
					<option value="L004">정보보안기사</option>
					<option value="L005">SQLD</option>
					<option value="L006">SQLP</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="등록" />
				<input type = "reset" value="취소" />
				<input type = "button" value="버튼" />
			</td>
		</tr>
		
	</table>
	</form>
	
</body>
</html>