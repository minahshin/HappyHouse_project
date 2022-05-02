<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ssafy.happyhouse.model.AptDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<!DOCTYPE html>
<%
	HashMap<String, ArrayList<String>> donglist = (HashMap<String, ArrayList<String>>)request.getAttribute("donglist");
	request.setCharacterEncoding("utf-8");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Happy House</title>
			
		<!-- custom -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf7d224e09319ff6da99f64817992010&libraries=services"></script>
	</head>
	<script>
	var dong_map = {"":[]};
	<%
	if(donglist != null){
		Iterator<String> donglist_keys2 = donglist.keySet().iterator();
		while (donglist_keys2.hasNext()){ 
			String key = donglist_keys2.next();
			ArrayList<String> temp = donglist.get(key);%>
			dong_map["<%=key%>"]=[];
			<%
			for(int i=0; i<temp.size(); i++){
				%>
				dong_map["<%=key%>"].push("<%=temp.get(i)%>") 
				<%
			}
		}
	}
	%>
	var guSelect = function (value){
		$('#dong').empty();
		var option = $("<option>법정동</option>");
		$('#dong').append(option);
		if(dong_map[value]!=null){
			dong_map[value].map(item => {
				$('#dong').append($("<option value = "+item+" name=selectDong>"+item+"</option>"));
			})			
		}
	}
	
	function submitButton(){
		var gu = $('#gu').val();
		var dong = $('#dong').val();
		
		$("#select_district").attr("action", "${root}/address/" + gu + " " + dong).submit();
	}
	
	
	</script>

	<body>
		
		<div id="title">
			<img src="${root }/source/img/title-text.png">
		</div>
		<div id="selection">
			<div class="select">
				<form id="select_district" method = "post" action="">
					<select id="gu" onchange="guSelect(this.value)" name="selectGu">
					   <option>행정구</option>
					   <%
					   if(donglist != null){
						   Iterator<String> donglist_keys = donglist.keySet().iterator();
							while (donglist_keys.hasNext()){ 
								String value = donglist_keys.next();
							%>
								<option value=<%=value %> name="selectGu"><%=value%></option>
							<%}
					   }
						%>
					</select>
					
					<select id="dong" name="selectDong">
					   <option value="">법정동</option> 
					</select>
				</form>
				<button id ="searchBtn" type="submit" class="btn btn-outline-light me-2 searchBtn" onclick="submitButton();">주소로 시세 검색</button>
			</div>
		</div>
		
		<div id="map_outer">
		<!-- 
			<div id="map">
				<div id="select_data">
			    	<table class="table">
			    		
			    	</table>
			    </div>
			</div>			
		 -->
		 <div id="map" style="width:500px;height:400px;"></div>
		</div>
		
		<div id="outer_content">
			<div id="ad">
				<img src="${root }/source/img/aside-ad.png">
			</div>
			<div id="news">
				<h3>공지사항</h3>
				<hr>
				<div>[2022.03.11] 충격, 역삼동 멀티 캠퍼스 공시지가 5000억이 넘어.. </div>
				<div>[2022.03.11] H대 인근 부지에서 말라 비틀어진 대학원생 화석 발견, 감정가는? </div>
				<div>[2022.03.11] S대 인근 맛집 투어 - LHJ 인턴 기자 </div>
				<div>[2022.03.11] (속보) D역에 GTX 뚫린다 </div>
				<div>[2022.03.11] People Insight - 배고픈 사람? </div>
				<div>[2022.03.11] 더 이상 쓸게 없어서 절필 선언 </div>
			</div>
		</div>
		
		<div style="clear:both;"></div>
		
	  	<%@ include file="/WEB-INF/views/template/footer.jsp" %>
	  	<script>
			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center: new kakao.maps.LatLng(37.566826, 126.9786567), //지도의 중심좌표.
				level: 10 //지도의 레벨(확대, 축소 정도)
			};
			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			var geocoder = new kakao.maps.services.Geocoder();
			<%
			if(donglist != null){
				Iterator<String> keys =donglist.keySet().iterator();
				while (keys.hasNext()){ %>
					geocoder.addressSearch("<%=keys.next()%>", function(result, status) {
					    // 정상적으로 검색이 완료됐으면 
					    if (status === kakao.maps.services.Status.OK) {
					        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords
					        });
					    }
					});
				<%}	
			}
			%>
		</script>

	  	<%-- <script type="text/javascript" src="${root }/source/js/read_data.js"></script> --%>
	</body>
</html>