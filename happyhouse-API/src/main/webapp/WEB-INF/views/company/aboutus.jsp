<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Happy House</title>
		
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
			crossorigin="anonymous">
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>
			
		<!-- custom css -->
		<link rel="stylesheet" href="${root }/source/css/main.css">
	</head>

	<body>
		
		<div id="title">
			<img src="${root }/source/img/title-text.png">
		</div>
		
		<div id="selection" style="font-size:50px;text-align:left;color:white;padding-left:10%;margin-bottom:3%;">
			About Us
		</div>
		
		<div id="upper_content">
			<h1> Happy House를 소개합니다! </h1>
			<hr>
		</div>
		
		<div id="outer_content">
			<div id="ad">
				<img src="${root }/source/img/aboutus-left.jpeg">
			</div>
			<div id="news" style="border:0px;padding-top:0%;">
				<h3>Happy House는 좋은 집을 소개해드립니다.</h3>
				<hr>
				의식주 중 가장 중요한 "주"에 관한 고민은 모두가 하실 것입니다.<br>
				저희 Happy House는 고객님들의 고민을 줄여드리고자 시세 거래 서비스를 오픈했습니다.<br>
				많은 이용 부탁드립니다.<br><br><br>
				<h3>Happy House 정보</h3>
				<hr>
				대표 : 루싸피<br>
				위치 : 서울특별시 동대문구 싸피동 123-1<br>
				Tel : 02-1234-5678<br>
				Email : ssafy@happyhouse.com<br>
			<h6></h6>
			</div>
		</div>
		
		<div style="clear:both;"></div>
		
		<%@ include file="/WEB-INF/views/template/footer.jsp" %>
	</body>
</html>