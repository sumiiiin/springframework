package com.mycompany.springframework.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
@Order(2)
public class ch14Aspect1Before {
	
	// public의 리턴타입은 상관 없고 com.mycompany.springframework.controller패키지에서 Ch14Controller 클래스의 before메소드의 매개변수는 상관 안하고 지정
	@Before("execution(public * com.mycompany.springframework.controller.Ch14Controller.before(..))")
	public void method() {
		log.info("전처리 코드 실행");
	}
}
