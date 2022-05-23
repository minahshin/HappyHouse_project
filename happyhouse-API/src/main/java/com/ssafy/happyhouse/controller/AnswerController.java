package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ssafy.happyhouse.model.AnswerDto;
import com.ssafy.happyhouse.model.service.AnswerService;


@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/{qno}")
	public List<AnswerDto> getQuestionAnswers(@PathVariable String qno) {
		logger.debug(qno);
		
		return answerService.viewAllAnswers(qno);
	}
	
	@PostMapping("/regist")
	public ResponseEntity<String> registerQuestion(@RequestBody AnswerDto answerDto) throws Exception {
		logger.debug(answerDto.toString());
		answerService.registerAnswer(answerDto);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateAnswer(@RequestBody AnswerDto answerDto) throws Exception{
		answerService.updateAnswer(answerDto);
		return new ResponseEntity<String>("success", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{ano}")
	public ResponseEntity<String> deleteAnswer(@PathVariable String ano) throws Exception{
		answerService.deleteAnswer(Integer.parseInt(ano));
		return new ResponseEntity<String>("success", HttpStatus.OK);
	
	}
	
	
}
