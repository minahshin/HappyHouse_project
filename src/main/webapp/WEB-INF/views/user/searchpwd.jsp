<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/login_header.jsp" %>

<c:if test="${msg ne null}">
	<script>
		alert("${msg}");
	</script>
</c:if>

<title>Login Happy House</title>
  
<body class="text-center">  
	<div class="form-signin">
 			<form id="searchPwdForm" method="post" action="">
 				<a href="${root}/main">
 					<img class="mb-4" src="${root}/source/img/header-house.png" alt="" width="50" height="50" title="홈으로 가기"></a>
	    	<h1 class="h3 mb-3 fw-normal">비밀번호 찾기</h1>
	
	    	<div class="form-floating">
	      		<input type="text" class="form-control" id="floatingInput" name="memberId" placeholder="name@example.com" value="" required>
	      		<label for="floatingInput">아이디</label>
	    	</div>
	    	<div class="form-floating">
	      		<input type="email" class="form-control" id="floatingName" name="memberEmail" placeholder="이름" value="" required>
	      		<label for="floatingName">이메일</label>
	    	</div>
	    	
	    	<button class="w-100 btn btn-lg btn-primary" type="button" onclick="findpwd()" >찾기</button>
	    	<button class="w-100 btn btn-lg btn-primary" type="button" onclick="location.href='${root}/user/login'" style="margin-top:10px;">Login</button>
	    	<button class="w-100 btn btn-lg btn-primary" type="button" onclick="location.href='${root}/user/signup'" style="margin-top:10px;">Sign up</button>
	    	<p class="mt-5 mb-3 text-muted">© 2022 Happy House</p>
  		</form>
	</div>
</body>

