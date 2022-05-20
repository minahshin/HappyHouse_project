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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.JwtServiceImpl;
import com.ssafy.happyhouse.model.service.UserService;
import com.ssafy.happyhouse.model.service.UserSha256;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api("UserController V1")
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
	
//	@GetMapping("/{userid}/userinfo")
//	public ResponseEntity<?> showinfo(@PathVariable String userid, HttpSession session) throws Exception{
//		
//		return new ResponseEntity<MemberDto>(userService.showInfo(userid), HttpStatus.OK);	
//	}

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
		userService.registerMember(memberDto);
		//아이디 중복 체크가 있어야 할 것 같음
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PostMapping("/searchpwd")
	public ResponseEntity<?> searchPwd(@RequestParam Map<String, String> map,@RequestBody Model model,HttpSession session) throws Exception {
	
		MemberDto memberDto = userService.searchPw(map);
		System.out.println(map.toString());
		System.out.println(memberDto);
		if(memberDto == null) {
			model.addAttribute("msg", "일치하는 사용자가 없습니다!");
			return new ResponseEntity<String>("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
		}
		
		session.setAttribute("memberDto", memberDto);
		
		return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
	}
	
	
	@PutMapping("/userinfo")
	public ResponseEntity<String> updateUser(@RequestBody MemberDto memberDto) throws Exception {
		
		String encryPassword = UserSha256.encrypt(memberDto.getMemberPw());
		memberDto.setMemberPw(encryPassword);
		userService.updateMember(memberDto);
		
		return  new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping("/{userid}/delete")
	public ResponseEntity<String> deleteUser(@PathVariable String userid, HttpSession session) throws Exception {
		userService.deleteMember(userid);
		session.invalidate();
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
}
