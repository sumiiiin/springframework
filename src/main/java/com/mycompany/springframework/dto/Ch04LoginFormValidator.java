package com.mycompany.springframework.dto;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04LoginFormValidator implements Validator{

	  @Override
	   public boolean supports(Class<?> clazz) {
	      log.info("supports() 실행");
	      return Ch04LoginForm.class.isAssignableFrom(clazz);
	   }

	   @Override
	   public void validate(Object target, Errors errors) {
	      Ch04LoginForm loginForm = (Ch04LoginForm) target;
	      
	      // 아이디 검사
	      String mid = loginForm.getMid();
	      if(mid == null || mid.equals("")) {
	         errors.rejectValue("mid", "errors.mid.required", "아이디는 반드시 입력되어야 합니다.");
	         // 첫번째 매개변수->dto의 변수, 두번째 매개변수->message의properties파일의 키값, 세번째 매개변수-> 출력할 오류 문자열
	      } else if(mid.length() < 6 || mid.length() > 12) {
	         errors.rejectValue("mid", "errors.mid.length", new String[] {"6","12"}, "아이디는 6자 이상 12자 이하이여야 합니다.");
	      }
	      
	      // 비밀번호 검사
	      String mpassword = loginForm.getMpassword();
	      String pattern = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$/";
	      if(mpassword == null || mpassword.equals("")) {
	         errors.rejectValue("mpassword", "errors.mpassword.required", "비밀번호는 반드시 입력되어야 합니다.");
	      } else if(mpassword.length() < 8 || mpassword.length() > 12) {
	         errors.rejectValue("mpassword", null, "비밀번호는 8자 이상 12자 이하이여야 합니다.");
	      } else if(Pattern.matches(pattern, mpassword)) {
	         errors.rejectValue("mpassword", null, "비밀번호는 알파벳 대소문자 및 숫자를 포함해야 합니다.");
	      }
	   }


}
