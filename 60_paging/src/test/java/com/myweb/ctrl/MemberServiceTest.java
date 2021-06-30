package com.myweb.ctrl;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.MemberVO;
import com.myweb.service.member.MemberService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberServiceTest { // Controller 입장에서 Service Test
	private static Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	@Inject
	private MemberService msv;
	
	@Test
	public void memberRegisterTest() throws Exception {
		MemberVO mvo = new MemberVO();
		mvo.setEmail("admin@admin.com");
		mvo.setNickname("admin");
		mvo.setPwd("1111");
		msv.register(mvo);
	}
}
