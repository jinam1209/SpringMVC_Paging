package com.myweb.persistence.member;

import java.util.List;

import com.myweb.domain.MemberVO;
import com.myweb.domain.PageVO;

public interface MemberDAORule { // memberMapper 참고
	public int insert(MemberVO mvo); // reg
	public int selectEmail(String email); // check
	public List<MemberVO> selectList(PageVO pgvo); // list
	public MemberVO selectOne(MemberVO mvo); // login
	public MemberVO selectOne(String email); // detail
	public int update(MemberVO mvo); // mod
	public int delete(String email); // del
	public int selectOne(PageVO pgvo);
}
