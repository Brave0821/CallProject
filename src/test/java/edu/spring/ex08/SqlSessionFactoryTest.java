package edu.spring.ex08;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class SqlSessionFactoryTest {
   private static final Logger LOGGER = 
         LoggerFactory.getLogger(SqlSessionFactoryTest.class);
   
   // 테스트 3단계
   @Autowired
   private SqlSessionFactory sessionFactory;
   
   @Test
   public void testSqlSessionFactory() {
      SqlSession session = sessionFactory.openSession();
      if (session != null) {
         LOGGER.info("SqlSession 생성 성공");
      } else {
         LOGGER.info("SqlSession 생성 실패");
      }
   	  }
	  }
