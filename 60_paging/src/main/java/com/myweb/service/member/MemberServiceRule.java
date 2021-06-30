package com.myweb.service.member;

import java.util.List;

import com.myweb.domain.MemberVO;
import com.myweb.domain.PageVO;

public interface MemberServiceRule {
	public int register(MemberVO mvo);
	public int checkEmial(String email);
	public List<MemberVO> getList(PageVO pgvo);
	public MemberVO login(MemberVO mvo);
	public MemberVO detail(String email);
	public int modify(MemberVO mvo);
	public int remove(String email);
	public int getTotalCount(PageVO pgvo);
}
