package com.mycompany.springframework.dto;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Ch04SignUpFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		log.info("supports() 실행");
		return Ch04SignUpForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Ch04SignUpForm signUpForm = (Ch04SignUpForm) target;
		
		// 아이디 검사
		String id = signUpForm.getMid();
		if(id == null || id.equals("")) {
			 log.info("검사기 실행");
	         errors.rejectValue("mid", null, "아이디는 반드시 입력되어야 합니다.");
	      } else if(id.length() < 6 || id.length() > 12) {
	         errors.rejectValue("mid", null, "아이디는 6자 이상 12자 이하이여야 합니다.");
	      }
		
		// 비밀번호 검사
		String password = signUpForm.getMpassword();
		String pattern_password = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}";
		if(password == null || password.equals("")) {
			errors.rejectValue("mpassword", null, "비밀번호는 반드시 입력되어야 합니다.");
		} else if(password.length() < 8 || password.length() > 12) {
			errors.rejectValue("mpassword", null, "비밀번호는 8자 이상 12자 이하이여야 합니다.");
		} else if(!Pattern.matches(pattern_password, password)) {
			errors.rejectValue("mpassword", null, "비밀번호는 알파벳 대소문자 및 숫자를 포함해야 합니다.");
		}
		
		// 이름 검사
		String name = signUpForm.getMname();
		if(name == null || name.equals("")) {
			errors.rejectValue("mname", null, "이름은 반드시 입력되어야 합니다.");
		} else if(name.length() < 3 || name.length() > 11) {
			errors.rejectValue("mname", null, "이름은 2자 이상 10자 이하이여야 합니다.");
		}
		// 이메일 검사
		String email = signUpForm.getMemail();
		String pattern_email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		if(email == null || email.equals("")) {
			errors.rejectValue("memail", null, "이메일은 반드시 입력되어야 합니다.");
		} else if(!Pattern.matches(pattern_email, email)) {
			errors.rejectValue("memail", null, "올바른 이메일을 작성해 주세요");
		}
		
		// 전화번호 검사
		String phone = signUpForm.getMphone();
		String pattern_phone = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}";
		if(phone == null || phone.equals("")) {
			errors.rejectValue("mphone", null, "휴대폰 번호는 반드시 입력되어야 합니다.");
		} else if(!Pattern.matches(pattern_phone, phone)) {
			errors.rejectValue("mphone", null, "올바르게 입력해주세요 하이픈도 입력해주셔야 합니다. ");
		}
	}

}
