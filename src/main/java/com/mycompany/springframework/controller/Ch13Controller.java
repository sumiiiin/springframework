package com.mycompany.springframework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.service.Ch13Service;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource // 서비스 주입
	private Ch13Service service;
	
	@GetMapping("/writeBoardForm")
	public String writeBoardForm() {
		return "ch13/writerBoardForm";
	}
	
	@PostMapping("/writeBoard")
	public String writeBoard(Ch13Board board) {	
		// 요청 데이터의 유효성 검사
		// 로그인이 필요한 지 조사
		board.setMid("user");
		// 비즈니스 로직 처리를 서비스로 위임
		service.writeBoard(board);
		
		return "redirect:/";
	}
}
