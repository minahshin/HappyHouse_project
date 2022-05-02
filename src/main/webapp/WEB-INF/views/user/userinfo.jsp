<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.happyhouse.account.AccountDTO"%>
<%@ include file="/View/template/signup_header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Info : Happy House</title>

</head>
<body>
	<div class="container">
		<div class="input-form-backgroud row">
		
			<div class="input-form col-md-12 mx-auto">
			<a href="${root }/main"><img src="${root }/source/img/header-house.png" title="홈으로 가기"></a>
				<h4 class="mb-3">회원정보 수정</h4>
				<form class="validation-form" method="post" id="updateForm" action="" novalidate>
					<input type="hidden" id="action" name="action" value="userinfo">
					<div class="row">
						<div class="mb-3">
							<label for="email">이메일(ID)</label>
							<input type="email" class="form-control" name="id" id="id" value="${user.email }" readonly>
						</div>
						<div class="mb-3">
							<label for="password">비밀번호</label>
							<input type="text" class="form-control" name="password" id="password" value="${user.password }" required>
							<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="name">이름</label>
							<input type="text" class="form-control" name="name" id="name" value="${user.name }" required>
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="nickname">별명</label>
							<input type="text" class="form-control" name="nickname" id="nickname" value="${user.nickname}" required>
							<div class="invalid-feedback">별명을 입력해주세요.</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="address">주소</label>
						<input type="text" class="form-control" name="address" id="address" value="${user.address }" required>
						<div class="invalid-feedback">주소를 입력해주세요.</div>
					</div>
					<div class="mb-4"></div>
					<button class="btn btn-primary btn-lg" type="button" onclick="deleteInfo()">회원 탈퇴</button>
					<button class="btn btn-primary btn-lg" type="submit" onclick="updateInfo()" style="float:right;">정보 수정</button>
				</form>
			</div>
		</div>
		<footer class="my-3 text-center text-small">
			<p class="mb-1">&copy; 2022 <a href="${root }/main">Happy House</a></p>
		</footer>
	</div>
	<script> window.addEventListener('load', () => { const forms = document.getElementsByClassName('validation-form'); Array.prototype.filter.call(forms, (form) => { form.addEventListener('submit', function (event) { if (form.checkValidity() === false) { event.preventDefault(); event.stopPropagation(); } form.classList.add('was-validated'); }, false); }); }, false); </script>
</body>
</html>

