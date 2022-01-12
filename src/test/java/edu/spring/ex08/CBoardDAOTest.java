package edu.spring.ex08;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex08.domain.CBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.persistence.CBoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class CBoardDAOTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(CBoardDAOTest.class);
	
	@Autowired
	private CBoardDAO dao;
	
	@Test
	public void testDAO() {
		
		testInsert();
		//testSelectAll();
		//testSelectByBno();	
		//testUpdate();
		//testDelete();
		//testSelectPaging();
		//testSelectSearch();
		
		}// end  testDAO
	



	private void testInsert() {
		CBoardVO vo = new CBoardVO("0","안녕", "oh", "admin", null);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert 성공");
		} else {
			LOGGER.info("insert 실패");
			
		}
		}// end testInsert()
	
	
	
	private void testSelectAll() {
		List<CBoardVO> list = dao.select();
		for(CBoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		}// testSelectAll()
	
	
	private void testSelectByBno() {
		CBoardVO vo = dao.select(3);
		LOGGER.info(vo.toString()); // 애 좀 이상함 이 페이지를 받아보기
		
	}// testSelectByBno
	

	
	private void testUpdate() {
		CBoardVO vo = new CBoardVO("4", "변경", "변경", null, null);
		int result = dao.update(vo);
		if(result == 1) {
			LOGGER.info("update 성공");
		} else {
			LOGGER.info("update 실패");
		}
		}// end testUpdate ()
	


	private void testDelete() {
		int result = dao.delete(3);
		LOGGER.info(result+"행 삭제");
		}// END testDelete
	
	

	private void testSelectPaging() {
		
		PageCriteria c = new PageCriteria(1, 5);
		List<CBoardVO> list = dao.select(c);
		for(CBoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		}// testSelectPagin ()
	
	
	private void testSelectSearch() {
		List<CBoardVO> list = dao.selectByTitleOrContent("스트");
		for(CBoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		}
	
		}// end BoardDAOTest () 
