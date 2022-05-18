function findpwd() {
	let id = $("#floatingInput").val();
	let name = $("#floatingName").val();
	
	if(id && name) {
		$("#searchPwdForm").attr("action", "/user/searchpwd").submit();
	} else {
		alert("정보를 기입해주시기 바랍니다.");
	}
}

function login() {
	console.log("login");
	let id = $("#floatingInput").val();
	let pwd = $("#floatingPassword").val();
	
	if(id && pwd) {
		 $("#loginForm").attr("action", "/user/login").submit();
	} else {
		alert("id나 password를 입력해주세요.");
	}
}

function register() {
	// 문서에서 id 로 input data 가져오기
	let id = $("#memberId").val();
	let password = $("#memberPw").val();
	let name = $("#memberName").val();
	let phoneNumber = $("#memberTel").val();
	let email = $("#memberEmail").val();
	
	if (!id || !password || !name || !phoneNumber || !email) {
	    alert("필수 항목을 모두 기입해주세요.");
	    return;
    } else {
    	$("#signupForm").attr("action", "/user/signup").submit();
    }
}

function updateInfo() {
	let id = $("#memberId").val();
	let password = $("#memberPw").val();
	let name = $("#memberName").val();
	let phoneNumber = $("#memberTel").val();
	let email = $("#memberEmail").val();
	
	if (!id || !password || !name || !phoneNumber || !email) {
	    alert("필수 항목을 모두 기입해주세요.");
	    return;
    } else {
    	$("#updateForm").attr("action", "/user/userinfo").submit();
    }
    		
}

function deleteInfo() {
	if(confirm("정말 탈퇴하시겠습니까?") == true) {
		let id = $("#memberId").val();
		location.href="/user/" + id + "/delete";
	}
}