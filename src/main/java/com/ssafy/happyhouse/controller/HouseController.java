package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.service.HousedealService;

@Controller
@RequestMapping("/house")
public class HouseController {
	
	@Autowired
	HousedealService house;
	
	@GetMapping("/search/address/{address}")
	public ModelAndView searchByDong(@PathVariable String address) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/search");
		
		mv.addObject("houselist", house.searchByDong(address.split(" ")[1]));
		
		return mv;
	}
	
	@GetMapping("/search")
	public ModelAndView searchByAptName(String aptName) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/search/searchByAptName");
		
		if(aptName != null && aptName.trim().length() > 0) {
			mv.addObject("aptName", aptName);
			mv.addObject("houselist", house.searchByAptName(aptName));
		}
		
		return mv;
	}
	
}
