<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ssafy.happyhouse.model.AptDto"%>
<%@page import="com.ssafy.happyhouse.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<!DOCTYPE html>
<%
// 매매가격 데이터 가져오기
List<AptDto> houselist = (List<AptDto>)request.getAttribute("houselist");
%>
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
			<div class="select" style="font-size:40px;text-align:center;color:white;">
				${memberDto.memberName}님의 즐겨 찾기 주소의 거래 정보
			</div>
		</div>

		<% if(houselist == null) { %>
			<div></div>
		<% } else if(houselist.size() == 0) { %>
			<div style="text-align:center;font-size:40px;">
				즐겨 찾기 지역에 해당하는 거래 정보가 없거나 즐겨 찾기가 없습니다.
			</div>
		<% } else { %>
		<table class="table" style="margin:2%;width:96%;">
			<tr style="text-align:center;font-weight:bold;">
				<td>아파트 이름</td>
			    <td>거래 가격</td>
			    <td>거래 일자</td>
			    <td>면적</td>
			    <td>층</td>
			    <td>주소</td>
			</tr>
			<%for(AptDto it : houselist){ %>
			    <tr>
			    	<td><%=it.getAptName() %></td>
			    	<td><%=it.getDealAmount() %>만원</td>
			    	<td><%=it.getDealDay() %></td>
			    	<td><%=it.getArea() %>m²</td>
			    	<td><%=it.getFloor() %>층</td>
			    	<td><%=it.getDongName() %> <%=it.getJibun() %></td>
			    <tr>
			 <% } %>
		</table>
		<% } %>
		
		<div style="text-align:center;font-size:30px;">
			<a href="${root }/favorite/${memberDto.memberId}" style="text-decoration:none;padding:2%">즐겨찾기 관리 페이지로</a>
		</div>
		
		<div style="clear:both;"></div>
		
	  	<%@ include file="/WEB-INF/views/template/footer.jsp" %>
	  	<%-- <script type="text/javascript" src="${root }/source/js/read_data.js"></script> --%>
	</body>
</html>