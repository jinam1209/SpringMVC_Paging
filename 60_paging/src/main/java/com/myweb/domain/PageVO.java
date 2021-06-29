package com.myweb.domain;

public class PageVO {
	private String range; // 검색범위
	private String keyword; // 검색어
	
	public PageVO() {}
	
	public PageVO(String range, String keyword) {
		this.range = range;
		this.keyword = keyword;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
