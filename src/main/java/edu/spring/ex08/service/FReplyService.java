package edu.spring.ex08.service;

import java.util.List;

import edu.spring.ex08.domain.FReplyVO;

public interface FReplyService {
	int create(FReplyVO vo) throws Exception; // 메소드 2개를 사용한 곳.
	List<FReplyVO> read(int freplybno);
	int update(FReplyVO vo);
	int delete(int freplyno, int freplybno) throws Exception;
	
	// int freplybno 삭제하면서 게시판에 카운팅을 변화시키기 위해 넣음
	
}// end 
