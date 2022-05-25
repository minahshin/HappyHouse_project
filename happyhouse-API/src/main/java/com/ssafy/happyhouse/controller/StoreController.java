package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ssafy.happyhouse.model.StoreDtoDistance;
import com.ssafy.happyhouse.model.search.StoreAddrSearch;
import com.ssafy.happyhouse.model.search.StoreSearch;
import com.ssafy.happyhouse.model.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	StoreService store;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/shop/around")
	public ResponseEntity<?> getShopList(@ModelAttribute StoreSearch search) throws Exception {
		
		if(search.getCategories() == null || search.getCategories().size() == 0)
			search.setCategories();
			
		search.setDistance(search.getDistance() / 1000);
		
		return new ResponseEntity<List<StoreDtoDistance>>(store.getAroundShop(search), HttpStatus.OK);
	}
	
	@GetMapping("/shop/address")
	public ResponseEntity<?> getShopByAddr(@ModelAttribute StoreAddrSearch search) throws Exception{
		
		logger.debug(search.toString());
		
		if(search.getCategories() == null || search.getCategories().size() == 0)
			search.setCategories();
		
		return new ResponseEntity<List<StoreDtoDistance>>(store.getShopByAddress(search), HttpStatus.OK);
	}
	
}
