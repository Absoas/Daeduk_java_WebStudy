<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<!-- 건의 게시판 등록 -->
	<!-- 2.	kr.or.ddit.sboard.controller.SuggestboardInsertController -->
	<!-- 등록 -->

	<form method="post">
		<table>
			<tr>
				<th>건의사항게시판_번호</th>
				<td><input type="text" name="suggest_board_no"
					value="${suggest_boardsuggest_board_no}" /><span class="error">${errors.suggest_board_no}
				</span></td>
			</tr>
			<tr>
				<th>건의사항게시판_제목</th>
				<td><input type="text" name="suggest_board_title"
					value="${suggest_boardsuggest_board_title}" /><span class="error">${errors.suggest_board_title}
				</span></td>
			</tr>
			<tr>
				<th>건의사항게시판_내용</th>
				<td><input type="text" name="suggest_board_content"
					value="${suggest_boardsuggest_board_content}" /><span
					class="error">${errors.suggest_board_content} </span></td>
			</tr>
			<tr>
				<th>건의사항게시판_작성날짜</th>
				<td><input type="text" name="suggest_board_date"
					value="${suggest_boardsuggest_board_date}" /><span class="error">${errors.suggest_board_date}
				</span></td>
			</tr>
			<tr>
				<th>회원_아이디</th>
				<td><input type="text" name="mem_id"
					value="${suggest_boardmem_id}" /><span class="error">${errors.mem_id}</span></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>


</body>
</html>
