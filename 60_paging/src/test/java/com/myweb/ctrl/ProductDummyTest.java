package com.myweb.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.ProductVO;
import com.myweb.persistence.product.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductDummyTest {
	private static Logger logger = LoggerFactory.getLogger(ProductDummyTest.class);
	
	@Inject
	private ProductDAO pdao;
	
//	@Test
//	public void removeProductTest() {
//		pdao.delete(11);
//	}
	
//	@Test
//	public void modifyProductTest() {
//		ProductVO pvo = new ProductVO();
//		pvo.setTitle("수정된 PVO 객체 제목");
//		pvo.setContent("수정된 PVO 객체 내용");
//		pvo.setPrice(987.65);
//		pvo.setPno(10);
//		pdao.update(pvo);
//	}
	
//	@Test
//	public void detailProductTest() {
//		ProductVO pvo = new ProductVO();
//		pvo = pdao.selectOne(10);
//		logger.info(pvo.toString());
//	}
	
//	@Test
//	public void selectProductListTest() {
//		List<ProductVO> list = new ArrayList<ProductVO>();
//		list = (ArrayList<ProductVO>) pdao.selectList();
//		for (ProductVO pvo : list) {
//			logger.info(pvo.toString());
//		}
//	}
	
	@Test
	public void insertProductTest() {
		for (int i = 0; i < 128; i++) {
			ProductVO pvo = new ProductVO();
			pvo.setTitle("상품 입력 테스트 제목" + i);
			pvo.setContent("상품 입력 테스트 내용" + i);
			int r = (int)(Math.random()*128); // 0 ~ 127
			pvo.setWriter("user" + r + "@user.com");
			pvo.setPrice((int)(Math.random()*1000)
					+ Double.parseDouble(String.format("%.2f", Math.random())));
			pdao.insert(pvo);
		}
	}
}
