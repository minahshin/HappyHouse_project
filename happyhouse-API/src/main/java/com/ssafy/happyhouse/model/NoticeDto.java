package com.ssafy.happyhouse.model;

public class NoticeDto {
	private int nno;
	private String category;
	private String subject;
	private String content;
	private String writer;
	private String regDate;
	
	public int getNno() {
		return nno;
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
	
	@Override
	public String toString() {
		return "NoticeDto [nno=" + nno + ", category=" + category + ", subject=" + subject + ", content=" + content
				+ ", writer=" + writer + ", regDate=" + regDate + "]";
	}


}
