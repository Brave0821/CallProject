//package edu.spring.ex08.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class LoggingAspect {
//	private static final Logger LOGGER = 
//			LoggerFactory.getLogger(LoggingAspect.class);
//	// 1. @Before, @After, .. 어노테이션 안에서 지정 (결론적으로 둘 다 같음 방법 사용)
//	
//	@Before("execution(* edu.spring.ex08.service.CustomerServiceImple.*Customer(..))")
//	public void beforeAdvice(JoinPoint jp) {
//		LOGGER.info("===== beforeAdvice");
//		LOGGER.info("target : " + jp.getTarget());
//		LOGGER.info("signature : " + jp.getSignature());
//		
//	} // 스프링 버젼 업그레이드 했어도 메모리 측면에서 비슷하기에 바꿀 이유가 없다.
//	
//	@After("execution(* edu.spring.ex08.service.*ServiceImple.create*(..))")
//	public void afterAdvice() {
//		LOGGER.info("==== afterAdvice");
//	}
//	
//
//} // end 
