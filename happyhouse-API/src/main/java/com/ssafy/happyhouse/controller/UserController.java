package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.UserService;
import com.ssafy.happyhouse.model.service.UserSha256;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	//모르겠음
	@GetMapping("/{userid}/userinfo")
	public ResponseEntity<?> showinfo(@PathVariable String userid, HttpSession session) throws Exception{
		
		return new ResponseEntity<MemberDto>(userService.showInfo(userid), HttpStatus.OK);	
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam Map<String, String> map, Model model,HttpSession session) throws Exception{
		String encryPassword = UserSha256.encrypt(map.get("memberPw"));
		map.put("memberPw", encryPassword);
	
		MemberDto memberDto = userService.login(map);
		if(memberDto != null) {
			session.setAttribute("memberDto", memberDto);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}else {
			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			return new ResponseEntity<String>("접근 권한이 없습니다.", HttpStatus.BAD_REQUEST);
		}
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
