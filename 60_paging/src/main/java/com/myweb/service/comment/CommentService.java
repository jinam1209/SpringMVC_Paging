package com.myweb.service.comment;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.CommentVO;
import com.myweb.domain.PageVO;
import com.myweb.persistence.comment.CommentDAORule;

@Service
public class CommentService implements CommentServiceRule {
	private static Logger logger = LoggerFactory.getLogger(CommentService.class);

	@Inject
	private CommentDAORule cdao;

	@Override
	public int register(CommentVO cvo) {
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(int pno, PageVO pgvo) {
		return cdao.selectList(pno, pgvo);
	}

	@Override
	public int modify(CommentVO cvo) {
		return cdao.update(cvo);
	}

	@Override
	public int remove(int cno) {
		return cdao.delete(cno);
	}

	@Override
	public int removeAll(int pno) {
		return cdao.deleteAll(pno);
	}

	@Override
	public int getTotalCount(int pno) {
		return cdao.selectCount(pno);
	}

}
