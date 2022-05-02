package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String login() {
		
		return null;
	}
	
	@PostMapping("/signup")
	public String signup() {
		return null;
	}
	
	@GetMapping("/searchpwd")
	public String serchpwd() {
		return null;
	}
	
	@GetMapping("/userinfo")
	public String showinfo() {
		return null;
	}
	
	@PutMapping("/userinfo")
	public String updateUser() {
		return null;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@DeleteMapping("/userinfo")
	public String deleteUser() {
		
		return null;
	}
	
}
