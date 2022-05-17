package com.ssafy.happyhouse.model;

import java.util.List;

public class QNAInfo {
	private QuestionDto question;
	private List<AnswerDto> answer;
	
	public QNAInfo(QuestionDto question) {
		this.question = question;
	}
	
	public QNAInfo(QuestionDto question, List<AnswerDto> answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public QuestionDto getQuestion() {
		return question;
	}
	public List<AnswerDto> getAnswer() {
		return answer;
	}
}
