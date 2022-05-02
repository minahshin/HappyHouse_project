package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value = {"/", "/index", "/main"})
	public String showMain() {
		// TODO : 구, 동을 동적으로 가져오는 코드 및 request에 설정
		return "index";
	}
	
	@GetMapping("/aboutUs")
	public String showAboutUs() {
		return "/company/aboutus";
	}
	
	@GetMapping("siteMap")
	public String showSiteMap() {
		return "/company/sitemap";
	}
}
