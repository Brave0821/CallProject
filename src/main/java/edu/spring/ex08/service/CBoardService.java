package edu.spring.ex08.service;

import java.util.List;

import edu.spring.ex08.domain.CBoardVO;
import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

// CRUD (create(insert), read(select), update, delete)

public interface CBoardService {

	public abstract int create(CBoardVO vo);

	public abstract List<CBoardVO> read(PageCriteria criteria);

	public abstract CBoardVO read(int bon);

	public abstract int update(CBoardVO vo);

	public abstract int delete(int bno);

	public abstract int getTotalNumsOfRecords();

	// 게시글 전체 목록 -> 감색옵션 키워드 매개변수 추가. 11-26

	public List<NBoardVO> listAll(String searchOption, String keyword) throws Exception;

}// end CBoardService
