<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="http://malsup.github.com/jquery.form.js"></script> 
<script type="text/javascript" src="<c:url value='/js/replyProcess.js' />"></script>
<script type="text/javascript">
	$.getContextPath = function(){
		return "${pageContext.request.contextPath}";
	}	
</script>

</head>
<body>

	<div class="modal fade" id="replyDeleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<form onsubmit="return false;" id = "modalForm">
	         <p>비밀번호 : <input type="text" id="rep_pass"/> 
	         <input type = "hidden" id = "bo_no" value="${board.bo_no }"/>
	         <input type = "hidden" id = "rep_no"/>
	         </p>
	      	</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	        <button type="button" class="btn btn-primary" id="modalBtn">삭제</button>
	      </div>
	    </div>
	  </div>
	</div>

	<table class="table">
		<tr>
			<th>게시글 번호</th>
			<td>${board.bo_no}</td>
		</tr>
		<tr>
			<th>게시글 작성자</th>
			<td>${board.bo_writer}</td>
		</tr>
		<tr>
			<th>IP</th>
			<td>${board.bo_ip}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${board.bo_mail}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.bo_title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.bo_content}</td>
		</tr>
		<tr>
			<th>작성날짜</th>
			<td>${board.bo_date}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.bo_hit}</td>
		</tr>
		<tr>
			<th>추천수</th>
			<td>${board.bo_rcmd}</td>
		</tr>
	</table>

	<form name="replyForm" method="post" action="${pageContext.request.contextPath }/reply/replyInsert.do">
		<table>
			<tr>
				<td><input type="hidden" name="rep_no"/></td>
			</tr>
			<tr>
				<td><input type="hidden" name="bo_no" value="${board.bo_no }" /></td>
			</tr>
			<tr>
				<td><input type="hidden" name="rep_ip"
					value="${pageContext.request.remoteAddr }" /></td>
			</tr>
			<tr>
				<td>작성자 : <input type="text" name="rep_writer" /></td>
			</tr>
			<tr>
				<td>비밀번호 : <input type="password" name="rep_pass" /></td>
			</tr>
			<tr>
				<td>내용 : <textarea name="rep_content" rows="3" cols="100"></textarea><input
					type="submit" value="등록" /></td>
			</tr>
		</table>	
	</form>

	<table class="table">
		<thead>
			<tr>
				<th>댓글 작성자</th>
				<th>댓글작성 IP</th>
				<th>댓글내용</th>
				<th>댓글단 날짜</th>
			</tr>
		</thead>
		
		<tbody id="listBody">
		
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="4">
					<nav aria-label="Page navigation" id = "pagingArea">
					</nav>
				</td>
			</tr>
		</tfoot>		
	</table>
	
	<script type="text/javascript">
	function paging(page){
		pagingReply(page,${board.bo_no});
	}
	paging(1);
	</script>
</body>
</html>








