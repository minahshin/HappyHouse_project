package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.handler.MainPageHandler;

@Controller
public class MainController {
	
	@Autowired
	MainPageHandler main;
	
	@GetMapping(value = {"/", "/index", "/main"})
	public ModelAndView showMain() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		mv.addObject("donglist", main.pageInit());

		return mv;
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
