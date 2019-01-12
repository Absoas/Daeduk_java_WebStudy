<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}"></script>

</head>
<body>
	<table>
		<c:if test="${not empty suggestList}">
			<c:forEach items="${suggestList}" var="suggest">
				<tr>
					<td>${suggest.suggest_board_no}</td>
					<td>${suggest.suggest_board_title}</td>
					<td>${suggest.suggest_board_content}</td>
					<td>${suggest.suggest_board_date}</td>
				</tr>
			</c:forEach>
		</c:if>

	</table>

	<INPUT type="button" value="글쓰기"
		onclick="location.href='<c:url value="/suggestboard/suggestboardInsert.do"/>';" />
</body>
</html>