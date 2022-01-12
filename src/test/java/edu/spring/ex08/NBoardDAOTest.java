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

import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.persistence.NBoardDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration


public class NBoardDAOTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(NBoardDAOTest.class);
	
	@Autowired
	private NBoardDAO dao;
	
	@Test
	public void testDAO() {
		
		
	testInsert();
 	//testSelectAll();
	//testSelectByBno();
	// testUpdate();
	// testDelete();
	// testSelectPaging();
	//testSelectSearch();
	
	}// end  testDAO
	

	private void testInsert() { // 위에 널 2개 타입이랑 키워드 vo추가해서 ㅇㅇ ~
		NBoardVO vo = new NBoardVO("6","안녕", "oh", "admin", null);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert 성공");
		} else {
			LOGGER.info("insert 실패");
			
		}
		}// end testInsert()
	
	
	
	private void testSelectAll() {
		List<NBoardVO> list = dao.select();

			LOGGER.info(list.toString());

		}// testSelectAll()
	
	
	
	private void testSelectByBno() {
		NBoardVO vo = dao.selectBno("0");
		
		LOGGER.info(vo.toString()); // 애 좀 이상함 이 페이지를 받아보기
		
		}// testSelectByBno
	

	
	private void testUpdate() {
		NBoardVO vo = new NBoardVO("0", "변경", "변경", "brave", null);
		int result = dao.update(vo);
		if(result == 1) {
			LOGGER.info("update 성공");
		} else {
			LOGGER.info("update 실패");
		}
		}// end testUpdate ()
	

	
	
	private void testDelete() {
		int result = dao.delete(1);
		LOGGER.info(result + "행 삭제");
		
		}// END testDelete ()
	
	
	
	

	private void testSelectPaging() {
		
		PageCriteria c = new PageCriteria(1, 2);
		List<NBoardVO> list = dao.select(c);
		for(NBoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		}// testSelectPagin ()
	
	
	
	private void testSelectSearch() {
		List<NBoardVO> list = dao.selectByTitleOrContent("스트");
		for(NBoardVO vo : list) {
			LOGGER.info(vo.toString());
		}
		}
	
		}// end NBoardDAOTest () 
