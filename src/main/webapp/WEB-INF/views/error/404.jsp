<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/View/template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 : Happy House</title>
</head>
<body>
	<div id="title">
			<img src="${root }/source/img/title-text.png">
	</div>
	
	<div id="selection" style="color:white;font-size:40px;">
		Error - 404
	</div>
	<div style="text-align:center;margin:20px;">
		<h2>존재하지 않는 페이지입니다.</h2>
		<hr>
		<a href="${root }/main">메인으로 가기</a>
	</div>
	<%@ include file="/View/template/footer.jsp" %>
</body>
</html>