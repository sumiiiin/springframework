package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ch14Aspect1AfterReturning {
	
	// public의 리턴타입은 상관 없고 com.mycompany.springframework.controller패키지에서 Ch14Controller 클래스의 afterReturning메소드의 매개변수는 상관 안하고 지정
	@AfterReturning(pointcut="execution(public * com.mycompany.springframework.controller.Ch14Controller.afterReturning(..))",
			returning="returnValue")
	public void method(String returnValue) {
		log.info("실행이 끝나고 리턴값을 받아서 사용을 할 AfterReturnning 처리 코드 실행");
		log.info("리턴 값: "+ returnValue);
		// returning에 매개변수 이름을 지정해 주고 매개변수로 받으면 핵심코드의 리턴값이 매개변수로 들어오게 된다.
	}
}
