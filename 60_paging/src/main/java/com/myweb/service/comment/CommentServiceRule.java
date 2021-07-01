package com.myweb.service.comment;

import java.util.List;

import com.myweb.domain.CommentDTO;
import com.myweb.domain.CommentVO;
import com.myweb.domain.PageVO;

public interface CommentServiceRule {
	public int register(CommentVO cvo);
	public CommentDTO getList(int pno, PageVO pgvo);
	public int modify(CommentVO cvo);
	public int remove(int cno);
	public int removeAll(int pno);
//	public int getTotalCount(int pno);
}
