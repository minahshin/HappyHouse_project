<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
	    	<p class="col-md-4 mb-0 text-muted">© 2022 Happy House, Inc</p>
	
	    	<a href="${root }/main" class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
	      		<img src="${root}/source/img/header-house.png">
	    	</a>
	
	    	<ul class="nav col-md-4 justify-content-end">
	      		<li class="nav-item"><a href="${root}/main" class="nav-link px-2 text-muted">Home</a></li>
	      		<li class="nav-item"><a href="${root}/house/search" class="nav-link px-2 text-muted">시세 검색</a></li>
	      		<c:if test="${!empty memberDto }">
	      			<li class="nav-item"><a href="${root}/favorite/${memberDto.memberId }/houses" class="nav-link px-2 text-muted">즐겨찾기 지역 정보</a></li>
	      		</c:if>
	      		<li class="nav-item"><a href="${root}/shop" class="nav-link px-2 text-muted">상권 검색</a></li>
	      		<li class="nav-item"><a href="${root}/aboutUs" class="nav-link px-2 text-muted">About Us</a></li>
	      		<li class="nav-item"><a href="${root}/siteMap" class="nav-link px-2 text-muted">Site Map</a></li>
	    	</ul>
	  	</footer>
</body>
</html>