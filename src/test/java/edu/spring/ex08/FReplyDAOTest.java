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

import edu.spring.ex08.domain.FReplyVO;
import edu.spring.ex08.persistence.FReplyDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration


// import org.junit.Test;
// import org.junit.runner.RunWith; 

public class FReplyDAOTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(FReplyDAOTest.class);
	
	@Autowired
	private FReplyDAO dao;
	// 애를 불러왔는데 
	
	@Test
	public void testDAO() {
		testInsert();
		//testSelete();
		//testUpdate();
		//testDelete();
	}

	// dao를 만들었으니 서비스를 만들어야한다. 

	private void testInsert() {
		FReplyVO vo = new FReplyVO(0, 3, "test2", "오", null);
		int result = dao.insert(vo);
		LOGGER.info(result + "행 삽입");
			
	}
	
	
	private void testSelete() {
		List<FReplyVO> list = dao.select(3);
		LOGGER.info(list.size() + "");
		for(FReplyVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}
	
	
	private void testUpdate() {
		FReplyVO vo = new FReplyVO(1, 0, "update", "mok", null);
		int result = dao.update(vo);
		LOGGER.info(result + "행 변경");
		// 0 바꾸고자하는 데이터 1,  2번째 0은 게시판 번호(프라이머리 키로 유일함을 나타내기에 사실 필요가없다.)
	}
	
	
	
	
	private void testDelete() {
		int result = dao.delete(1);
		LOGGER.info(result + "행 삭제");
	}
	
	
	
	
	
	
	
}// end BoardDAOTest () 

