package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {
	
	@GetMapping("/shop")
	public String getShopList(String address) {
		
		if(address != null && address.trim().length() > 0) {
			
		}
		
		return "/shop/shopInfo";
	}
	
}
