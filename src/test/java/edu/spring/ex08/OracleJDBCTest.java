package edu.spring.ex08;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
// 여기가 테스트 1단계! JDBC 확인단계 
public class OracleJDBCTest {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(OracleJDBCTest.class);

	private static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "call";
	private static final String PASSWORD = "12345";
	
	
	//1. JDBC 잘 되는지 확인 (잘 생성이 되야만)
	//DB 연결 확인.
	@Test // 어노테이션을 넣어주니 자동으로 수행된다. 원래 new해야 사용이 가능한데  
	// 재시작을하면 나중에는 리소스가 길기에 서버없이 돌리는게 가능.
	//run as  로거를 찍는게 가장 중요하다.
	
	public void testOracleConnect() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			LOGGER.info("oracle 연결 성공");
		} catch (SQLException e) {
			LOGGER.error("oracle 연결 실패" + e.getMessage());
			// error사용하면 에러로 나온다. 간결하게 나온다.
		}finally {
			try {
				conn.close();
				LOGGER.info("oracle 연결 해제 성공");
			} catch (SQLException e) {
				LOGGER.error("oracle 연결 해제 실패 : " + e.getMessage());
			}
			}
			}
			}
// test 패키지에 2. DataSource(DBCP) 잘 되는지 확인