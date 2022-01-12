package edu.spring.ex08.service;

import java.util.List;

import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

// CRUD (CREATE(INSERT), READ(SELECT), UPDATE, DELETE)
	
public interface NBoardService {
	
	public abstract int create (NBoardVO vo); // 등록
	
	public abstract List<NBoardVO>read(PageCriteria criteria); 
	public abstract NBoardVO read(int bno); // 검색 
	
	public abstract int update(NBoardVO vo); 
	public abstract int delete(int bno);
	public abstract int getTotalNumsOfRecords();

	// 게시판 검색기능 추가.! 11-25
	// public abstract List<NBoardVO> getSearchList(NBoardVO vo);
	
	// 게시글 전체 목록 -> 감색옵션 키워드 매개변수 추가. 11-26
	
	public List<NBoardVO> listAll(String searchOption, String keyword) throws Exception;
	
	
}// end NBoardService
