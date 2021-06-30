package com.myweb.ctrl;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.CommentVO;
import com.myweb.persistence.comment.CommentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentDummyTest {
	private static Logger logger = LoggerFactory.getLogger(CommentDummyTest.class);
	
	@Inject
	private CommentDAO cdao;
	
	@Test
	public void insertCommentTest() throws Exception {
		for (int pno = 1; pno < 129; pno++) {
			int cmtqty = (int)(Math.random()*128);
			for (int j = 0; j < cmtqty; j++) {
				CommentVO cvo = new CommentVO();
				cvo.setPno(pno);
				cvo.setContent(j + "번째 테스트 댓글 내용내용");
				int rr = (int)(Math.random()*128);
				cvo.setWriter("user"+rr+"@user.com");
				cdao.insert(cvo);
			}
		}
	}
	
//	@Test
//	public void insertCommentTest() {
//		CommentVO cvo = new CommentVO();
//		cvo.setPno(131); // 존재하는 pno로 test해야됨!!
//		cvo.setWriter("admin@admin.com");
//		cvo.setContent("comment test");
//		cdao.insert(cvo);
//	}
}
