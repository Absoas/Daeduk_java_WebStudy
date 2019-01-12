<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<script>

	function ${pagingVO.funcName}(page){
		$("[name='searchForm']").find("[name='page']").val(page);
		$("[name='searchForm']").submit();
	}
	function makeList(data){
		var navTag = $('#navtag');
		var bodyTag = $('#bodylist');
		var body = "";
// 		var regex = /^(\s+)/;
		var boardList = data.dataList;
		if(bodyList){
			$.each(bodyList, function(i, board){
// 				var testArray = regex.exec(board.bo_title);
// 				if(testArray && testArray.length > 0){
// 					console.log(board.bo_title+"--"+testArray[1]+"-");
// 					board.bo_title = board.bo_title.replace(regex, Array(testArray[1].length).join("&nbsp;"));
// 				}
				body+="<tr><td>"+board.rnum+"</td>";
				body+="<td>"+board.bo_no+"</td>";
				body+="<td>"+board.bo_title+"</td>";
				body+="<td>"+board.bo_writer+"</td>";
				body+="<td>"+board.bo_date+"</td>";
				body+="<td>"+board.bo_hit+"</td>";
				body+="<td>"+board.bo_rcmd+"</td></tr>";
			})
		}else{
			body+="<tr><td colspan='7'>데이터없음</td></tr>";
		}
		navTag.html(data.pagingHTML);
		bodyTag.html(body);
	}
	
	$(function(){
		var navTag = $('#navtag');
		var bodyTag = $('#bodylist');
		var searchForm = $('[name="searchForm"]');
		
		//뒤로가기
		$(window).on("popstate", function(event){
			console.log(event);
			if(event.originalEvent.state){
				var pagingVO = event.originalEvent.state;
				makeList(pagingVO);
			}else{
				location.reload();
			}
		});
		
		//submit 결과를 ajaxForm이 가져옴
		searchForm.ajaxForm({ 
		       dataType:  'json', 
		       success:  function (data){
				makeList(data);
				// 비동기 처리 성공 -> push state on history (state, title, url)
				var pageNum = searchForm.find('[name="page"]').val();
				var queryString = searchForm.serialize();
				
				history.pushState(data, pageNum+" 페이지", "?"+queryString);
				searchForm.find('[name="page"]').val("");
			},
		 });
		 
		//페이지context 이런거 안붙힐라고
		 <c:url value="/board/boardView.do" var="boardView" />
		 
		 $("#bodylist").on("click", "tr",function(){
			var what = $(this).find("td:nth-child(2)").text();
			location.href="${boardView}?what="+what;
		 });
		
	});
</script>
<body>
자유게시판 조회 기능
kr.or.ddit.freeboard.controller.FreeboardListController
<br><br>
	<table>
		<thead>
		<tr>
		<td>
			<nav aria-label="Page navigation" id="navtag">
				 	${pagingVO.pagingHTML } 
				</nav>
			<form action = "<c:url value="/freeboard/freeboardList.do"/>" name="searchForm">
				<select class = "form-control" name = "searchType">
					<option value = "">전체</option>
					<option value = "writer">작성자</option>
					<option value = "title">제목</option>
					<option value = "content">내용</option>
				</select>
				
				<script type="text/javascript">
						$('[name="searchType"]').val("${param.searchType}");
				</script>
				
				<input type = "text" name = "searchWord" value = "${param.searchWord }"/>
				<input type = "submit" value = "검색"/>
			</form>
			</td>
				<td>게시글 번호</td>
				<td>제목</td>
				<td>작성일</td>
				<td>작성자</td>
				<td>조회수</td>
			</tr>
			
		</thead>
		
		<tbody id = "bodyList">
			
		</tbody>
		
		<tfoot>
			<tr>
				<td>
					<input type = "button" value = "작 성"
						onclick="location.href='<c:url value = "/freeboard/freeboardInsert.do"/>';"/>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>