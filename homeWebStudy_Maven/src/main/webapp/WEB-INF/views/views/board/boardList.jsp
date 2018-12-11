<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/boardList.jsp</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 

<script type="text/javascript">

	function ${pagingVO.funcName }(page){
		$("[name='searchForm']").find("[name='page']").val(page);
		$("[name='searchForm']").submit();
	}
	
	
	
$(function(){
	
  	var navTag = $('#navtag');
	var bodyTag = $('#bodylist');
	var searchForm = $('[name="searchForm"]');
	
	$(window).on("popstate", function(event){
		console.log(event);
		if(event.originalEvent.state){
			var pagingVO = event.originalEvent.state;
			var body="";
			var boardList = pagingVO.dataList;
			if(boardList){
				$.each(boardList,function(i, board){
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
			navTag.html(pagingVO.pagingHTML);
			bodyTag.html(body);
		}else{
			location.reload();
		}
	});
	
	
	searchForm.ajaxForm({ 
	       dataType:  'json', 
	       success:  function (data){
			var body="";
			var boardList = data.dataList;
			if(boardList){
				$.each(boardList,function(i, board){
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
			// 비동기 처리 성공 -> push state on history (state, title, url)
			var pageNum = searchForm.find('[name="page"]').val();
			var queryString = searchForm.serialize();
			
			history.pushState(data, pageNum+" 페이지", "?"+queryString);
			
			searchForm.find('[name="page"]').val("");
		},
	 });
	 
	 <c:url value="/board/boardView.do" var="boardView" />
	 $("#bodylist").on("click", "tr",function(){
		var what = $(this).find("td:nth-child(2)").text();
		location.href="${boardView}?what="+what;
	 });
})

</script>
</head>
<body>
<table class="table table-bordered table-striped table-hover">
	<thead class="thead-dark">
		<tr>
			<th>순번</th>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
	</thead>
	<tbody id="bodylist">
		<c:choose>
			<c:when test="${not empty pagingVO.dataList }">
				<c:forEach items="${pagingVO.dataList }" var="board">
					<tr>
						<td>${board.rnum }</td>
						<td>${board.bo_no }</td>
						<td>
						<c:forEach begin="2" end="${board.bo_level}">
							&nbsp;
						</c:forEach>
						${board.bo_title }</td>
						<td>${board.bo_writer }</td>
						<td>${board.bo_date }</td>
						<td>${board.bo_hit }</td>
						<td>${board.bo_rcmd }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">검색 조건에 맞는 글이 없음.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7" class="text-center">
				<nav aria-label="Page navigation" id="navtag">
				 	${pagingVO.pagingHTML } 
				</nav>
				<form name="searchForm" class="form-inline justify-content-center">
					<input type="hidden" name="page" />
					<select class="form-control" name="searchType">
						<option value="">전체</option>
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<script type="text/javascript">
						$('[name="searchType"]').val("${param.searchType}");
					</script>
					<input class="form-control" type="text" name="searchWord" 
							value="${param.searchWord }"/>
					<input class="btn btn-success" type="submit" value="검색" />
					&nbsp;&nbsp;&nbsp;
					<input class="btn btn-success" type="button" 
							value="새글쓰기" onclick="location.href='<c:url value="/board/boardInsert.do"/>';" 
					/>
				</form>
			</td>
		</tr>
	</tfoot>
</table>
</body>
</html>




















