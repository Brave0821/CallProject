package edu.spring.ex08.persistence;

import java.util.List;

import edu.spring.ex08.domain.FBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

public interface FBoardDAO {

	// D: 게시글 등록 11.15 등록
	public abstract int insert (FBoardVO vo);
	
	//  -게시글 전체 검색- 
	public abstract List<FBoardVO>select();
	
	//  -게시글 개별 검색- 
	public abstract FBoardVO select(int bno);
	
	// -게시글 수정- 
	public abstract int update (FBoardVO vo);
	
	// - 게시글 삭제-
	public abstract int delect(int bno);
	
	// -게시글 링크-
	public abstract List<FBoardVO>select(PageCriteria c);
	
	// -전체 게시글 수
	public abstract int getTotalNumsOfRecords();
	
	
	public abstract List<FBoardVO> select(String userid); //- 11-18 참고내용 아이디를 찾으면.
	public abstract List<FBoardVO> seleByTitleOrContent(String keyword);// 제목이나 내용물로 찾는 것.
	
	public abstract FBoardVO selectBno(String string);
	
	int updateFReplyCount(int amount, int bno);
	

}// END FBoardDAO
