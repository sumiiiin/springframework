package com.mycompany.springframework.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
/*	@GetMapping("/header")
	public String header(Model model, 
			@RequestHeader("User-Agent") String userAgent) {
			// User-Agent의 값을 userAgent에 담는다.
		log.info("실행");
		log.info("userAgent: " + userAgent);
		
		if(userAgent.contains("Edg")) {
			model.addAttribute("browser", "Edge");
		} else {
			model.addAttribute("browser","chrome");
		}
		
		model.addAttribute("chNum","ch05");
		return "ch05/header";
	}*/
	
	@GetMapping("/header")
	public String header(Model model, 
			HttpServletRequest request) {
			// 요청 관련 모든 정보는 저 객체에 있다.
		log.info("실행");
		log.info("userAgent: " + request.getHeader("User-Agent"));
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Edg")) {
			model.addAttribute("browser", "Edge");
		} else {
			model.addAttribute("browser","chrome");
		}
		
		// 브라우저가 실행하는 컴퓨터의 IP주소
		String clientIp = request.getRemoteAddr();
		model.addAttribute("clientIp",clientIp);
		
		model.addAttribute("chNum","ch05");
		return "ch05/header";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(Model model, HttpServletResponse response) {
		// 쿠키 생성(서버에서 생성)
		Cookie cookie = new Cookie("useremail", "summer@naver.com");
		
		// 생성한 쿠키를 응답 HTTP에 포함시키기
		response.addCookie(cookie); // 브라우저 메모리에 저장되게 된다.
		
		model.addAttribute("chNum","ch05");
		return "redirect:/";
	}
	
	@GetMapping("/readCookie")
	public String readCookie(Model model, @CookieValue("useremail") String userEmail) {// 쿠키이릉이랑 변수이름이랑 같으면 @CookieValue로 매핑 안해도 된다.
		log.info("useremail: " + userEmail);
		model.addAttribute("userEmail",userEmail);
		model.addAttribute("chNum","ch05"); // redirect 할 때는 필요 없음
		return "ch05/cookie";
	}

}

