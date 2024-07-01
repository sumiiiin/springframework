package com.mycompany.springframework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ch14AspectAround {
	
	// public의 리턴타입은 상관 없고 com.mycompany.springframework.controller패키지에서 Ch14Controller 클래스의 모든 메소드의 매개변수는 상관 안하고 지정
	@Around("execution(public * com.mycompany.springframework.controller.Ch14Controller.around(..))")
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("around 전처리 코드 실행");
		
		Object result = joinPoint.proceed(); // 이 메소드는 리턴값이 반드시 있고 그걸 리턴해야 뷰에서 사용한다.?
		// Ch14Controller.around 실행하는 코드 리턴값을 반드시 처리해야함 
		
		log.info("around 후처리 코드 실행");

		// 공통 코드 중심에 핵심 코드 실행 하고 싶을 때
		
		return result;
	}
}

// 응용 - 로그인 체크, 최종프롲ㄱ트 발표를 위한 책자? 만들라믄 일주일 전에 끝내서 뭐...줘야한다... 