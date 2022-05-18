<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ssafy.happyhouse.model.StoreDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<!DOCTYPE html>
<%
// 매매가격 데이터 가져오기
List<StoreDto> shoplist = (List<StoreDto>)request.getAttribute("shoplist");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Happy House</title>
			
		<!-- custom -->
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bf7d224e09319ff6da99f64817992010&libraries=services"></script>
		<script>
			function submitButton() {
				let addr = $("#addressInput").val();
				let path = "${root}/shop?address=" + addr;
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
				<input type="text" id="addressInput" name="address">
			</form>
			<button id ="searchBtn" type="submit" class="btn btn-outline-light me-2 searchBtn" onclick="submitButton();">주소로 상권 검색</button>
		</div>
		<div class="select" style="font-size:40px;text-align:center;">
			<% if(shoplist != null) { %>
				<div style="margin-top:10px;">
					"<%=request.getParameter("address") %>"을 포함하는 상권 정보
				</div>
			<% } %>
		</div>
		
		<% if(shoplist == null) { %>
			<div style="text-align:center;font-size:40px;">
				주소를 입력해주세요.
			</div>
		<% } else if(shoplist.size() == 0) { %>
			<div style="text-align:center;font-size:40px;">
				검색 결과가 없습니다.
			</div>
		<% } else { 
				int count = 0;%>
		<table class="table" style="margin:2%;width:96%;">
			<tr style="text-align:center;font-weight:bold;">
				<td></td>
				<td>가게 이름</td>
			    <td>업종 분류</td>
			    <td>지번 주소</td>
			    <td>도로명 주소</td>
			    <td>우편번호</td>
			</tr>
			<%for(StoreDto it : shoplist){ %>
			    <tr>
			    	<td><%=++count %></td>
			    	<td><%=it.getName()%></td>
			    	<td><%=it.getStoreType() %></td>
			    	<td><%=it.getJibunAddress() %></td>
			    	<td><%=it.getDoroAddress() %></td>
			    	<td><%=it.getZipCode() %></td>
			    <tr>
			 <% } %>
		</table>
		<% } %>
		
		<div style="clear:both;"></div>
		
	  	<%@ include file="/WEB-INF/views/template/footer.jsp" %>
	  	<%-- <script type="text/javascript" src="${root }/source/js/read_data.js"></script> --%>
	</body>
</html>