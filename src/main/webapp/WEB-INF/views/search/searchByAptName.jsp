<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.happyhouse.house.HouseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/View/template/header.jsp" %>
<!DOCTYPE html>
<%
// 매매가격 데이터 가져오기
List<HouseDto> houselist = (List<HouseDto>)request.getAttribute("houselist");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Happy House</title>
			
		<!-- custom -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf7d224e09319ff6da99f64817992010&libraries=services"></script>
		<script>
			function submitButton() {
				let aptName = $("#aptNameInput").val();
				let path = "${root}/house?aptName=" + aptName;
				$("#select_district").attr("action", path).submit();
			}
		</script>	
	</head>
	<body>
		
		<div id="title">
			<img src="${root }/source/img/title-text.png">
		</div>
		<div id="selection">
			<form id="select_district" method = "get" action="">
				<input type="text" id="aptNameInput" name="aptName" style="width:500px;">
			</form>
			<button id ="searchBtn" type="submit" class="btn btn-outline-light me-2 searchBtn" onclick="submitButton();">아파트 이름으로 시세 검색</button>
		</div>
		<div class="select" style="font-size:40px;text-align:center;">
			<% if(houselist != null) { %>
				<div style="margin-top:10px;">
					"<%=request.getParameter("aptName") %>" 거래 정보
				</div>
			<% } %>
		</div>
		
		<% if(houselist == null) { %>
			<div style="text-align:center;font-size:40px;">
				아파트의 이름 또는 이름에 포함된 단어로 검색해주세요.
			</div>
		<% } else if(houselist.size() == 0) { %>
			<div style="text-align:center;font-size:40px;">
				검색 결과가 없습니다.
			</div>
		<% } else { %>
		<table class="table" style="margin:2%;width:96%;">
			<tr style="text-align:center;font-weight:bold;">
				<td>아파트 이름</td>
			    <td>거래 가격</td>
			    <td>거래 일자</td>
			    <td>면적</td>
			    <td>층</td>
			    <td>거래 타입</td>
			    <td>전세가</td>
			    <td>주소</td>
			    <td>건축년도</td>
			    <td>위도</td>
			    <td>경도</td>
			</tr>
			<%for(HouseDto it : houselist){ %>
			    <tr>
			    	<td><%=it.getAptName() %></td>
			    	<td><%=it.getDealAmount() %>만원</td>
			    	<td><%=it.getDealYear() %>년 <%=it.getDealMonth() %>월 <%=it.getDealDay() %>일</td>
			    	<td><%=it.getArea() %>m²</td>
			    	<td><%=it.getFloor() %>층</td>
			    	<td><%=it.getType() %></td>
			    	<td>
			    		<% if(it.getRentMoney() != null) { %>
			    			<%=it.getRentMoney() %>만원
			    		<%} else { %>
			    			정보 없음
			    		<% } %>
			    	</td>
			    	<td><%=it.getDongName() %> <%=it.getJibun() %></td>
			    	<td><%=it.getBuildYear() %>년</td>
			    	<td><%=it.getLat() %></td>
			    	<td><%=it.getLng() %></td>
			    <tr>
			 <% } %>
		</table>
		<% } %>
		
		<div style="text-align:center;font-size:30px;">
			<a href="${root }/house?act=searchByAptName" style="text-decoration:none;padding:2%">다른 아파트 명으로 검색하기</a>
			<a href="${root }/main" style="text-decoration:none;color:green;padding:2%;">주소로 검색하기</a>
		</div>
		
		<div style="clear:both;"></div>
		
	  	<%@ include file="/View/template/footer.jsp" %>
	  	<%-- <script type="text/javascript" src="${root }/source/js/read_data.js"></script> --%>
	</body>
</html>