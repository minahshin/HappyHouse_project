<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ssafy.happyhouse.model.StoreDtoDistance"%>
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
		<script>
			function submitButton() {
				var distance = $("#distance").val();
				if(distance) {
					var aptname = '<%=request.getParameter("aptName") %>';
					var lat = <%=request.getParameter("lat") %>;
					var lng = <%=request.getParameter("lng") %>;
					$("#select_district").attr("action", "/shop/around?aptName=" + aptname + "&lat=" + lat + "&lng=" + lng).submit();
				} else {
					alert("반경을 입력해주세요(단위 : m)");
				}
			}
			
			function showDetail() {
				
			}
		</script>	
		
		<style>
			.text {
				color : white;
				font-weight : bold;
			}
			
			.check_text {
				color : white;
			}
		</style>
	</head>
	<body>
		
		<div id="title">
			<img src="${root }/source/img/title-text.png">
		</div>
		<div id="selection" style="height:320px">
			<div style="font-size:40px;color:white">
				<%=request.getParameter("aptName") %> 주변 상권 정보<br>
			</div>
			<form id="select_district" method = "post" action="">
				<input type="hidden" id="lat" name="lat" value=<%=request.getParameter("lat") %>>
				<input type="hidden" id="lng" name="lng" value=<%=request.getParameter("lng") %>>
				<span class="text">반경(m) : </span><input type="number" id="distance" name="distance" placeholder="1~1000" min="1" max="1000" maxLength="4"><br><br>
				<span class="text">검색어 : </span><input type="text" id="keyword" name="keyword" placeholder="가게 이름의 단어를 포함하여 검색"><br><br>
				<span class="text">업종 : </span>
				<input type="checkbox" name="categories" value="음식" checked="checked"><span class="check_text">음식점</span>
				<input type="checkbox" name="categories" value="소매" checked="checked"><span class="check_text">마트/가게</span>
				<input type="checkbox" name="categories" value="생활서비스" checked="checked"><span class="check_text">생활 서비스(이,미용 등)</span>
				<input type="checkbox" name="categories" value="관광/여가/오락" checked="checked"><span class="check_text">취미 생활/관광</span>
				<input type="checkbox" name="categories" value="학문/교육" checked="checked"><span class="check_text">교육</span>
				<input type="checkbox" name="categories" value="스포츠" checked="checked"><span class="check_text">스포츠</span>
				<input type="checkbox" name="categories" value="숙박" checked="checked"><span class="check_text">숙박</span>
				<input type="checkbox" name="categories" value="부동산" checked="checked"><span class="check_text">부동산 중개소</span><br>
				<span class="text">청소년 이용 금지 시설 제외 </span><input type="checkbox" name="isKidsSafe" value="YES"><br>
			</form>
			<br><button id ="searchBtn" type="submit" class="btn btn-outline-light me-2 searchBtn" onclick="submitButton();">조건으로 상점 검색</button>
		</div>
		
		<c:if test="${empty shoplist}">
			<div style="text-align:center;font-size:40px;margin-top:2%">
				검색 조건에 일치하는 상권 정보가 없습니다.<br>
				검색 조건을 확인하신 뒤 다시 검색해주세요.
			</div>
		</c:if>
		
		<c:if test="${!empty shoplist }">
			<% int count = 0; %>
			<table class="table" style="margin:2%;width:96%;">
			<tr style="text-align:center;font-weight:bold;">
				<td></td>
				<td>가게 이름</td>
			    <td>업종 분류</td>
			    <td>지번 주소</td>
			    <td>도로명 주소</td>
			    <td>우편번호</td>
			    <td>거리</td>
			</tr>
			<c:forEach var="store" items="${shoplist }">
			    <tr>
			    	<td><%=++count %></td>
			    	<td>${store.name }</td>
			    	<td>${store.storeType }</td>
			    	<td>${store.jibunAddress }</td>
			    	<td>${store.doroAddress }</td>
			    	<td>${store.zipCode }</td>
			    	<td>${store.distance * 1000} m</td>
			    <tr>
			 </c:forEach>
			</table>
		</c:if>
		
		<div style="clear:both;"></div>
		
	  	<%@ include file="/WEB-INF/views/template/footer.jsp" %>
	  	<%-- <script type="text/javascript" src="${root }/source/js/read_data.js"></script> --%>
	</body>
</html>