package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String viewLogin() {
		return "/user/login";
	}
	
	@GetMapping("/signup")
	public String viewSignUp() {
		return "/user/signup";
	}
	
	@GetMapping("/searchpwd")
	public String viewSearchpwd() {
		return "/user/searchpwd";
	}
	
	@GetMapping("/{userid}/userinfo")
	public String showinfo(@PathVariable String userid) {
		return "/user/userinfo";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model,HttpSession session) throws Exception{
		MemberDto memberDto = userService.login(map);
		if(memberDto != null) {
			session.setAttribute("userinfo", memberDto);
			return "redirect:/main";
		}else {
			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			return "user/login";
		}
	}
	
	@PostMapping("/signup")
	public String signup(MemberDto memberDto,Model model) throws Exception {
		userService.registerMember(memberDto);
		return "redirect:/user/signup";
	}
	
	@PostMapping("/searchpwd")
	public String searchPwd(@RequestParam Map<String, String> map,Model model) throws Exception {
		String pw = userService.searchPw(map);
		model.addAttribute("msg", "비밀번호는 "+pw+" 입니다.");
		return "/user/searchpwd";
	}
	
	
	@PutMapping("/userinfo")
	public String updateUser(@RequestBody MemberDto memberDto) throws Exception {
		String id = memberDto.getMemberId();
		userService.updateMember(memberDto);
		return "redirect:/user/userinfo";//이게 맞나..?
	}
	
	@DeleteMapping("/{userid}/userinfo")
	public String deleteUser(@PathVariable String userid) throws Exception {
		userService.deleteMember(userid);
		return null;//모르겠습니다 ㅠㅠ
	}
	
}
