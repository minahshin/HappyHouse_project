package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
	//@Autowired
	
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
	public String login() {
		return "redirect:/main";
	}
	
	@PostMapping("/signup")
	public String signup() {
		return "/user/signup";
	}
	
	@PostMapping("/searchpwd")
	public String searchPwd() {
		return "/user/searchpwd";
	}
	
	@PutMapping("/userinfo")
	public String updateUser() {
		return null;
	}
	
	@DeleteMapping("/{userid}/userinfo")
	public String deleteUser(@PathVariable String userid) {
		return null;
	}
	
}
