package com.mycompany.springframework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Ch02Authinterceptor implements HandlerInterceptor{
// 추상 메소드 없어서 초반에 나는 에러 안남 
	@Override // 전처리 디폴트 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandel() 실행");
		
		// 요청 매핑 메소드에 @Auth가 붙어있는지 조사(핸들러 메소드는 컨트롤러에 있는 메소드를 뜻 함)
		
		// 요청 매핑 메소드 참조 객체
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		// 요청 매핑 메소드에 @Auth가 붙어있지 않다면 null
		// 요청 매핑 메소드에 @Auth가 붙어 있다면 not null
		
		if(auth == null) {
			// 로그인이 필요없는 경우 -> 요청 매핑 메소드를 실행
			return true; // 무조건 true반환
		} else {
			// 로그인이 필요한 경우
			// 로그인 검사
			boolean loginStatus = true;
			if(loginStatus) {
				// 요청 매핑 메소드를 실행
				return true;
			} else {
				// 홈으로 강제 이동
				response.sendRedirect(request.getContextPath());
				// 그냥 "/"을 경로로 주면 localhost:8080까지만 됨 그래서 context경로 추가해야 함
				
				// 요청 매핑 메소드를 실행하지 않음
				return false;
			}
		}

	}

}
