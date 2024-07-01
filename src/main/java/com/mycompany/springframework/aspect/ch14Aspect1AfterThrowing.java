package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ch14Aspect1AfterThrowing {
	
	// public의 리턴타입은 상관 없고 com.mycompany.springframework.controller패키지에서 Ch14Controller 클래스의 모든 메소드의 매개변수는 상관 안하고 지정
	@AfterThrowing(pointcut="execution(public * com.mycompany.springframework.controller.Ch14Controller.*(..))",
			throwing="e")
	public void method(Throwable e) {
		log.info("예외 처리하는 후 처리 코드 실행");
		log.info("예외 이유: "+ e.getMessage());
//		if(e instanceof NullPointerException) {
//			
//		} else if(e instanceof EnumConstantNotPresentException){
//			
//		}
		// throwing에 예외 이름을 지정해 주고 변수타입은 Throwable이다. 매개변수로 받으면 핵심코드의 예외가 매개변수로 들어오게 된다.
	}
}
