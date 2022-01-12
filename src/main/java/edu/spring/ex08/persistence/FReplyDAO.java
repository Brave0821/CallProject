package edu.spring.ex08.persistence;

import java.util.List;

import edu.spring.ex08.domain.FReplyVO;

public interface FReplyDAO {

	 int insert(FReplyVO vo);
	 List<FReplyVO> select(int freplybno);
	 int update(FReplyVO vo);
	 int delete(int freplyno);
	 
} // END 
