<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/View/template/login_header.jsp" %>

<c:if test="${msg ne null}">
	<script>
		alert("${msg}");
	</script>
</c:if>

	<title>Login Happy House</title>
   
	<div class="form-signin text-center">
		<form id="loginForm" method="post" action="">
				<a href="${root}/main">
					<img class="mb-4" src="${root}/source/img/header-house.png" alt="" width="50" height="50" title="홈으로 가기"></a>
    	<h1 class="h3 mb-3 fw-normal">로그인 해주세요</h1>
		
		<input type="hidden" id="action" name="action" value="login">
    	<div class="form-floating">
      		<input type="email" name="id" class="form-control" id="floatingInput" placeholder="name@example.com" value="" required>
      		<label for="floatingInput">이메일</label>
    	</div>
    	<div class="form-floating">
      		<input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password" value="" required>
      		<label for="floatingPassword">비밀번호</label>
    	</div>
    	<br>
    	<button class="w-100 btn btn-lg btn-primary" type="button" onclick="login()">Sign in</button>
    	<button class="w-100 btn btn-lg btn-primary" type="button" onclick="location.href='${root}/user?view=signup'" style="margin-top:10px;">Sign up</button>
    	<button class="w-100 btn btn-lg btn-primary" type="button" onclick="location.href='${root}/user?view=searchpwd'" style="margin-top:10px;">비밀번호 찾기</button>
    	<p class="mt-5 mb-3 text-muted">© 2022 Happy House</p>
 		</form>
	</div>

