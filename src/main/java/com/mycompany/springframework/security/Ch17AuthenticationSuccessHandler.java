package com.mycompany.springframework.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Component// 이 클래스가 관리객체가 된다. 이름은 클래스 이름에서 앞에 글자가 소문자가 된다. security.xml에서 사용할 예정 -> root파일이라 사용 안된다. 
@Slf4j
public class Ch17AuthenticationSuccessHandler
	 // 로그인 성공 후에 사용자가 접근하고자 했던 페이지로 이동
	 // extends SavedRequestAwareAuthenticationSuccessHandler{

		//로그인 성공 후에 무조건 defaultTargetUrl로 이동
		extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		log.info("로그인 인증 성공 시 실행");
		
		// 로그인 성공 후에 이동할 Url (방법1)
		setDefaultTargetUrl("/"); //simple url 사용했을 때 사용
		
		// 기본 설정을 적용하기 위해 상위(부모) 메소드 호출
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
