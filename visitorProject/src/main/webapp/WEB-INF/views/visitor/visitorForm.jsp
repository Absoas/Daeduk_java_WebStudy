<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
	#listBody{
		font-size: 11px;
	}
	
	.card-div{
		width: 350px;
		display: inline-block;
	}
	
	img{
		width: 286px;
		height: 180px;
	}
	
</style>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript">
	$.getContextPath = function(){
		return "${pageContext.request.contextPath}";
	}
</script>


<title>Insert title here</title>
</head>
<body>
	<form name="replydeleteForm" action="<c:url value ='/reply/replyDelete.do'/>" method="post">
		<input type="hidden" name="rep_pass" value=""/>
		<input type="hidden" name="rep_no" value=""/>
	</form>
	
	<form name="deleteForm" action="<c:url value ='/visitor/visitorDelete.do'/>" method="post">
		<input type="hidden" name="vt_no" value=""/>
		<input type="hidden" name="vt_pass" value=""/>
	</form>
	
	<div class="jumbotron">
	  <h1 class="display-4">Hello, world!</h1>
		  <p class="lead">요기는 방명록을 작성하는 곳입니다.</p>
		  	<hr class="my-4">
		  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="#" role="button">홈으로 가기</a>
	</div>

	<form name="replyForm" method="post" action="<c:url value ='/reply/replyInsert.do'/>">
		<input type="hidden" value="${pageContext.request.remoteAddr }" name="rep_ip" /> 
		<input type="hidden" value="" name="vt_no" /> 
		<input type="hidden" name="rep_writer" value=""/>
		<input type="hidden" name="rep_pass" value=""/>
		<input type="hidden" name="rep_content" value=""/>
	</form>
	
	<form name="vtForm" method="post" enctype="multipart/form-data">
		<input type ="hidden" name="page" value=""/>
		<input type="hidden" value="${pageContext.request.remoteAddr }" name="vt_ip" /> 
		<input type="hidden" value="" name="vt_no" /> 
		<table>
			<tr>
				<td>
					<div class="input-group mb-3">
					  <div class="input-group-prepend" >
					    <span class="input-group-text" id="basic-addon1">작성자&nbsp;&nbsp;&nbsp;</span>
					  </div>
					  <input type="text" class="form-control" name="vt_writer" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
					  <input type="file" class="form-control" name="vt_file"  aria-label="Username" aria-describedby="basic-addon1">
					</div>
					
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="basic-addon1">패스워드</span>
					  </div>
					  <input type="text" class="form-control" name="vt_pass" placeholder="Userpass" aria-label="Username" aria-describedby="basic-addon1">
					</div>
	
					<div class="alert alert-dark" role="alert">
						<textarea  class="form-control" cols="120" rows="5" name="vt_content"></textarea>
					</div>
				</td>
			</tr>
			
			<tr>
				<td>
					<div>
						<button type="button"  class="btn btn-secondary" name="insertBtn" >등록</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<hr>
	
	<div id="cardInsert">
		
	</div>
	
	<div aria-label="Page navigation" id="pagingArea">
	
	</div>

	<div class="modal fade" id="visitorReplyModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form onsubmit="return false;" id="modalForm">
						<table>
							<tr>
								<td>작성자 	:</td>
								<td><input type="text" id="rep_writer" /></td>
							</tr>
							<tr>
								<td>패스워드	:</td>
								<td><input type="text" id="rep_pass" /></td>
							</tr>
							<tr>
								<td>내용	:</td>
								<td><textarea id="rep_content"></textarea></td>
							</tr>

						</table>
					</form>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="modalBtn">등록</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/visitorProcess.js"></script>
	<script>
		function paging(page){
			pagingVisitor(page);
		}
	
		paging(1);
	</script>
</body>
</html>