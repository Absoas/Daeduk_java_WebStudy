$(function(){
		vtForm = $("[name='vtForm']");
		insertBtn = $("[name='insertBtn']");
		cardInsert= $("#cardInsert");
		listBody= $("#listBody");
		pagingArea = $("#pagingArea");
		replyModal = $("#visitorReplyModal");
		replyForm = $("[name = 'replyForm']");
		
		insertBtn.on("click",function(){
			vtForm.submit();
		});
		
		vtForm.ajaxForm({
 			dataType:'json',
 			success: visitorListMaker,
 			error:function(resp){
 				alert(resp.error);
 			}
 		});
		
		$("#modalBtn").on("click", function(){
 			var rep_writer = replyModal.find("#rep_writer").val();
 			var rep_content = replyModal.find("#rep_content").val();
 			var rep_pass = replyModal.find("#rep_pass").val();
 			replyForm.find("[name='rep_writer']").val(rep_writer);
 			replyForm.find("[name='rep_content']").val(rep_content);
 			replyForm.find("[name='rep_pass']").val(rep_pass);
 			replyForm.submit();
 			vtForm[0].reset();
 			$("#modalForm")[0].reset(); 			
 			replyModal.modal("hide");
 		});
		
	});
	

	function deleteFunc(vt_no){
		var vt_pass = prompt("비밀번호 입력");
		if(!vt_pass) return;
		document.deleteForm.vt_no.value=vt_no;
		document.deleteForm.vt_pass.value=vt_pass;
		document.deleteForm.submit();
	}
	
	function replyDelete(rep_no){
		var rep_pass = prompt("비밀번호 입력");
		if(!rep_pass) return;
		document.replydeleteForm.rep_no.value=rep_no;
		document.replydeleteForm.rep_pass.value=rep_pass;
		document.replydeleteForm.submit();
	}
	
	function replyFunc(vt_no){
		replyForm.find("[name='vt_no']").val(vt_no);
		replyModal.modal("show");
	}
	
	function imageUpdate(vt_no){
		console.log(vt_no);
	}
	
	function pagingVisitor(page){
		$.ajax({
			url: $.getContextPath()+"/visitor/visitorView.do?page="+page,
			data:{
				page:page
			},
			dataType:"json",
			success:visitorListMaker,
			error:function(resp){
				alert(resp.status);
			}
		});
	}
	
	function updateVisitor(vt_no){
		var vt_pass = prompt("비밀번호 입력");
		if(!vt_pass) return;
		
		var action = vtForm.attr("action");
		vtForm.attr("action", $.getContextPath()+"/visitor/visitorUpdate.do");
		document.vtForm.vt_no.value=vt_no;
		document.vtForm.vt_pass.value=vt_pass;
		document.vtForm.submit();
		vtForm.attr("action", action);
		vtForm[0].reset();
	}

		
	function visitorListMaker(resp) {
		if (resp.error) {
			visitorListMaker(1);
		} else { // 등록 성공
			var html = "";
			console.log(resp);
			if(resp.dataList){
				$.each(resp.dataList, function(idx, visit){
// 					.../100px180/
					html += "<div class='card' style='width: 18em; display: inline-block;'>";
					if(visit.vt_img){
						html += " <img class='card-img-top' onclick='updateVisitor("+visit.vt_no+")' src='data:image/*;base64,"+visit.vt_img+"' alt=''>";
					}else{
						html += " <img class='card-img-top' onclick='updateVisitor("+visit.vt_no+")' src='"+$.getContextPath()+"/images/1.jpg' alt=''>";
					}
					html += "  <div class='card-body'>";
					html += "    <h6 class='card-title'> 작성자 : "+visit.vt_writer+" 님이 등록하신 방명록입니다. </h6>";
					html += "   	<p class='card-text'> 내용 : "+visit.vt_content+"</p>";
					html += "   	<p class='card-text'> 날짜 : "+visit.vt_date+"</p>";
					html += "    <button  class='btn btn-primary' onclick='replyFunc("+visit.vt_no+");''>답글 등록</button>";
					html += "    <button  class='btn btn-danger' onclick='deleteFunc("+visit.vt_no+");''>삭제 버튼</button>";
					html += "    <hr>";
					html += "    <h6 class='card-title'>답글 목록</h6>";
					html += "    <div>";
					html += "   <table class = 'table'>";
					html += "   	<tbody id='listBody'>";
							$.each(visit.replyList,function(idx,list){
								if(list.rep_writer != null){
									html += " <tr><th>작성자</th><td>"+list.rep_writer+"</td><th>날짜</th><td>"+list.rep_date+"</td></tr>";
									html += " <tr><th>내용</th><td>"+list.rep_content+"</td><td><button onclick='replyDelete("+list.rep_no+")'>삭제</button></td></tr>";
								}
							});
					html += "   		</tbody>";
					html += "   	</table>";
					html += "     </div>";
					html += "  </div>";
					html += "</div>";
				});
			}else{
				html += "";
			}
			pagingArea.html(resp.pagingHTML);	
			cardInsert.html(html);
			vtForm[0].reset();
		}
	}
