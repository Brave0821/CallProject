package edu.spring.ex08.service;

import java.util.List;

import edu.spring.ex08.domain.FBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

// 11-18 참고내용 
// CRUD CREATE(INSERT), READ(SELECT), UPDATE, DELETE)

public interface FBoardService {

		
	public abstract int create (FBoardVO vo); // 등록 
	public abstract List<FBoardVO>read(PageCriteria criteria);
	public abstract FBoardVO read(int bno);
	public abstract int update(FBoardVO vo);
	public abstract int delete(int bno);
	public abstract	int getTotalNumsOfRecords();		
	
			
			
} // end FBoard Service
