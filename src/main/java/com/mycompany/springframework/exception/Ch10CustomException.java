package com.mycompany.springframework.exception;


public class Ch10CustomException extends Exception{ // 비즈니스 로직에 따른 예외 만들기
	public Ch10CustomException() { // 기본 생성자
		
	}
	
	public Ch10CustomException(String message) {// 매개 변수가 있는 생성자 
		super(message); 
		//부모에 문자열 타입의 매개변수를 넣고  해당 객체를 생성하면 에러 메시지를 설정하게 된다.
		// 
	}
}
