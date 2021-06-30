package com.myweb.ctrl;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.MemberVO;
import com.myweb.persistence.member.MemberDAORule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberDummyTest {
	private static Logger logger = LoggerFactory.getLogger(MemberDummyTest.class);
	
	@Inject
	private MemberDAORule mdao;
	
	@Test
	public void insertMemberTest() throws Exception {
		for (int i = 0; i < 128; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setEmail("user" + i + "@user.com");
			mvo.setPwd("1111");
			mvo.setNickname("USER" + i);
			mdao.insert(mvo);
		}
	}
	
//	@Test
//	public void insertMemberTest() throws Exception {
//		MemberVO mvo = new MemberVO();
//		mvo.setEmail("tester@tester.com");
//		mvo.setPwd("1111");
//		mvo.setNickname("tester");
//		mdao.insert(mvo);
//	}
	
//	@Test
//	public void insertMembersTest() throws Exception {
//		for (int i = 0; i < 128; i++) {
//			MemberVO mvo = new MemberVO();
//			mvo.setEmail("tester" + i + "@tester.com");
//			mvo.setPwd("1111");
//			mvo.setNickname("tester" + i);
//			mdao.insert(mvo);
//		}
//	}
	
//	@Test
//	public void listMemberTest() throws Exception {
//		List<MemberVO> list = mdao.selectList();
//		for (MemberVO mvo : list) {
//			logger.info(mvo.getEmail() + ","
//					+ mvo.getNickname() + ","
//					+ mvo.getPwd() + "," 
//					+ mvo.getNickname());
//		}
//	}
	
//	@Test
//	public void loginMemberTest() throws Exception {
//		MemberVO mvo = new MemberVO();
//		mvo.setEmail("tester0@tester.com");
//		mvo.setPwd("1111");
//		MemberVO loginInfo = mdao.selectOne(mvo);
//		logger.info(loginInfo.getEmail());
//		logger.info(loginInfo.getNickname());
//		logger.info(loginInfo.getPwd());
//		logger.info(loginInfo.getRegdate());
//	}
	
//	@Test
//	public void deleteMemberTest() throws Exception {
//		mdao.delete("tester@tester.com");
//	}
}
