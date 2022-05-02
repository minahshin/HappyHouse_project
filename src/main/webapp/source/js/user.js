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
	let id = $("#email").val();
	let password = $("#password").val();
	let name = $("#name").val();
	let nickname = $("#nickname").val();
	let address = $("#address").val();
	
	if (!id || !password || !name || !nickname || !address) {
	    alert("필수 항목을 모두 기입해주세요.");
	    return;
    } else {
    	$("#signupForm").attr("action", "/user/signup").submit();
    }
}

function updateInfo() {
	let id = $("#id").val();
	let password = $("#password").val();
	let name = $("#name").val();
	let nickname = $("#nickname").val();
	let address = $("#address").val();

	if (!id || !password || !name || !nickname || !address) {
	    alert("필수 항목을 모두 기입해주세요.");
	    return;
    } else {
    	$("#updateForm").attr("action", "/user/userinfo").submit();
    }
    		
}

function deleteInfo() {
	if(confirm("정말 탈퇴하시겠습니까?") == true) {
		let id = $("#id").val();
		$("#action").val("deleteUser");
		$("#updateForm").attr("action", "/user/" + id + "/userinfo").submit();
	}
}