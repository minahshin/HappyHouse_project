package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.QNAInfo;
import com.ssafy.happyhouse.model.QuestionDto;
import com.ssafy.happyhouse.model.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	// TODO : Vue 적용 시 RestController로 데이터만 전달
	// 따라서 Return type을 바꿔줄 필요가 있음!
	
	@Autowired
	private QuestionService questionService;
	// 뷰를 보여주기 : 글 작성, 열람(+답변), 수정, 리스트(+검색)
	
//	public String viewUpdate() {
//		
//		// 1. session에서 사용자 아이디 가져오기 + session에 로그인 된 아이디가 있는지 확인
//		// 2. session에서 가져온 사용자 아이디와 questionDto의 아이디가 일치하는지 체크
//		// 3. 일치하지 않으면 게시글 하면으로 뒤로가기(return 문 이용)
//		
//		// 일치하면 수정 화면으로 이동하기
//	}
	
	// 열람
	@GetMapping("/{qno}")
	public QNAInfo viewQuestion(@PathVariable String qno, HttpSession session) throws Exception{
		
		// 1. session에 사용자가 있는지 확인
		// 2. 열람 권한 확인하기
		// 3. select 문으로 넘어온 questiondto가 null일 경우 열람권한이 없다 한 뒤에 qna 홈페이지로 redirect
				
		// 4. 답변이 달렸다면 answerService.viewAnswer(qno)에 있는 object list를 가져오기		
		
		return new QNAInfo(questionService.viewQuestion(Integer.parseInt(qno)));
		
	}
	
	// 실제 로직 수행 : 작성, 열람, 수정, 삭제
	//작성
	@PostMapping("/regist")
	public ModelAndView registerQuestion(QuestionDto questionDto) throws Exception {
		
		questionService.registerQuestion(questionDto);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:/main"); // 메인 대신 작성한 글 보여주기(/question/1231456)
		
		return mv;
	}
	
	//수정
	@PutMapping
	public String updateQuestion(QuestionDto questionDto, HttpSession session) throws Exception {		
		questionService.updateQuestion(questionDto);
		
		return "redirect:/main" ; // 메인 대신 작성한 글 보여주기(/question/1231456)
	}
	
	//삭제 qno어케 받아오지..?
	@GetMapping("/delete")
	public String deleteQuestion(String qno, HttpSession session) throws Exception {
		// 1. session에서 사용자 아이디 가져오기 + session에 로그인 된 아이디가 있는지 확인(-> interceptor)
		// 2. session에서 가져온 사용자 아이디와 questionDto의 아이디가 일치하는지 체크
		// 3. 일치하지 않으면 뒤로 가기(return 문 이용)
		
		questionService.deleteQuestion(Integer.parseInt(qno));
		
		return "redirect:/main"; // qna 사이트로 이동
	}
	
	
}
