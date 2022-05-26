package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ssafy.happyhouse.handler.NewsHandler;
import com.ssafy.happyhouse.model.news.Items;

@RestController

public class HomeController {

	KakaoAPI kakaoApi = new KakaoAPI();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestParam("code") String code, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		// 1번 인증코드 요청 전달
		String accessToken = kakaoApi.getAccessToken(code);
		// 2번 인증코드로 토큰 전달
		HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);
		
		System.out.println("login info : " + userInfo.toString());
		
		if(userInfo.get("email") != null) {
//			resultMap.put("userId", userInfo.get("email"));
			resultMap.put("accessToken", accessToken);
			resultMap.put("message", "success");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		//mav.addObject("userId", userInfo.get("email"));
		
		return new ResponseEntity<String>("실패", HttpStatus.OK);
	}
	
	@RequestMapping(value="/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		kakaoApi.kakaoLogout((String)session.getAttribute("accessToken"));
		session.removeAttribute("accessToken");
		session.removeAttribute("userId");
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping("/news")
	public ResponseEntity<?> getNews(String keywords) throws JsonMappingException, JsonProcessingException {
		logger.debug("[keyword] " + keywords);
		
		List<Items> result = new NewsHandler().getNewsItems(keywords.replace("undefined", "") + "부동산");
		
		logger.debug(result.toString());
		
		return new ResponseEntity<List<Items>>(result, HttpStatus.OK);
	}
	
}
