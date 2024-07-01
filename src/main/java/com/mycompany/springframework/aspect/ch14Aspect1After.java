package com.mycompany.springframework.aspect;

import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
@Order(1)
public class ch14Aspect1After {
	
	// public의 리턴타입은 상관 없고 com.mycompany.springframework.controller패키지에서 Ch14Controller 클래스의 after메소드의 매개변수는 상관 안하고 지정
	@After("execution(public * com.mycompany.springframework.controller.Ch14Controller.after(..))")
	public void method() {
		log.info("후처리 코드 실행");
	}
}
