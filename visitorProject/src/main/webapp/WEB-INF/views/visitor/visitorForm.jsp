<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
=======
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		vtForm = $("[name='vtForm']");
		insertBtn = $("[name='insertBtn']");
		cardInsert= $("#cardInsert");
		pagingArea = $("#pagingArea");
<<<<<<< HEAD
		var delModal = $("#visitorDeleteModal");
 		
=======
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
		
		insertBtn.on("click",function(){
			vtForm.submit();
		});
<<<<<<< HEAD
=======
			
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
		
		vtForm.ajaxForm({
 			dataType:'json',
 			success: visitorListMaker,
 			error:function(resp){
 				alert(resp.status);
 			}
 		});
<<<<<<< HEAD
		pagingVisitor(1);
	});
	

	function deleteFunc(vt_no){
		var vt_pass = prompt("비밀번호 입력");
		if(!vt_pass) return;
		document.deleteForm.vt_no.value=vt_no;
		document.deleteForm.vt_pass.value=vt_pass;
		document.deleteForm.submit();
	}
=======
		
		pagingVisitor(1);
	
	});
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
	
	
	function pagingVisitor(page){
		$.ajax({
			url:"${pageContext.request.contextPath}/visitor/visitorView.do",
			data:{
				page:page
			},
			dataType:"json",
			success:visitorListMaker,
			error:function(resp){
				console.log(resp.status);
			}
		});
	}
		
	function visitorListMaker(resp) {
		if (resp.error) {
			alert(resp.message); 					
		} else { // 등록 성공
<<<<<<< HEAD
			console.log(resp);
			var html = "";
			if(resp.dataList){
				$.each(resp.dataList, function(idx, visit){
// 					.../100px180/
					html += "<div class='card' style='width: 18rem; display: inline-block;'>";
					html += " <img class='card-img-top' src='' alt='이미지 등록'>";
=======
			var html = "";
			if(resp.dataList){
				$.each(resp.dataList, function(idx, visit){
					html += "<div class='card' style='width: 18rem; display: inline-block;'>";
					html += " <img class='card-img-top' src='.../100px180/' alt='이미지 등록'>";
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
					html += "  <div class='card-body'>";
					html += "    <h6 class='card-title'>"+visit.vt_writer+" 님이 등록하신 방명록입니다. </h6>";
					html += "   	<p class='card-text'>"+visit.vt_content+"</p>";
					html += "   	<p class='card-text'>"+visit.vt_date+"</p>";
<<<<<<< HEAD
					html += "    <button  class='btn btn-primary' onclick='deleteFunc("+visit.vt_no+");''>삭제 버튼</button>";
=======
					html += "    <a href='#' class='btn btn-primary'>요긴 미정</a>";
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
					html += "    <hr>";
					html += "    <h6 class='card-title'>답글 목록</h6>";
					html += "    <div></div>";
					html += "  </div>";
					html += "</div>";
				});
			}else{
				html += "<tr><td colspan='4'>데이터 없음.</td></tr>";
			}
			pagingArea.html(resp.pagingHTML);	
			cardInsert.html(html);
			vtForm[0].reset();
		}
	}

</script>

<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
	<form name="deleteForm" action="<c:url value ='/visitor/visitorDelete.do'/>" method="post">
		<input type="hidden" name="vt_no" />
		<input type="hidden" name="vt_pass" />
	</form>
	
=======
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
	<div class="jumbotron">
	  <h1 class="display-4">Hello, world!</h1>
		  <p class="lead">요기는 방명록을 작성하는 곳입니다.</p>
		  	<hr class="my-4">
		  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="#" role="button">홈으로 가기</a>
	</div>

	<form name="vtForm" method="post">
		<input type="hidden" value="${pageContext.request.remoteAddr }" name="vt_ip" /> 
		<table>
			<tr>
				<td>
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="basic-addon1">작성자&nbsp;&nbsp;&nbsp;</span>
					  </div>
					  <input type="text" class="form-control" name="vt_writer" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
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
	
	<div aria-label="Page navigation" id="pagingArea"></div>
<<<<<<< HEAD


	<div class="modal fade" id="visitorDeleteModal" tabindex="-1"
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
						<input type="hidden" id="bo_no" value="${board.bo_no }" /> <input
							type="text" id="rep_no" /> 비밀번호 : <input type="text"
							id="rep_pass" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="modalBtn">삭제</button>
				</div>
			</div>
		</div>
	</div>

=======
>>>>>>> 64313d8565fb6e23b59dccc790c86ae00d160013
</body>
</html>