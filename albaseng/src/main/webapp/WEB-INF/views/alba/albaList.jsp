<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<c:url value="/alba/albaView.do" var="albaView" />
<script type="text/javascript">
	
	function ${pagingVO.funcName } (page){
		$("[name='searchForm']").find("[name='page']").val(page);
// 		document.searchForm.page.value=page;
		$("[name='searchForm']").submit();
// 		document.searchForm.submit();
	}
	$(function(){
		bodyList = $("#bodyList");
		searchForm = $("[name='searchForm']");
		
		bodyList.on("click", "tr" ,function(){
			var alba_code = $(this).find("td:first").text();
			location.href = "${albaView}?who="+alba_code;
		});
		
		searchForm.on("submit", function(event){
			event.preventDefault();
			var data = $(this).serialize(); // queryString 생성
			$.ajax({
				data:data,
				dataType:"json", // Accept/Content-type
				success:albaListMaker,
				error:function(){
					
				}
			});
			return false;
		});
	});
	
	function albaListMaker(resp){
		var albaList = resp.dataList;
		var html = "";
		if(albaList){
			$.each(albaList, function(idx, alba){
				html += "<tr>";
				html += "<td>"+alba.alba_code+"</td>";
				html += "<td>"+alba.alba_name+"</td>";
				html += "<td>"+alba.alba_age+"</td>";
				html += "<td>"+alba.alba_tel+"</td>";
				html += "<td>"+alba.alba_address+"</td>";
				html += "<td>"+alba.alba_gender+"</td>";
				html += "<td>"+alba.alba_career+"</td>";
//					html += "<td>"+alba.alba_grade+"</td>";
				html += "</tr>";
			});
			
		}else{
			html += "<tr><td colspan='7'>알바생이 엄슴.</td></tr>";
		}
		bodyList.html(html);
		$("#pagingArea").html(resp.pagingHTML);
		$("[name='page']").val("");
	}
</script>

</head>
<body>
	<form name="searchForm">
		<input type="hidden" name="page" /> <select name="searchType">
			<option value="all">전체</option>
			<option value="name">이름</option>
			<option value="address">지역</option>
		</select>
		<script type="text/javascript">
						document.searchForm.searchType.value = "${empty pagingVO.searchType ? 'all':pagingVO.searchType}";
					</script>
		<input type="text" name="searchWord" value="${pagingVO.searchWord }" />
		<input type="submit" value="검색" />
	</form>

	<table class="table">
		<thead>
			<tr>
				<th>알바생 코드</th>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>성별</th>
				<th>경력</th>
				<th>학력</th>
			</tr>
		</thead>
	
		<tbody id="bodyList">
			<c:set var="albaList" value="${pagingVO.dataList }" />
			<c:if test="${not empty albaList }">
				<c:forEach items="${albaList }" var="alba">
					<tr>
						<td>${alba.alba_code }</td>
						<td>${alba.alba_name}</td>
						<td>${alba.alba_age }</td>
						<td>${alba.alba_tel }</td>
						<td>${alba.alba_address }</td>
						<td>${alba.alba_grade }</td>
						<td>${alba.alba_gender }</td>
						<td>${alba.alba_career }</td>
					</tr>
				
				</c:forEach>
			</c:if>
			<c:if test="${empty albaList }">
				<tr>
					<td colspan="6">회원의 목록이 없음.</td>
				</tr>
			</c:if>
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="7">
					<nav aria-label="Page navigation example" id="pagingArea">
						${pagingVO.pagingHTML }
					</nav>
				</td>
			</tr>
		</tfoot>
	</table>
	
	
	<button onclick="location.href='${pageContext.request.contextPath }/alba/albaInsert.do'">신규 등록</button>
</body>
</html>