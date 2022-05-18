package com.ssafy.happyhouse.model;

public class QuestionDto {
	private int qno;
	private String category;
	private String subject;
	private String content;
	private String writer;
	private String regDate;
	private String isSecret;
	
	public int getQno() {
		return qno;
	}
	public String getCategory() {
		return category;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public String getIsSecret() {
		return isSecret;
	}
	@Override
	public String toString() {
		return "QuestionDto [qno=" + qno + ", category=" + category + ", subject=" + subject + ", content=" + content
				+ ", writer=" + writer + ", regDate=" + regDate + ", isSecret=" + isSecret + "]";
	}
}
