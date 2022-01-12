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


import edu.spring.ex08.domain.FBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.persistence.FBoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class FBoardDAOTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(FBoardDAOTest.class);
	
	@Autowired
	private FBoardDAO dao;
	
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
		FBoardVO vo = new FBoardVO("0","안녕", "oh", "admin", null);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert 성공");
		} else {
			LOGGER.info("insert 실패");
			
		}
		}// end testInsert()
	
	
	
	private void testSelectAll() {
		List<FBoardVO> list = dao.select();
		for(FBoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		}// testSelectAll()
	
	
	private void testSelectByBno() {
		FBoardVO vo = dao.select(3);
		LOGGER.info(vo.toString()); // 애 좀 이상함 이 페이지를 받아보기
		
	}// testSelectByBno
	

	
	private void testUpdate() {
		FBoardVO vo = new FBoardVO("4", "변경", "변경", null, null);
		int result = dao.update(vo);
		if(result == 1) {
			LOGGER.info("update 성공");
		} else {
			LOGGER.info("update 실패");
		}
		}// end testUpdate ()
	


	
	private void testDelete() {
		int result = dao.delect(3);
		LOGGER.info(result+"행 삭제");
		}// END testDelete
	
	

	private void testSelectPaging() {
		
		PageCriteria c = new PageCriteria(1, 5);
		List<FBoardVO> list = dao.select(c);
		for(FBoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		}// testSelectPagin ()
	
	
	private void testSelectSearch() {
		List<FBoardVO> list = dao.seleByTitleOrContent("스트");
		for(FBoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		}
	
		}// end BoardDAOTest () 
