package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.search.StoreSearch;
import com.ssafy.happyhouse.model.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	StoreService store;
	
	@GetMapping("/shop")
	public String getShopList(String address) {
		
		if(address != null && address.trim().length() > 0) {
			
		}
		
		return "/shop/shopInfo";
	}
	
	@GetMapping("/shop/around")
	public ModelAndView viewAroundShopSearch(String aptName, String lat, String lng) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/shop/aroundShop");
		
		return mv;
	}
	
	@PostMapping("/shop/around")
	public ModelAndView getShopList(StoreSearch search) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/shop/aroundShop");
		
		if(search.getCategories() == null || search.getCategories().size() == 0)
			search.setCategories();
			
		search.setDistance(search.getDistance() / 1000);
		
		mv.addObject("shoplist", store.getAroundShop(search));
		
		return mv;
	}
	
}
