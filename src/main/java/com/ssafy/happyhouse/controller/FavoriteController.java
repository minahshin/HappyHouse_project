package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
	
	@GetMapping("/{userid}")
	public String showFavoriteList(@PathVariable String userid) {
		return "/user/favorite";
	}
	
	@DeleteMapping("/{userid}")
	public String deleteFavorite(@PathVariable String userid, String dongCode) {
		return "redirect:/user/favorite";
	}
	
	@GetMapping("/{userid}/houses")
	public String showFavoriteHouses() {
		return "/search/searchByFavorites";
	}
}
