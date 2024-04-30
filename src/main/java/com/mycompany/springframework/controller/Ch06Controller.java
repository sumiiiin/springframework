package com.mycompany.springframework.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch06Cart;
import com.mycompany.springframework.dto.Ch06Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	@GetMapping("/forward")
	public String forward(Model model, HttpServletRequest request) {
		// 데이터 생성
		Ch06Member member = new Ch06Member();
		member.setMid("spring");
		member.setMname("김벚꽃");
		member.setMemail("kim@naver.com");
		
		// request 범위에 객체 저장-----------
		//(forward할 때 까지 계속 사용할 수 있는 범위)
		// 응답이 전송되면 request범위는 사라짐
		//-----------------------------
		model.addAttribute("member1",member);        
		request.setAttribute("member2", member);
		//이 두 코드는 같은 역할을 한다. 이 두 요소는 HttpServletRequest에 저장이 되기 때문에 클라이언트에 도착하면 사라진다.
		
		model.addAttribute("chNum","ch06");
		return "ch06/forward"; //jsp로 이동하는거 forward
	}
	
	@GetMapping("/redirect") // 여기서 데이터 생성해서 sessionData에서 사용하고 싶어
	public String redirect(Model model, HttpSession session) {
		log.info("실행");
		//model.addAttribute("왕","왕"); 근데 이 데이터는 클라이언트에 도착하면 사라져서 session으로 리다이렉트 되면 사라져
		
		//데이터 생성
		List<String> items = new ArrayList<>();
		items.add("상품1");
		items.add("상품2");
		items.add("상품3");
		
		// 카트 객체 생성
		Ch06Cart cart = new Ch06Cart();
		cart.setItems(items);
		
		// session 범위에 객체를 저장
		// 동일한 Client(브라우저)가 사용할 수 있는 범위
		session.setAttribute("cart", cart);
		return "redirect:/ch06/sessionData";
	} 
	
	@GetMapping("/sessionData")
	public String sessionData(HttpSession session, Model model) {
		log.info("실행");
		
		// 세션 범위에 저장 된 객체 가져오기(강제 타입변환 해야해...오ㅐ?)
		Ch06Cart cart = (Ch06Cart) session.getAttribute("cart");
		if(cart != null) {
			for(String item : cart.getItems()) { //cart가 null일 경우에 오류
				log.info(item);
			}
		}
		model.addAttribute("chNum","ch06");
		
		return "ch06/sessionData";
	}

}
