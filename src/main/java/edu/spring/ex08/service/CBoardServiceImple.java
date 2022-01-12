package edu.spring.ex08.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex08.domain.CBoardVO;
import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.persistence.CBoardDAO;

@Service
public class CBoardServiceImple implements CBoardService {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(CBoardDAO.class);
	
	//CRUD : create(insert), read(select), update, delete 11-23 
		
	@Autowired
	private CBoardDAO dao;

	@Override
	public int create(CBoardVO vo) {
		LOGGER.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<CBoardVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : PageCriteria =" + criteria);
		return dao.select(criteria);
	}

	@Override
	public CBoardVO read(int bno) {
		LOGGER.info("read() 호출 : bno = " + bno);
		return dao.select(bno);
	}

	@Override
	public int update(CBoardVO vo) {
	LOGGER.info("update()호출 : vo = " + vo.toString());
		return dao.update(vo);
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

	@Override
	public List<NBoardVO> listAll(String searchOption, String keyword) throws Exception {
		LOGGER.info("listAll() 호출");
		return dao.listAll(searchOption, keyword);
	}
	
	
}// end 
