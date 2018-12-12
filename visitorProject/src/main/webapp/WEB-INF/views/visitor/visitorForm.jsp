<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
		insertBtn.on("click",function(){
			vtForm.submit();
		});
			
		
		vtForm.ajaxForm({
 			dataType:'json',
 			success: visitorListMaker,
 			error:function(resp){
 				alert(resp.status);
 			}
 		});
		
		pagingVisitor(1);
	
	});
	
	
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
			var html = "";
			if(resp.dataList){
				$.each(resp.dataList, function(idx, visit){
					html += "<div class='card' style='width: 18rem; display: inline-block;'>";
					html += " <img class='card-img-top' src='.../100px180/' alt='이미지 등록'>";
					html += "  <div class='card-body'>";
					html += "    <h6 class='card-title'>"+visit.vt_writer+" 님이 등록하신 방명록입니다. </h6>";
					html += "   	<p class='card-text'>"+visit.vt_content+"</p>";
					html += "   	<p class='card-text'>"+visit.vt_date+"</p>";
					html += "    <a href='#' class='btn btn-primary'>요긴 미정</a>";
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
</body>
</html>