package edu.spring.ex08.persistence;

import java.util.List;

import edu.spring.ex08.domain.CBoardVO;
import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

public interface CBoardDAO {

	// C: 게시글 등록 
	public abstract int insert(CBoardVO vo);
	
	// C: 게시글 전체 검색 
	public abstract List<CBoardVO> select();
	
	// C: 게시글 개별 검색 
	public abstract CBoardVO select(int bno);
	
	// C: 게시글 수정 
	public abstract int update(CBoardVO vo);
	
	// C:  게시글 삭제 
	public abstract int delete(int bno);
	
	// C: 게시글 링크 
	public abstract List<CBoardVO>select(PageCriteria c);
	
	// C: 전체 게시글 수  
	public abstract int getTotalNumsOfRecords();
	
	// C: 게시판에 기능 검색 날짜, 키워드 제목 내용 단어가 포함되어 있는 것만 검색.
	
	public abstract List<CBoardVO> select(String userid);
	public abstract List<CBoardVO> selectByTitleOrContent(String keyword);
	public abstract CBoardVO selectBno(String string);
	
	// 11-26 추가 게시글 전체 목록 -> 검색옵션, 키워드 매개변수 추가.
		public List<NBoardVO> listAll(String searchOption, String keyword) throws Exception;
			
	
	
}// DAO CBoardDAO 긑
