package com.mycompany.springframework.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.exception.Ch10CustomException;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch10")
public class Ch10Controller { // 요청 경로에 예외처리 ->요청경로마다 만들긴 싫어 ->
	@GetMapping("/handlingException1")
	public String handlingException1(String data, Model model) {
		model.addAttribute("chNum", "ch10");
		try {
			if(data.equals("java")) {
				//NullPointException 발생
			}
		} catch(NullPointerException e){
			log.info("data가 넘어오지 않았습니다.");
			return "ch10/error500_null";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/handlingException2") //@ExceptionHandler 이용
	public String handlingException2(String data, Model model) {
		model.addAttribute("chNum", "ch10"); // 이거 적용이 안된다...
		if(data.equals("java")) {
			//NullPointException 발생
		}
			
		return "redirect:/";
	}
	
	@GetMapping("/handlingException3") //@ExceptionHandler 이용
	public String handlingException3(String data) throws Ch10CustomException {
		if(true) {
			throw new Ch10CustomException("사용자가 지정한 어떤 이유 때문에 예외 발생 함"); // 예외 발생시키기
		}
			
		return "redirect:/";
	}
	
	@GetMapping("/handlingException4") //@ExceptionHandler 이용
	public String handlingException4(String data) throws RuntimeException {
		
		if(true) {
			throw new RuntimeException("입촐력");
		}
			
		return "redirect:/";
	}

}
