<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="http://malsup.github.com/jquery.form.js"></script> 
<script>
	$(function(){
		tBodyList = $("#tBodyList");
		getTodayWeather();
	});
		
	function getTotalWeather() {
		$.ajax({
			url : "${pageContext.request.contextPath}/weather/showWeather.do",
			method: 'post',
			dataType : "json",
			success : function(resp){
				console.log(resp);
				var html = "";
				tBodyList.html(html);
			},
			error : function(resp) {
				console.log(resp.status);
			}
		});
	}
	
	function getTodayWeather() {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/weather/showWeather.do",
			method: 'post',
			data : {
				date : new Date()
			},
			dataType : "json",
			success : function(resp){
				console.log(resp);
				var html = "";
				tBodyList.html(html);
			},
			error : function(resp) {
				console.log(resp.status);
			}
		});
	}
	
	function getCityWeather(city) {
		var city = city;
		var appkey = "fbedaa69bce997e934bfccccc40e5baa";
		
		$.ajax({
			url : "https://api.openweathermap.org/data/2.5/weather?q="+city+"&lang=en&appid="+appkey+"&units=metric",
			method: 'get',
			dataType : "json",
			success : function(resp){
				var html = "";
				if(resp.list){
					console.log(resp.list);
					$.each(resp.list,function(idx,si){
					});
				}
				tBodyList.html(html);
			},
			error : function(resp) {
				console.log(resp.status);
			}
		});
	}
</script>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<td>시간</td>
				<td>부산</td>
				<td>대전</td>
			</tr>
		</thead>
		
		<tbody id="tBodyList">
		
		</tbody>
	</table>
</body>
</html>