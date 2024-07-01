package com.mycompany.springframework.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
@Order(1)
public class ch14Aspect1Before2 {
	
	// public의 리턴타입은 상관 없고
	@Before("execution(public * com.mycompany.springframework.controller.Ch14Controller.before(..))")
	public void method() {
		log.info("전처리 코드 실행");
	}
}
