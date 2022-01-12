package edu.spring.ex08.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.persistence.NBoardDAO;

@Service
public class NBoardServiceImpl implements NBoardService {

	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(NBoardDAO.class);
	
	
	@Autowired
	private NBoardDAO dao;
	
	
	@Override
	public int create(NBoardVO vo) {
		LOGGER.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo); // dao랑 
	}

	// read : select 
	
	@Override
	public List<NBoardVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : PageCriteria =" + criteria);
		return dao.select(criteria);
	}

	@Override
	public NBoardVO read(int bno) {
		LOGGER.info("read() 호출 : bno = " + bno);
		return dao.select(bno);
	}

	@Override
	public int update(NBoardVO vo) {
		LOGGER.info("update() 호출 : vo = " + vo.toString());
		return  dao.update(vo);
	}

	@Override
	public int delete(int bno) {
		LOGGER.info("delete() 호출 : bno = " + bno);
		return dao.delete(bno);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return dao.getTotalNumsOfRecords();
	}

	// 11-26 추가.
	@Override
	public List<NBoardVO> listAll(String searchOption, String keyword) throws Exception {
		LOGGER.info("listAll() 호출");
		return dao.listAll(searchOption, keyword);
	}

	// 11-25 게시판 검색기능 추가.
	
//	@Override
//	public List<NBoardVO> getSearchList(NBoardVO vo) {
//		LOGGER.info("getSearchList() 호출");
//		return dao.getSearchList(vo);
//	}
	
	
	

}
