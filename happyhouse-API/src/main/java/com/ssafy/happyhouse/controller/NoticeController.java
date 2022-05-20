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
	public ResponseEntity<?> viewNotice(@PathVariable String nno, HttpSession session) throws Exception{
		
		return new ResponseEntity<NoticeDto>(noticeService.viewNotice(nno), HttpStatus.OK);	
	}
	
	@PostMapping("/regist")
	public ResponseEntity<String> registerNotice(@RequestBody NoticeDto article, HttpSession session) throws Exception {
		
//		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
//		
//		if(loginUser == null || loginUser.getIsManager().equals("N")) {
//			return new ResponseEntity<String>("접근 권한이 없습니다.", HttpStatus.BAD_REQUEST);
//		}

		noticeService.registerNotice(article);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateNotice(@RequestBody NoticeDto noticeDto, HttpSession session) throws Exception {	
		
//		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
//		
//		if(loginUser == null || loginUser.getIsManager().equals("N")) {
//			return new ResponseEntity<String>("접근 권한이 없습니다.", HttpStatus.BAD_REQUEST);
//		}
		
		noticeService.updateNotice(noticeDto);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{nno}")
	public ResponseEntity<String> deleteNotice(@PathVariable String nno, HttpSession session) throws Exception {
		
//		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
//		
//		if(loginUser == null || loginUser.getIsManager().equals("N")) {
//			return new ResponseEntity<String>("접근 권한이 없습니다.", HttpStatus.BAD_REQUEST);
//		}
		
		noticeService.deleteNotice(Integer.parseInt(nno));
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
}
