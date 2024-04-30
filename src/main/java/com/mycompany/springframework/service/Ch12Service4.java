package com.mycompany.springframework.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("service4") // 명시적으로 준 이름으로 관리
public class Ch12Service4 {
	public Ch12Service4() { // 매개변수가 있는 생성자는 안된다. 
		// 어노테이션을 통해 만드는 생성자는 기본생성자만 사용하기 때문에 오버라이딩은 되지만 사실상 의미가 없다.
		log.info("실행"); // 객체가 생성되었는지 확인
	}


}
