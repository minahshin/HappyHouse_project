<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ssafy.happyhouse.model.MemberDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${msg ne null}">
	<script>
		alert("${msg}");
	</script>
</c:if>

<meta charset="UTF-8">
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

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="${root }/source/js/user.js"></script>

<header class="p-3 bg-dark text-white" style="position:sticky;top:0;position:-webkit-sticky;z-index:9999;">
	<div class="container" >
		<div
			class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="${root }/main"
				class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
				<img src="${root }/source/img/header-house.png">
			</a>

			<ul
				class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
				<li><a href="${root}/main" class="nav-link px-2 text-white">Home</a></li>
				<li><a href="${root}/house/search" id="searchLink" class="nav-link px-2 text-white">시세 검색</a></li>
				<c:if test="${!empty memberDto }">
					<li><a href="${root}/favorite/${memberDto.memberId }/houses" class="nav-link px-2 text-white">즐겨찾기 지역 정보</a></li>
				</c:if>
				<li><a href="${root}/shop" class="nav-link px-2 text-white">상권 검색</a></li>
				<li><a href="${root}/aboutUs" class="nav-link px-2 text-white">About Us</a></li>
				<li><a href="${root}/siteMap" class="nav-link px-2 text-white">Site Map</a></li>
			</ul>

			<c:if test="${!empty memberDto }">
				<div class="text-end" id="userbar">
					반갑습니다! ${memberDto.memberName}님!!&nbsp;&nbsp;
					<button type="button" class="btn btn-outline-light me-2" onclick="location.href = '${root}/user/logout'">Logout</button>
					<button type="button" class="btn btn-warning" onclick="location.href = '${root}/user/${memberDto.memberId}/userinfo'">회원 정보</button>
					<button type="button" style="background-color:pink;" class="btn" 
						onclick="location.href = '${root}/favorite?action=showFavorite'">즐찾 관리</button>
				</div>
			</c:if>
			<c:if test="${empty memberDto }">
				<div class="text-end" id="userbar">
					<button type="button" class="btn btn-outline-light me-2" onclick="location.href = '${root}/user/login'">Login</button>
					<button type="button" class="btn btn-warning" onclick="location.href = '${root}/user/signup'">Sign up</button>
				</div>
			</c:if>

		</div>
	</div>
</header>