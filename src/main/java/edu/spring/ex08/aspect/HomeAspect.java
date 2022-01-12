package edu.spring.ex08.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// 객체 관리 스프링 컴퍼넌트로 이동 
@Component // Proxy 객체에 주입(injection) 하기 위해 선언
@Aspect //Aspect  = Aspect = Adice + Pointcut
public class HomeAspect {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(HomeAspect.class);
	
	
// @Aspect
	// 일반적으로 메소드에 특정 기능을 적용시킴
	// 메소드 실행 전후에 특정 기능을 적용시킬 수 있다.
	
	
	
	
@Pointcut("execution (* edu.spring.ex08.HomeController.home(..))")

// 포인트 컷 위치 지정. - > 맨 밑에 설명 타이밍해놓음 참고. 11-17

public void pcHome() {} // 메소드를 불러오는게 new	

@Around("pcHome()") // 포인트 컷 메소드를 적용 @Around 알아서 컨트롤
public Object homeAdvice(ProceedingJoinPoint jp) {
	Object result = null;
	
		LOGGER.info("=== homeAdvice");
	// 데이터 이동 시 오류날 확률이 높아진다. 예외처리하는 이유. 11-17
	
	try {
		LOGGER.info("==== home() 호출 전"); // @before
		result = jp.proceed(); // HomeController.home() 실행 
		LOGGER.info("=== home() 리턴 후"); // @afterReturning
		
	} catch (Throwable e) { //@afterThrowing
		LOGGER.info("===예외 발생 : " + e.getMessage());
	} finally {
		// @after
		LOGGER.info("====finally");
		
	}
	
	return result; // 경로에 따라 가는 곳이 달라진다.
		
}

// 11.17
// ㅁ : 메소드임 애 자체에 특정한 기능 
// * pointcut 지정하는 방법.
// 1. @Before, @After .. 어노테이션 안에서 지정. (결론적으로 둘 다 같다.)
// 2. @PointCut 어노테이션 안에서 지정.
//- > 동일한 PointCut이 반복되는 것을 피할 수 있다.
//- > 한 번 지정하는 PointCut을 여러 advice 메소드에서 참조.
	
	
}// end HomeAspect
