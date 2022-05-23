package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.AnswerService;


@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	@PostMapping("/regist")
	public ResponseEntity<String> registerQuestion(AnswerDto answerDto, HttpSession session) throws Exception {
		
		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
		
		if(loginUser == null || loginUser.getIsManager().equals("N")) {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		answerService.registerAnswer(answerDto);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateAnswer(AnswerDto answerDto, HttpSession session) throws Exception{
		
		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
		
		if(loginUser == null || loginUser.getIsManager().equals("N")) {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		answerService.updateAnswer(answerDto);
		return new ResponseEntity<String>("success", HttpStatus.OK);
		
	}
	
	@GetMapping("/delete/{ano}")
	public ResponseEntity<String> deleteAnswer(@PathVariable String ano, HttpSession session) throws Exception{
		
		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
		
		if(loginUser == null || loginUser.getIsManager().equals("N")) {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
		answerService.deleteAnswer(Integer.parseInt(ano));
		return new ResponseEntity<String>("success", HttpStatus.OK);
	
	}
	
	
}
