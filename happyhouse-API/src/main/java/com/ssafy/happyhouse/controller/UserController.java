package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.JwtServiceImpl;
import com.ssafy.happyhouse.model.service.UserService;
import com.ssafy.happyhouse.model.service.UserSha256;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> showinfo(@PathVariable String userid, HttpSession session) throws Exception{
		
		return new ResponseEntity<MemberDto>(userService.showInfo(userid), HttpStatus.OK);	
	}
	

	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo( @PathVariable("userid") String userid,HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				MemberDto memberDto = userService.showInfo(userid);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}	
	
//	@PostMapping("/login")
//	public ResponseEntity<String> login(@RequestParam Map<String, String> map, Model model,HttpSession session) throws Exception{
//		String encryPassword = UserSha256.encrypt(map.get("memberPw"));
//		map.put("memberPw", encryPassword);
//	
//		MemberDto memberDto = userService.login(map);
//		if(memberDto != null) {
//			session.setAttribute("memberDto", memberDto);
//			return new ResponseEntity<String>("success", HttpStatus.OK);
//		}else {
//			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
//			return new ResponseEntity<String>("접근 권한이 없습니다.", HttpStatus.BAD_REQUEST);
//		}
//	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			String encryPassword = UserSha256.encrypt(memberDto.getMemberPw());
			memberDto.setMemberPw(encryPassword);
			MemberDto loginUser = userService.login(memberDto);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getMemberId(), "access-token");// key, data, subject
				logger.debug("로그인 토큰정보 : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody MemberDto memberDto) throws Exception {
		
		String encryPassword = UserSha256.encrypt(memberDto.getMemberPw());
		memberDto.setMemberPw(encryPassword);
		int idcheck = userService.idCheck(memberDto.getMemberId());
		if(idcheck ==0) {
			userService.registerMember(memberDto);
			return new ResponseEntity<String>("success", HttpStatus.OK);		
		}else {		
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}
//	@PostMapping("/idcheck")
//	public ResponseEntity<String> idCheck(@RequestBody String memberId) throws Exception {
//		int idcheck = userService.idCheck(memberId);
//		if(idcheck ==0) {
//			return new ResponseEntity<String>("success", HttpStatus.OK);
//		}else {
//			return new ResponseEntity<String>("중복된 아이디입니다.", HttpStatus.BAD_REQUEST);
//		}
//	}
//	
	@PostMapping("/searchpwd")
	public ResponseEntity<?> searchPwd(@RequestBody MemberDto memberDto) throws Exception {
	
		MemberDto ismemberDto = userService.searchPw(memberDto);
		System.out.println(memberDto.toString());
		System.out.println(ismemberDto);
		if(ismemberDto != null) {
			return new ResponseEntity<MemberDto>(ismemberDto, HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody MemberDto memberDto) throws Exception {
		
		String encryPassword = UserSha256.encrypt(memberDto.getMemberPw());
		memberDto.setMemberPw(encryPassword);
		userService.updateMember(memberDto);
		
		return  new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable String userid, HttpSession session) throws Exception {
		userService.deleteMember(userid);
		session.invalidate();
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
//	카카오 로그인
	KakaoAPI kakaoApi = new KakaoAPI();
	
	@RequestMapping(value="/login")
	public ResponseEntity<?> login(@RequestParam("code") String code, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// 1번 인증코드 요청 전달
		String accessToken = kakaoApi.getAccessToken(code);
		// 2번 인증코드로 토큰 전달
		HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);
		
		System.out.println("login info : " + userInfo.toString());
		
		if(userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("accessToken", accessToken);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		//mav.addObject("userId", userInfo.get("email"));
		
		return new ResponseEntity<String>("실패", HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		kakaoApi.kakaoLogout((String)session.getAttribute("accessToken"));
		session.removeAttribute("accessToken");
		session.removeAttribute("userId");
		mav.setViewName("index");
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
}
