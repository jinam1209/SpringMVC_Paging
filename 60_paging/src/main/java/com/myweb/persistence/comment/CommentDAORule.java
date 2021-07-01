package com.myweb.persistence.comment;

import java.util.List;

import com.myweb.domain.CommentVO;
import com.myweb.domain.PageVO;

public interface CommentDAORule {
	public int insert(CommentVO cvo);
	public List<CommentVO> selectList(int pno, PageVO pgvo);
	public int update(CommentVO cvo);
	public int delete(int cno);
	public int deleteAll(int pno);
	public int selectCount(int pno, PageVO pgvo);
}
