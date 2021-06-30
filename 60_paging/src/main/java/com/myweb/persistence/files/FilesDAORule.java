package com.myweb.persistence.files;

import java.util.List;

import com.myweb.domain.FilesVO;

public interface FilesDAORule {
	public int insert(FilesVO fvo);
	public List<FilesVO> selectList(int pno);
	public int delete(int pno);
	public int delete(String uuid);
}
