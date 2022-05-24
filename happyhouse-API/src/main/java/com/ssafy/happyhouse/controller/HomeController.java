package com.ssafy.happyhouse.controller;


import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class HomeController {

	KakaoAPI kakaoApi = new KakaoAPI();
	
	@RequestMapping(value="/login")
	public ResponseEntity<?> login(@RequestParam("code") String code, HttpSession session) {
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
		
		return new ResponseEntity<String>("fail", HttpStatus.OK);
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
