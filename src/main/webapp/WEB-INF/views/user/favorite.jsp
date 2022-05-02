<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.happyhouse.favorites.FavoritesDTO"%>
<%@page import="com.happyhouse.account.AccountDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/View/template/header.jsp" %>
<!DOCTYPE html>
<%
// 매매가격 데이터 가져오기
List<String> favlist = (List<String>)request.getAttribute("favorite");
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
				${user.getName()}님의 즐겨 찾기 목록
			</div>
		</div>

		<% if(favlist == null) { %>
			<div></div>
		<% } else if(favlist.size() == 0) { %>
			<div style="text-align:center;font-size:40px;">
				즐겨 찾기가 없습니다.
			</div>
		<% } else { 
			int count = 0;%>
		<table class="table" style="margin:2%;width:96%;">
			<tr style="text-align:center;font-weight:bold;">
				<td>번호</td>
			    <td>주소</td>
			    <td></td>
			</tr>
			<%for(String it : favlist){ %>
			    <tr>
			    	<td><%=++count %></td>
			    	<td><%=it %></td>
			    	<td><a href="${root }/shop?address=<%=it %>">상권 보기</a></td>
			    <tr>
			 <% } %>
		</table>
		<% } %>
		
		<div style="text-align:center;font-size:30px;">
			<a href="${root }/favorite?action=showFavoriteHouse" style="text-decoration:none;padding:2%">즐겨찾기 지역 정보 페이지로</a>
		</div>
		
		<div style="clear:both;"></div>
		
	  	<%@ include file="/View/template/footer.jsp" %>
	  	<%-- <script type="text/javascript" src="${root }/source/js/read_data.js"></script> --%>
	</body>
</html>