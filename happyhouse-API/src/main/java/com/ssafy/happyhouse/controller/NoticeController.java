package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;


@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping
	public ResponseEntity<?> viewNoticeList() throws Exception{	
		return new ResponseEntity<List<NoticeDto>>(noticeService.viewNoticeList(), HttpStatus.OK);	
	}
	
	@GetMapping("/{nno}")
	public ResponseEntity<?> viewNotice(@PathVariable String nno) throws Exception{
		
		return new ResponseEntity<NoticeDto>(noticeService.viewNotice(nno), HttpStatus.OK);	
	}
	
	@PostMapping("/regist")
	public ResponseEntity<String> registerNotice(@RequestBody NoticeDto article) throws Exception {

		noticeService.registerNotice(article);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateNotice(@RequestBody NoticeDto noticeDto) throws Exception {	
		
		noticeService.updateNotice(noticeDto);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{nno}")
	public ResponseEntity<String> deleteNotice(@PathVariable String nno) throws Exception {
		noticeService.deleteNotice(Integer.parseInt(nno));
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
}
