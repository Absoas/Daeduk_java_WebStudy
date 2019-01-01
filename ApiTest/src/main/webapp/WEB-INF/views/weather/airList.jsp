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
		contentList=[];
		getAir();
		tBodyList = $("#tBodyList");
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = { 
		      center: new daum.maps.LatLng(35.498692, 127.747406 ), // 지도의 중심좌표
		      level: 13 // 지도의 확대 레벨
		 };

		map = new daum.maps.Map(mapContainer, mapOption);

		//지도 확대 X
		map.setZoomable(false); 


		markerSidoPositionArray = [
			new daum.maps.LatLng(37.56667,126.97806),	// 서울
			new daum.maps.LatLng(35.17944 ,129.07556),	// 부산
			new daum.maps.LatLng(36.35111, 127.38500),    // 대전
			new daum.maps.LatLng(33.50000, 126.51667),    // 제주
			new daum.maps.LatLng(36.81528, 127.11389),	// 충남
			new daum.maps.LatLng(36.64389 ,127.48944),	// 충북
			new daum.maps.LatLng(35.87222 ,128.60250),	// 대구
			new daum.maps.LatLng(37.45639, 126.70528),	// 인천
			new daum.maps.LatLng(36.01944 ,129.34167),	//경북
// 			new daum.maps.LatLng(37.39444 ,126.95556),	// 경기
			new daum.maps.LatLng(35.22917 ,128.67500),	//경남
			new daum.maps.LatLng(35.82500 ,127.15000),	// 전북
			new daum.maps.LatLng(35.15972 ,126.85306),	 // 전남
			new daum.maps.LatLng(37.722185, 128.852041)	// 강원
		];
		  
		imageSize = new daum.maps.Size(15, 10), // 마커이미지의 크기입니다
		imageOption = {offset: new daum.maps.Point(10, 15)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

	});
		
	function getAir() {
		var sidoList = ["seoul","busan","daejeon","jeju","chungnam","chungbuk","daegu","incheon", "gyeongbuk","gyeongnam","jeonbuk","jeonnam","gangwon"];
		var imageSrc = "";
		
		$.ajax({
			url : '${pageContext.request.contextPath}/air/showAir.do',
			method: 'post',
			data : {
			},
			dataType : "json",
			success : function(resp){
			console.log(resp);
			var list = resp.response.body.items;
			var html = "";
			if(list){
				$.each(list,function(idx,si){
					html += "<tr><td>"+si.dataTime+"</td>";
					$.each(sidoList, function(id,sido){
						var color = "";
						
					    
					    if( 0< si[sido] && si[sido] <= 15){
					    	color = "b1";
					    }else if(16< si[sido] && si[sido] <= 35){
					    	color = "g1";
					    }else if(36< si[sido] && si[sido] <= 75){
					    	color = "y1";
					    }else{
					    	color = "r1";
					    }
					    
					    imageSrc = '${pageContext.request.contextPath}/image/'+color+'.png'; // 마커이미지의 주소입니다  
						var content = 
						'<div class="customoverlay">' +
					    '  <a href="http://map.daum.net/link/map/11394059" target="_blank">' +
					    '    <span class="'+color+'">'+si[sido]+'</span>' +
					    '  </a>' +
					    '</div>';
					    contentList.push(content);
					    html += "<td>"+si[sido]+"</td>";
					});
					html += "</tr>";
				});
			}
			
			//마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
			var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption);

			$.each(markerSidoPositionArray , function(idx, position){
				var marker = new daum.maps.Marker({
				position: position,
				image: markerImage // 마커이미지 설정 
			});
				
				marker.setMap(map); 
				
				var customOverlay = new daum.maps.CustomOverlay({
				    map: map,
				    position: position,
				    content: contentList[idx],
				    yAnchor: 1 
				});
			});
		
			tBodyList.html(html);
		},
		error : function(resp) {
			console.log(resp.status);
		}
	});
}
	
</script>

<style>
.customoverlay {position:relative;bottom:5px;}
.customoverlay a {display:block;text-decoration:none;color:#000;text-align:center;border-radius:2px;font-size:14px;font-weight:bold;overflow:hidden;}
.b1{
	background: #6A92E4;
}
.g1{
	background: #6A92E4;
}
.r1{
	background: #FC5B0B;
}
.y1{
	background: #00B050;
}

</style>

</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<td>시간</td>
				<td>서울</td>
				<td>부산</td>
				<td>대전</td>
				<td>제주</td>
				<td>충남</td>
				<td>충북</td>
				<td>대구</td>
				<td>인천</td>
				<td>경북</td>
<!-- 				<td>경기</td> -->
				<td>경남</td>
				<td>전북</td>
				<td>전남</td>
				<td>강원</td>
				<td></td>
			</tr>
		</thead>
		
		<tbody id="tBodyList">
		
		</tbody>
	</table>
	
	<div id="map" style="width:50%;height:750px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cdd539404ca75df59eae1d4d6af80bc6&libraries=services"></script>
</body>
</html>