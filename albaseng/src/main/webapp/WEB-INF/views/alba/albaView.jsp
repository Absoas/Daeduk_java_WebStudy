<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	
<script type="text/javascript">
	function makeReply(alba_code){
		$.ajax({
			url: "${pageContext.request.contextPath}/lic/albalicView.do",
			data:{
				alba_code:alba_code
			},
			dataType:"json",
			success:licListMaker,
			error:function(resp){
				console.log(resp.status);
			}
		})
	}
	
	function licListMaker(resp){
		licBody = $("#licBody");
		
		if(resp.errors){
			alert(resp.errors.message);
		}else{	
			var html = "";
			if(resp){
				$.each(resp , function(idx, val){
					html += "<tr>";
					html += "<td>"+val.CODEVALUE+"</td>";
					html += "</tr>";
				});
			}else if(resp == ""){
				html += "<tr><td>자격증 없음.</td></tr>";
			}
			licBody.html(html);
		}
	}
</script>

</head>
<body>
	<table class="table">
		<tbody>
			<tr><th>알바생이름</th><td>${alba.alba_name}</td></tr>
			<tr><th>알바생나이</th><td>${alba.alba_age}</td></tr>
			<tr><th>알바생번호</th><td>${alba.alba_tel}</td></tr>
			<tr><th>알바생주소</th><td>${alba.alba_address}</td></tr>
			<tr><th>알바생학력</th><td>${alba.alba_grade}</td></tr>
			<tr><th>알바생성별</th><td>${alba.alba_gender}</td></tr>
			<tr><th>알바생경력</th><td>${alba.alba_career}</td></tr>
		</tbody>
		
		<tfoot>
			<tr>
				<td>
					<table class="table">
						<thead>
							<tr><td>자격증 리스트</td></tr>
						</thead>
					
						<tbody id="licBody">
						
						</tbody>
					</table>
				</td>
			</tr>
		</tfoot>
	</table>
	
	<input type="button" value="알바생 수정" class="btn btn-info"
		onclick="location.href='${pageContext.request.contextPath }/alba/albaUpdate.do?who=${alba.alba_code}'"
	/>
	
	<input type="button" value="알바생 삭제" class="btn btn-info"
		onclick="location.href='${pageContext.request.contextPath }/alba/albaDelete.do?who=${alba.alba_code}'"
	/>
	
	<script>
		makeReply('${alba.alba_code}');
	</script>
</body>
</html>