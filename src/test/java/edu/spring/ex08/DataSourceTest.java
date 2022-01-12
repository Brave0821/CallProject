package edu.spring.ex08;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@WebAppConfiguration
public class DataSourceTest {
private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceTest.class);

// 테스트 2단계 	
	
// Spring Framework 가 관리하는 DataSource 객체를 주입받음 
// - root-context.xml에서 bean으로 선택된 DataSource 객체를 주입받음
// xml 문서는 java 	

	@Autowired // 자동연결! 이미 만들어진 객체를 만들어진걸 주입 
	private DataSource ds; 
	// 테스트를 객체를 생성해서 하는게 좋다. 
	// 그래야 url이나 id가 잘못 됬는지 확인가능.!
	// 원래는 new 변수 객체 넣으려면 해야하는데 여기선

	// root -context에 전부 싸져있기에 정보에
	@Test
	public void testDataSource() {
			Connection conn = null;
			try {
			conn = ds.getConnection();
			LOGGER.info("DataSource 연결 성공 ");
			} catch (SQLException e) {
			LOGGER.error("DataSource 연결 실패 :" + e.getMessage());
			} finally {
			try {
				conn.close();
				LOGGER.info("DataSource 연결 반환 성공 ");

			} catch (SQLException e) {
				LOGGER.error("DataSource 연결 반환 실패 :" + e.getMessage());
			}
			}

			}

			}// end 2 DataSourceTest - > 3 SqlSessionFactory 생성하기.
