package com.myweb.domain;

import java.util.List;

public class ProductVO {
	private int pno;
	private String title;
	private String content;
	private String writer;
	private double price;
	private String regdate;
	private String moddate;
	private int readcount;
	private int cmtqty;
	private List<FilesVO> flist;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getModdate() {
		return moddate;
	}
	public void setModdate(String moddate) {
		this.moddate = moddate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getCmtqty() {
		return cmtqty;
	}
	public void setCmtqty(int cmtqty) {
		this.cmtqty = cmtqty;
	}
	public List<FilesVO> getFlist() {
		return flist;
	}
	public void setFlist(List<FilesVO> flist) {
		this.flist = flist;
	}
	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", price="
				+ price + ", regdate=" + regdate + ", moddate=" + moddate + ", readcount=" + readcount + ", cmtqty="
				+ cmtqty + "]";
	}
	
}
