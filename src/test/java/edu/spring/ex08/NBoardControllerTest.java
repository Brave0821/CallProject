package edu.spring.ex08;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class NBoardControllerTest {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(NBoardDAOTest.class);
	
	@Autowired
	private WebApplicationContext wac; // 웹 어플리케이션 객체 
	
	
	// mvc 패턴의 앱을 테스트하는 mock-up 객체 
	private MockMvc mock; // 테스트하기 위한 용도임.
	
	// 기능이 있다.before/after
	@Before // org.junit 사용 
	// 실제 JUnit 테스트를 실행하기 전에 초기화 작업을 수행하는 메소드 
	
	public void beforeTest() {
		LOGGER.info("beforeTest() 호출");
		LOGGER.info("wac : " + wac);
		LOGGER.info("mock :" + mock);
		// 컨트롤러 메소드에게 요청을 보낼 수 있는 mockup 객체 생성 
		mock= MockMvcBuilders.webAppContextSetup(wac).build();
		
		}
	
	
	@Test
	public void test() throws Exception {
		testList();
	}
	
	//throws Exception 이거 추가하면 예외처리 데이터 유실성 감소 
	
	private void testList() throws Exception {
		LOGGER.info("testList() 호출");
		// get(uri) : get 요청에 대한 mock 객체 생성 
		// post(uri) : post 요청에 대한 mock 객체 생성 
		// put(uri) : put 요청에 대한 mock 객체 생성 
		// delete(uri) : DELETE 요청에 대한 mock 객체 생성 
		// param(key, value) : 파라미터 테이터 전송 
		// param(params) : 파라미터(map 형식) 데이터 전송 
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(); 
		
		params.add("page","1");	
		params.add("numsPerPage","5");	
			
		// 서블릿에서 ia 익셉션 드응 데이터 이동 유실처리 될 수있기에 예외처리해야함
		mock.perform(get("/nboard/nlist").params(params));
		// 데이터 문자열 키 값 page 문자열
		// request 방식에서 전송방식 문자열 
		// string-> prameter는 무조건 string
	}
	
	// JUnit 테스트 수행 후 호출되는 메소드 
	@After // import 부분에 다른게 되어있어서?  
	public void afterTest() {
		LOGGER.info("afterTest() 호출");
	}
	

	// 보드 컨트롤러 테스를 위해서 보드 리스트에 ex08/fboard/flist/에서 가져오는 것 
	// 경로가 뭐고 메소드가 뭔지 알아야 테스트가 가능하다.
	
	
	}// end BoardControllerTest() 

