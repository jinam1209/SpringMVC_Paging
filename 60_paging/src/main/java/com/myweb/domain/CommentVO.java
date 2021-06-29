package com.myweb.domain;

public class CommentVO {
	private int cno;
	private int pno;
	private String writer;
	private String content;
	private String regdate;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", pno=" + pno + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
	
}
