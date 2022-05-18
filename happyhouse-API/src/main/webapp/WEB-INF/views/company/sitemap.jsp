<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.happyhouse.model.MemberDto"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Happy House</title>
	</head>

	<body>
		<div id="title">
			<img src="${root}/source/img/title-text.png">
		</div>
		
		<div id="selection" style="font-size:50px;text-align:left;color:white;padding-left:10%;margin-bottom:3%;padding-top:20px;">
			Site Map
		</div>
		
		<div id="outer_content">
			<div id="news" style="border:0px;">
			<h3>Happy House</h3>
				<ul style="font-size:25px;">
		      		<li><a href="main" style="text-decoration:none;">Home</a></li>
		      		<li><a href="house/search" style="text-decoration:none;">시세 검색</a></li>
		      		<c:if test="${!empty memberDto }">
		      			<li><a href="${root }/favorite/${memberDto.memberId }/houses" style="text-decoration:none;">즐겨찾기 지역 정보</a></li>
		      		</c:if>
		      		<li><a href="${root }/shop" style="text-decoration:none;">상권 검색</a></li>
		      		<li><a href="${root }/aboutUs" style="text-decoration:none;">About Us</a></li>
	    		</ul>
	    		<hr>
	    		<h3>회원</h3>
	    		<c:if test="${empty memberDto }">
					<ul style="font-size:25px;" id="account">
			      		<li><a href="${root }/user/login" style="text-decoration:none;">Login</a></li>
			      		<li><a href="${root }/user/signup" style="text-decoration:none;">Sign Up</a></li>
		    		</ul>
				</c:if>
				<c:if test="${!empty memberDto }">
					<ul style="font-size:25px;" id="account">
			      		<li><a href="${root }/user/logout" style="text-decoration:none;">Logout</a></li>
			      		<li><a href="${root }/user/userinfo" style="text-decoration:none;">회원 정보</a></li>
			      		<li><a href="${root }/favorite/${memberDto.memberId}" style="text-decoration:none;">즐찾 관리</a></li>
		    		</ul>
				</c:if>
			</div>
		</div>
		
		<div style="clear:both;"></div>
		
		<%@ include file="/WEB-INF/views/template/footer.jsp" %>
	</body>
</html>