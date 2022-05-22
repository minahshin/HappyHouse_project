package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.QNAInfo;
import com.ssafy.happyhouse.model.QuestionDto;
import com.ssafy.happyhouse.model.search.QuestionSearch;
import com.ssafy.happyhouse.model.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	public ResponseEntity<?> viewQuestionSearchList(@ModelAttribute QuestionSearch search) throws Exception {
		
		logger.debug(search.toString());
		
		List<QuestionDto> questionList = questionService.viewQuestionList(search);
		
		if(questionList.size() == 0) {
			return new ResponseEntity<String>("no_result", HttpStatus.OK);
		}
		
		return new ResponseEntity<List<QuestionDto>>(questionList, HttpStatus.OK);
	}
	
	// 열람
	@GetMapping("/{qno}")
	public ResponseEntity<?> viewQuestion(@PathVariable String qno, HttpSession session) throws Exception{
		
//		if(session.getAttribute("memberDto") == null) {
//			return new ResponseEntity<String>("로그인 후 이용해주세요", HttpStatus.BAD_REQUEST);
//		}		
		
//		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
		QNAInfo qna = new QNAInfo(questionService.viewQuestion(qno, /*loginUser.getMemberId()*/ null));
		
		if(qna.isEmpty()) {
			return new ResponseEntity<String>("접근 권한이 없습니다.", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<QNAInfo>(qna, HttpStatus.OK);
		
	}
	
	@PostMapping("/regist")
	public ResponseEntity<String> registerQuestion(@RequestBody QuestionDto article, HttpSession session) throws Exception {
		
//		if(session.getAttribute("memberDto") == null) {
//			return new ResponseEntity<String>("로그인 후 이용해주세요", HttpStatus.BAD_REQUEST);
//		}
		logger.debug(article.toString());
		questionService.registerQuestion(article);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateQuestion(@RequestBody QuestionDto questionDto, HttpSession session) throws Exception {	
		
//		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
//		
//		if(loginUser == null || !loginUser.getMemberId().equals(questionDto.getWriter())) {
//			return new ResponseEntity<String>("접근 권한이 없습니다.", HttpStatus.BAD_REQUEST);
//		}
		
		questionService.updateQuestion(questionDto);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{qno}")
	public ResponseEntity<String> deleteQuestion(@PathVariable String qno, HttpSession session) throws Exception {
		
//		MemberDto loginUser = (MemberDto) session.getAttribute("memberDto");
//		
//		String writer = questionService.getWriter(qno);
//		
//		if(loginUser == null || !loginUser.getMemberId().equals(writer)) {
//			return new ResponseEntity<String>("접근 권한이 없습니다.", HttpStatus.BAD_REQUEST);
//		}
		
		questionService.deleteQuestion(Integer.parseInt(qno));
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
}
