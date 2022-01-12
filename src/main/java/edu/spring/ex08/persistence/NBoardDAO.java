package edu.spring.ex08.persistence;

import java.util.List;

import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

public interface NBoardDAO {

	// * 게시글 등록
	public abstract int insert(NBoardVO vo);
	
	//* 게시글 전체 검색
	public abstract List<NBoardVO> select();
	
	// * 게시글 개별 검색 
	public abstract NBoardVO select(int bno);
	
	// * 게시글 수정 
	public abstract int update(NBoardVO vo);
	
	// * 게시글 삭제 
	public abstract int delete(int bno);
	
	// * 게시글 링크
	public abstract List<NBoardVO>select(PageCriteria c);
	
	// * 전체 게시글 수 
	public abstract int getTotalNumsOfRecords();
	
	
	// * 게시판에 기능 검색 날짜, 키워드 제목 내용 단어가 포함되어 있는 것만 검색 
	
	public abstract List<NBoardVO> select(String userid); // 아이디를 찾으면 
	public abstract List<NBoardVO> selectByTitleOrContent(String keyword); //제목 or 내용물로 찾기 
	public abstract NBoardVO selectBno(String string);

	// 11-26 추가 게시글 전체 목록 -> 검색옵션, 키워드 매개변수 추가.
	public List<NBoardVO> listAll(String searchOption, String keyword) throws Exception;
		

	// 게시판 검색기능 추가.
	
	// public abstract List<NBoardVO> getSearchList(NBoardVO vo);

	/* public abstract List<NBoardVO> getSearchList(); */
	
} // end NBoardDAO
