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
		
		<c:if test="${empty houselist }">
			<div style="text-align:center;font-size:40px;">
				검색 결과가 없습니다.
			</div>
		</c:if>
		
		<c:if test="${!empty houselist }">
			<table class="table" style="margin:2%;width:96%;">
				<tr style="text-align:center;font-weight:bold;">
					<td>아파트 이름</td>
				    <td>거래 가격</td>
				    <td>거래 일자</td>
				    <td>면적</td>
				    <td>층</td>
				    <td>거래 타입</td>
				    <td>주소</td>
				    <td>건축년도</td>
				</tr>
				
				<c:forEach var="aptDto" items="${houselist }">
					<tr>
				    	<td>${aptDto.aptName}</td>
				    	<td>${aptDto.dealAmount }만원</td>
				    	<td>${aptDto.dealYear}년 ${aptDto.dealMonth}월 ${aptDto.dealDay}일</td>
				    	<td>${aptDto.area}m²</td>
				    	<td>${aptDto.floor}층</td>
				    	<td>${aptDto.type}</td>
				    	<td><%=request.getParameter("selectGu") %> ${aptDto.dongName} ${aptDto.jibun}</td>
				    	<td>${aptDto.buildYear}년</td>
			    	<tr>
				</c:forEach>
			</table>
		</c:if>
		
		<div style="text-align:center;font-size:30px;">
			<a href="${root }/main" style="text-decoration:none;color:green;padding:2%;">다른 동네 검색하기</a>
			<a href="${root }/house/search" style="text-decoration:none;padding:2%">아파트 명으로 검색하기</a>
		</div>
		
		<div style="clear:both;"></div>
		
	  	<%@ include file="/WEB-INF/views/template/footer.jsp" %>
	  	<%-- <script type="text/javascript" src="${root }/source/js/read_data.js"></script> --%>
	</body>
</html>