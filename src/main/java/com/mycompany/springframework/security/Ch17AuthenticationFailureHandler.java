package com.mycompany.springframework.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Ch17AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	
	@Override
		public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException exception) throws IOException, ServletException {
			log.info("로그인 인증 실패 시 실행");
			
			//로그인 실패 후 리다이렉트로 이동할 경로(기본값을 사용한다면 아래의 부모 메소드 호출해서 사용해도 된다.)
			setDefaultFailureUrl("/ch17/loginForm");// 주석해도 되고 안해도 된다.
			
			//기타 기본 설정을 적용하기 위해 상위 메소드 호출
			super.onAuthenticationFailure(request, response, exception);
		}
}
