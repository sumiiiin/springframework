package com.mycompany.springframework.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch04LoginForm;
import com.mycompany.springframework.dto.Ch04LoginFormValidator;
import com.mycompany.springframework.dto.Ch04SignUpForm;
import com.mycompany.springframework.dto.Ch04SignUpFormValidator;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch04")
public class Ch04Controller {
	 @GetMapping("/loginForm")
	   public String loginForm(Model model) {
	      model.addAttribute("chNum", "ch04");
	      return "ch04/loginForm";
	   }
	   
	   @InitBinder("ch04LoginForm")
	   public void ch04loginFormValidator(WebDataBinder binder) {
	      binder.setValidator(new Ch04LoginFormValidator());
	   }
	   
	   // 중요!
	   @RequestMapping("/login")
	   public String login(@Valid Ch04LoginForm loginForm, Errors errors, Model model) {
	      // 유효성 검사 실패 시 다시 로그인 폼 보여주기
	      if(errors.hasErrors()) {
	         model.addAttribute("chNum", "ch04");
	         log.info("오류");
	         return "ch04/loginForm"; // 왜 loginForm메소드로 넘겨주지 않는가?
	      }
	      
	      // 로그인 처리
	      return "redirect:/"; // (:/) --> 이 부분 주소가 어떻게 입력해야하는지는 사용해보아야 한다. 
	   }
	   
	   @RequestMapping("/signUpForm")
	   public String signUpForm(Model model) {
		   model.addAttribute("chNum","ch04");
		   return "ch04/signUpForm";
		   
	   }
	   
	   @InitBinder("ch04SignUpForm") // dto에 검사기 연결하기?
	   public void ch04SignUpFormValidator(WebDataBinder binder) {
	      binder.setValidator(new Ch04SignUpFormValidator());
	   }
	   
	   // 중요!
	   @RequestMapping("/signUp")
	   public String signUp(@Valid Ch04SignUpForm signUpForm, Errors errors, Model model) {
	      // 유효성 검사 실패 시 다시 로그인 폼 보여주기
	      if(errors.hasErrors()) {
	         model.addAttribute("chNum", "ch04");
	         return "ch04/signUpForm"; // 왜 loginForm메소드로 넘겨주지 않는가?
	      }
	      
	      // 로그인 처리
	      return "redirect:/"; // (:/) --> 이 부분 주소가 어떻게 입력해야하는지는 사용해보아야 한다. 
	   }


}
