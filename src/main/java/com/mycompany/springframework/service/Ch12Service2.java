package com.mycompany.springframework.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12Service2 {
	private Ch12Service2(){}
		// 외부에서 객체 생성 못함 스프링도 결국엔 외부이기 때문에 안됨
		
	
	
	public static Ch12Service2 getInstance() {
		log.info("실행");
		return new Ch12Service2();
	}

}
