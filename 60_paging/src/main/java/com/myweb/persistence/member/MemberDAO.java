package com.myweb.persistence.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.MemberVO;
import com.myweb.domain.PageVO;

@Repository
public class MemberDAO implements MemberDAORule { // commit 알아서 해줌
	private static Logger logger = LoggerFactory.getLogger(MemberDAO.class);
	private final String NS = "MemberMapper.";
	
	@Inject
	private SqlSession sql; // root-context
	
	@Override
	public int insert(MemberVO mvo) {
		return sql.insert(NS + "reg", mvo);
	}

	@Override
	public int selectEmail(String email) {
		return sql.selectOne(NS + "check", email);
	}

	@Override
	public List<MemberVO> selectList(PageVO pgvo) {
		return sql.selectList(NS + "list", pgvo);
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return sql.selectOne(NS + "login", mvo);
	}

	@Override
	public MemberVO selectOne(String email) {
		return sql.selectOne(NS + "detail", email);
	}

	@Override
	public int update(MemberVO mvo) {
		return sql.update(NS + "mod", mvo);
	}

	@Override
	public int delete(String email) {
		return sql.delete(NS + "del", email);
	}

	@Override
	public int selectOne(PageVO pgvo) {
		return sql.selectOne(NS + "tc", pgvo);
	}

}
