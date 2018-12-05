<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script type="text/javascript" 
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 

<c:url value="/board/boardView.do" var="boardView"/>

<script>

	function ${pagingVO.funcName }(page){
		$("[name='searchForm']").find("[name='page']").val(page);
	//		document.searchForm.page.value=page;
		$("[name='searchForm']").submit();
	//		document.searchForm.submit();
	}
	
	function createBody(resp){
		var listBody = $("#bodylist");
        var boardList = resp.dataList;
		var html = "";
		if(boardList){
			$.each(boardList, function(idx, bo){
				html += "<tr>";
				html += "<td>"+bo.rnum+"</td>";
				html += "<td>"+bo.bo_no+"</td>";
				html += "<td>"+bo.bo_writer+"</td>";
				html += "<td>"+bo.bo_title+"</td>";
				html += "<td>"+bo.bo_date+"</td>";
				html += "</tr>";
			});
			
		}else{
			html += "<tr><td colspan='7'>게시글이 엄슴.</td></tr>";
		}
		listBody.html(html);
		$("#pagingArea").html(resp.pagingHTML);
	}

	$(function(){
	    $("[name='searchForm']").ajaxForm({
	    	dataType : "json",
	        success : createBody
	     });
	    
	    
	    $("#bodylist").on("click","tr",function(){
	    	var what =  $(this).find("td:nth-child(2)").text();
	    	location.href = "${boardView}?what="+what;
		});
	});

		    	  
</script>
<body>


<table class = "table">
	<thead>
		<tr>
			<th>순번</th>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>추천수</th>
		</tr>
	</thead>
	
	<tbody id= "bodylist">
		<c:set var="boardList" value="${pagingVO.dataList}"/>
		<c:if test="${ not empty boardList}">
			<c:forEach items="${boardList }" var="tmp">
			<tr>
				<td>${tmp.rnum }</td>
				<td>${tmp.bo_no }</td>
				<td>${tmp.bo_title}</td>
				<td>${tmp.bo_writer}</td>
				<td>${tmp.bo_date}</td>
				<td>${tmp.bo_rcmd}</td>
			</tr>
			</c:forEach>
		</c:if>
		
		<c:if test="${ empty boardList}">
			<tr>
				<td>게시글이 없습니다.</td>
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

<form name = "searchForm">
	<input type = "text" name = "page"/>
	
	<select name = "searchType">
		<option value = "bo_title">제목</option>
		<option value = "bo_writer">작성자</option>
		<option value = "bo_content">내용</option>
	</select>
	
	<script type="text/javascript">
        document.searchForm.searchType.value = "${empty pagingVO.searchType ? 'all' : pagingVO.searchType}";
    </script>
	
	<input type="text" name="searchWord" 
                value="${pagingVO.searchWord}"/>
	<input type="submit" value="검색" />
	
</form>

</body>
</html>