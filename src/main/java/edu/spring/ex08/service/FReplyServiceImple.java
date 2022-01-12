package edu.spring.ex08.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.ex08.domain.FReplyVO;
import edu.spring.ex08.persistence.FBoardDAO;
import edu.spring.ex08.persistence.FReplyDAO;

@Service
public class FReplyServiceImple implements FReplyService {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(FReplyServiceImple.class);
	
	@Autowired
	private FReplyDAO freplyDAO;
	
	@Autowired
	private FBoardDAO fboardDAO;
	

	@Transactional // 추가해주기. @Autowired 2개 
	@Override
	public int create(FReplyVO vo) throws Exception {
		// 11.18 
		// 댓글이 증가하면 게시판의 댓글 개수(freplycount)가 변경되어야함.
		// freply 테이블에 insert를 수행하면 
		// fboard 테이블에 update를 수행한다.
	LOGGER.info("create() 호출");
	freplyDAO.insert(vo);	
	
	LOGGER.info("댓글 입력 성공!");	
	//11-18 위 수행된거면 댓글이 잘 입력이 되있다.	
	
	fboardDAO.updateFReplyCount(1, vo.getFreplybno());
	LOGGER.info("게시판 댓글 개수 업데이트 성공! :D");
	return 1;
	} // 11-18 작성 버튼 누르면 되는데 리플 + 보드까지 여기서 씀.!


	@Override
	public List<FReplyVO> read(int freplybno) {
		LOGGER.info("read() 호출!");
		LOGGER.info("List 호출 확인!");
		
		return freplyDAO.select(freplybno);
	}

	
	@Override
	public int update(FReplyVO vo) {
		LOGGER.info("update() 호출");
		
		LOGGER.info("댓글 수정 성공:D");
		return freplyDAO.update(vo);
	}

	@Transactional
	@Override
	public int delete(int freplyno, int freplybno) throws Exception {
		LOGGER.info("delete() 호출");
		freplyDAO.delete(freplyno);
		LOGGER.info("댓글 삭제 성공:D");
		
		fboardDAO.updateFReplyCount(-1, freplybno);
		LOGGER.info("게시판 댓글 개수 삭제 성공!");
		return 1;
		}
	
}// end 
