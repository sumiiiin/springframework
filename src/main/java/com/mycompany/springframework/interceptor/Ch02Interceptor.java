package com.mycompany.springframework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Ch02Interceptor implements HandlerInterceptor{
// 추상 메소드 없어서 초반에 나는 에러 안남 
	@Override // 전처리 디폴트 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandel() 실행");
		
		// return true: 다음 인터셉터를 실행하거나 Controller의 요청 매핑 메소드가 실행
		// return false: Controller의 요청 매핑 메소드가 실행되지 않음
		return true;
	}
	
	@Override // 후처리
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
				log.info("postHandel() 실행");
		}
	
	@Override //모든 처리가 끝난 후
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			log.info("afterCompletion() 실행");
		}
}
