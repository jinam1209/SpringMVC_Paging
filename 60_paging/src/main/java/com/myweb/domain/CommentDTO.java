package com.myweb.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentDTO {
	private static Logger logger = LoggerFactory.getLogger(CommentDTO.class);
	private int totalCount;
	private List<CommentVO> cmtlist; // result 로 받는 애
	
	public CommentDTO() {}

	public CommentDTO(int totalCount, List<CommentVO> list) {
		this.totalCount = totalCount;
		this.cmtlist = list;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<CommentVO> getCmtlist() {
		return cmtlist;
	}
	public void setCmtlist(List<CommentVO> cmtlist) {
		this.cmtlist = cmtlist;
	}
	
}
