package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.QuestionDto;
import com.ssafy.happyhouse.model.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	// 뷰를 보여주기 : 글 작성, 열람(+답변), 수정, 리스트(+검색)
	
	// 실제 로직 수행 : 작성, 열람, 수정, 삭제
	//작성
	@PostMapping("/regist")
	public ModelAndView registerQuestion(QuestionDto questionDto) throws Exception {
		
		questionService.registerQuestion(questionDto);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:/main");
		
		return mv;
	}
	
	//수정
	@PutMapping
	public String updateQuestion(QuestionDto questionDto) throws Exception {
			
		questionService.updateQuestion(questionDto);
		
		return "redirect:/main" ;
	}
	
	//삭제 qno어케 받아오지..?
	@GetMapping("/{userid}/delete")
	public String deleteQuestion(@PathVariable String userid, String qno, HttpSession session) throws Exception {
		
		questionService.deleteQuestion(userid, qno);
		
		return "redirect:/main";
	}
	
	
}
