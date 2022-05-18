package com.ssafy.happyhouse.model;

public class ReviewerDto {
	private int no;
	private String title;
	private String content;
	private String createtime;
	private int score;
	public ReviewerDto(int no, String title, String content, String createtime, int score) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getCreatetime() {
		return createtime;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "ReviewerDto [no=" + no + ", title=" + title + ", content=" + content + ", createtime=" + createtime
				+ ", score=" + score + "]";
	}
	
	

}
