package edu.spring.ex08.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex08.domain.FBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.persistence.FBoardDAO;

@Service
public class FBoardServiceImpl implements FBoardService {

	// implements FBoardService 이 부분 추가.
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FBoardDAO.class);

	
	@Autowired
	private FBoardDAO dao;
	
	
	@Override
	public int create(FBoardVO vo) {
		LOGGER.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo); // dao랑 
	}

	@Override
	public List<FBoardVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : PageCriteria =" + criteria);
		return dao.select(criteria);
	}

	@Override
	public FBoardVO read(int bno) {
		LOGGER.info("read() 호출 : bno = " + bno);
		return dao.select(bno);
	}

	@Override
	public int update(FBoardVO vo) {
		LOGGER.info("update() 호출 : vo = " + vo.toString());
		return  dao.update(vo);
	}

	@Override
	public int delete(int bno) {
		LOGGER.info("delete() 호출 : bno = " + bno);
		return dao.delect(bno);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}
	
	
	}// END 
	
