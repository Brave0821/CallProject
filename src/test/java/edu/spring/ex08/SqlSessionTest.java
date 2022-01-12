package edu.spring.ex08;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex08.domain.FBoardVO;
import edu.spring.ex08.domain.NBoardVO;

// board mapper 즉 test를 하기 위해선 연결을 해야한다. 그룹을 대표하는 아이디가 필요하다.


// 4단계 - > board dao 생성 후 board dao test 돌리기.
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration

public class SqlSessionTest {
	 private static final Logger LOGGER = 
	         LoggerFactory.getLogger(SqlSessionTest.class);
	
	private static final String NAMESPACE = 
			"edu.spring.ex08.BoardMapper"; // 보드 맵핑 - > namespace에서 가져옴. 
		
			
		
		@Autowired 
		private SqlSession sqlSession;
	
	
	
		@Test
		public void testInsert () {
		// sqlSession.하면 다양한 함수들이 나온다. dao  imple insert 기능 전부 함축한 것 
	
		
		//NBoardVO vo = new NBoardVO("0", "hello", "hello", "mok", null);
		//int result = sqlSession.insert(NAMESPACE + ".ninsert", vo); // 집어넣을 때 vo를 보냄 
		
		
		 FBoardVO vo = new FBoardVO("0", "hello", "hello", "mok", null); int result =
		 sqlSession.insert(NAMESPACE + ".finsert", vo); // 집어넣을 때 vo를 보냄
		 
		 LOGGER.info(result + "행 삽입");
		 
		// vo랑 맵퍼랑 이름이 같아야한다.	
		// 위의 기능이 daoImple에서 하는 기능
	
		
		// NAMESPACE에 내가 가고자하는 아이디 - > board mapper에 insert Id
		// 1은 성공 0은 실패 
		
		// .insert : mapper.xml의 id값  sql 세션의 insert 메소드는 맵퍼 메소드의 insert 태그 
		// 스태이트먼트 키 파라미터 값 
		
		// 쿼리랑 데이터 값이 맞는지 확인 할 수있다.! 
		// 만약 여기서 문제가 생긴다면? - > 맵퍼의 쿼리, 이름이 맞는지.  마이바티스 확인하기.! 
		
		/// daoimple에서 기능임. 
		// dao test 생성 
		// sqlSession.
		
		}// end testInsert () 
	

	
	
	// VO 다음? 생성 edu.spring.ex08.persistence
	} // end 4 SqlSessionTest (3 sessionFactory에서 건너옴)

