package com.ssafy.happyhouse.controller;

import java.util.List;

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
import com.ssafy.happyhouse.model.service.UserService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	public ResponseEntity<?> viewQuestionSearchList(@ModelAttribute QuestionSearch search) throws Exception {	
		
		logger.debug(search.toString());
		search.setIsManager(search.getUserid().length() == 0 ? false : "Y".equals(userService.showInfo(search.getUserid()).getIsManager()));
		
		List<QuestionDto> questionList = questionService.viewQuestionList(search);
		
		if(questionList.size() == 0) {
			return new ResponseEntity<String>("no_result", HttpStatus.OK);
		}
		
		return new ResponseEntity<List<QuestionDto>>(questionList, HttpStatus.OK);
	}
	
	// 열람
	@GetMapping("/{qno}")
	public ResponseEntity<?> viewQuestion(@PathVariable String qno, String userid) throws Exception{
		String isManager = userid.length() == 0 ? "N" : userService.showInfo(userid).getIsManager();
		
		QNAInfo qna = new QNAInfo(questionService.viewQuestion(qno, userid, isManager));
		
		logger.debug(qna.toString());
		
		if(qna.isEmpty()) {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		return new ResponseEntity<QNAInfo>(qna, HttpStatus.OK);
		
	}
	
	@PostMapping("/regist")
	public ResponseEntity<String> registerQuestion(@RequestBody QuestionDto article) throws Exception {
		logger.debug(article.toString());
		questionService.registerQuestion(article);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateQuestion(@RequestBody QuestionDto questionDto) throws Exception {	
		questionService.updateQuestion(questionDto);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{qno}")
	public ResponseEntity<String> deleteQuestion(@PathVariable String qno) throws Exception {
		questionService.deleteQuestion(Integer.parseInt(qno));
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
}
