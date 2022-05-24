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
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.AptDto;
import com.ssafy.happyhouse.model.DongcodeDto;
import com.ssafy.happyhouse.model.search.AptSearch;
import com.ssafy.happyhouse.model.service.DongService;
import com.ssafy.happyhouse.model.service.HousedealService;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Autowired
	HousedealService house;
	
	@Autowired
	DongService dong;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/map/gu")
	public ResponseEntity<?> getSeoulGu() throws Exception{
		return new ResponseEntity<List<DongcodeDto>>(dong.getGuInfo(), HttpStatus.OK);
	}
	
	@GetMapping("/map/dong")
	public ResponseEntity<?> getSeoulDong(String gu) throws Exception{
		return new ResponseEntity<List<DongcodeDto>>(dong.getDongInfo(gu.substring(0, 5)), HttpStatus.OK);
	}
	
	
	@GetMapping("/search")
	public ResponseEntity<?> searchApt(@ModelAttribute AptSearch search) throws Exception {
		logger.debug(search.toString());
		return new ResponseEntity<List<AptDto>>(house.getConditionedApt(search), HttpStatus.OK);
	}
	
}
