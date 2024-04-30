package com.mycompany.springframework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Component // 객체를 dispatcher안에 생성하게 한다. -> dispatcher component_scan 확인
//@ControllerAdvice
@Slf4j
public class Ch10ExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException() {
		// 예외 처리 내용 작성
		log.info("실행");
		return "ch10/error500_null";
	}
	
	@ExceptionHandler(Ch10CustomException.class)
	public String handleCh10CustomException(Ch10CustomException e, Model model) {
		// 예외 처리 내용 작성
		log.info("실행");
		model.addAttribute("message", e.getMessage());
		return "ch10/error500_custom";
	}
	
	// 위 예외를 제외한 모든 예외를 500번대 예외의 상태로 만들고 예외처리
	@ExceptionHandler(Exception.class) // 모든 예외를 처리
	//@ExceptionHandler(HttpServerErrorException.class) //500번대 예외만 처리
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //500예외를 반환하게 함 (명시하기 위한 장치)
	public String handle500Exception(Exception e) { // 	@ExceptionHandler에 예외 설정 하면 매개변수는 써도 되고 안 써도 된다.
		return "ch10/error500";
	}
	
	// 404 예외 처리(사실 요청매핑된 컨트롤러가 없는 것이라 예외라고 볼 수 없다.)
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)//404
	public String handle404() {
		return "ch10/error404";
	}

}
