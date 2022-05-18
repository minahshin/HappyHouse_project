<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/signup_header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Sign Up Happy House</title>
</head>
<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				<form class="validation-form" method="post" id="signupForm" action="" novalidate>
				
					<div class="row">
						<div class="mb-3">
							<label for="id">ID</label>
							<input type="text" class="form-control" name="memberId" id="memberId" placeholder="" required>
							<div class="invalid-feedback">아이디를 입력해주세요.</div>
						</div>
						<div class="mb-3">
							<label for="password">비밀번호</label>
							<input type="password" class="form-control" name="memberPw" id="memberPw" placeholder="" required>
							<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="name">이름</label>
							<input type="text" class="form-control" name="memberName" id="memberName" placeholder="" value="" required>
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="phoneNumber">전화 번호</label>
							<input type="text" class="form-control" name="memberTel" id="memberTel" placeholder="010-0000-0000" value="" required>
							<div class="invalid-feedback">전화번호를 입력해주세요.</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="email">이메일</label>
						<input type="email" class="form-control" name="memberEmail" id="memberEmail" placeholder="ssafy@happyhouse.com" required>
						<div class="invalid-feedback">이메일을 입력해주세요.</div>
					</div>
					<div class="mb-4"></div>
					<button class="btn btn-primary btn-lg btn-block" type="button" onclick="location.href='${root}/user/login'">로그인</button>
					<button class="btn btn-primary btn-lg btn-block" type="button" onclick="register()" style="float:right;">가입 완료</button>
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

