package com.myweb.persistence.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.PageVO;
import com.myweb.domain.ProductVO;

@Repository
public class ProductDAO implements ProductDAORule {
	private static Logger logger = LoggerFactory.getLogger(ProductDAO.class);
	private final String NS = "ProductMapper.";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public int insert(ProductVO pvo) {
		return sql.insert(NS + "reg", pvo);
	}

	@Override
	public List<ProductVO> selectList(PageVO pgvo) {
		return sql.selectList(NS + "list", pgvo);
	}

	@Override
	public ProductVO selectOne(int pno) {
		return sql.selectOne(NS + "detail", pno);
	}

	@Override
	public int update(ProductVO pvo) {
		return sql.update(NS + "mod", pvo);
	}

	@Override
	public int delete(int pno) {
		return sql.delete(NS + "del", pno);
	}

	@Override
	public int selectOne() { // 현재 pno
		return sql.selectOne(NS + "curr");
	}

}
