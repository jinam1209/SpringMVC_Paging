package com.myweb.persistence.product;

import java.util.List;

import com.myweb.domain.PageVO;
import com.myweb.domain.ProductVO;

public interface ProductDAORule {
	public int insert(ProductVO pvo);
	public List<ProductVO> selectList(PageVO pgvo);
	public ProductVO selectOne(int pno);
	public int update(ProductVO pvo);
	public int delete(int pno);
	public int selectOne();
}
