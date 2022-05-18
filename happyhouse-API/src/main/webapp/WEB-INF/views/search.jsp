<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ssafy.happyhouse.model.AptDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Happy House</title>
			
		<!-- custom -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf7d224e09319ff6da99f64817992010&libraries=services"></script>
	</head>

	<body>
		
		<div id="title">
			<img src="${root }/source/img/title-text.png">
		</div>
		<div id="selection">
			<div class="select text-white" style="font-size:40px;">
				<%=request.getParameter("selectGu") %> <%=request.getParameter("selectDong") %> 거래 정보
			</div>
		</div>
		<div class="select" style="font-size:40px;text-align:center;">
			<c:if test="${!empty houselist }">
				<div style="margin-top:10px;">
					
				</div>
			</c:if>
		</div>
		
		<c:if test="${empty houselist }">
			<div style="text-align:center;font-size:40px;">
				검색 결과가 없습니다.
			</div>
		</c:if>
		
		<c:if test="${!empty houselist }">
			<div class="row" style="padding-left: 10%;padding-right: 10%">
				<div class="col-sm-6 justify-center">
					<div style="overflow: auto; height: 500px">
					<c:if test="${!empty houselist }">
						<div class="justify-center" style="font-size:12px;">
							<table class="table"  >
								<tr style="text-align:center;font-weight:bold;">
									<td>아파트 이름</td>
								    <td>거래 가격</td>
								    <td>거래 일자</td>
								    <td>면적</td>
								    <td>층</td>						
								    <td>주소</td>
								    <td>건축년도</td>
								    <td>상권 정보</td>
								</tr>
								
								<c:forEach var="aptDto" items="${houselist }">
									<tr>
								    	<td><a href="javascript:myMapFocus(${aptDto.lat}, ${aptDto.lng}, '${aptDto.aptName}')">${aptDto.aptName}</a></td>
								    	<td>${aptDto.dealAmount }만원</td>
								    	<td>${aptDto.dealYear}년 ${aptDto.dealMonth}월 ${aptDto.dealDay}일</td>
								    	<td>${aptDto.area}m²</td>
								    	<td>${aptDto.floor}층</td>						
								    	<td>${aptDto.dongName} ${aptDto.jibun}</td>
								    	<td>${aptDto.buildYear}년</td>
								    	<td><a href="/shop/around?aptName=${aptDto.aptName}&lat=${aptDto.lat}&lng=${aptDto.lng}">상권</a></td>
							    	<tr>
								</c:forEach>
							  </table>
							</div>
					</c:if>
					</div>
				</div>
				<div class="col-sm-6 text-light mx-auto justify-center">
						<!-- 왼쪽에서 선택한 아파트 맵 정보 -->
						<div id="map" class="mx-auto mt-6" style="width:600px;height:500px"></div>
						<!-- -------------------- -->
				</div>
			</div>
		</c:if>

<script>
	
	var mapContainer = document.getElementById('map'), //지도를 담을 영역의 DOM 레퍼런스
		mapOption = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(${houselist[0].lat}, ${houselist[0].lng}), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(mapContainer, mapOption); //지도 생성 및 객체 리턴
	
	var iwContent = '<div style="padding:5px; font-size:12px" class="text-primary">${houselist[0].aptName}</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = mapOption["center"], //인포윈도우 표시 위치입니다
    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
	
    var infowindow = new kakao.maps.InfoWindow({
        map: map, // 인포윈도우가 표시될 지도
        position : iwPosition, 
        content : iwContent,
        removable : iwRemoveable
    });

	// 아파트를 클릭하면 해당 동으로 spotlight, infowindow 변경
	function myMapFocus(lat, lng, aptName) {
		var newLatLng = new kakao.maps.LatLng(lat,lng);
		
		infowindow = new kakao.maps.InfoWindow({
			map: map,
			position : newLatLng,
			content : '<div style="padding:5px; font-size:12px" class="text-primary">' + aptName + '</div>',
			removable : iwRemoveable
		});
		
		
		map.panTo(newLatLng);
	}
	
</script>
		
		<div style="text-align:center;font-size:30px;">
			<a href="${root }/main" style="text-decoration:none;color:green;padding:2%;">다른 동네 검색하기</a>
			<a href="${root }/house/search" style="text-decoration:none;padding:2%">아파트 명으로 검색하기</a>
		</div>
		
		<div style="clear:both;"></div>
		
	  	<%@ include file="/WEB-INF/views/template/footer.jsp" %>
	  	<%-- <script type="text/javascript" src="${root }/source/js/read_data.js"></script> --%>
	</body>
</html>