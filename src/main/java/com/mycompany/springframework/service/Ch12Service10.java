package com.mycompany.springframework.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.Ch12DaoInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch12Service10 {
	@Value("${prop1}") private int field1;
	@Value("${prop2}") private double field2;
	@Value("${prop3}")private boolean field3;
	private String field4;
	
	//@Value("${prop1}") 생성자 주입은 안된다.(오류남)
	// 근데 매개변수에 주입을 해서 넣으면 되나?? 에러는 일단 안나는데 -> 주입이 안된다.
/*	public Ch12Service10(@Value("${prop3}")boolean filed3) {
		this.field3 = field3;
	}*/
	
	@Value("${prop4}")
	public void setField4(String field4) {
		log.info("field1: "+field1);
		log.info("field2: "+field2);
		log.info("field3: "+field3); // 매개변수에 주입해서 출력하니 false가 뜬다. 기본 초기화 값이 나오는 건가?
		log.info("field4: "+field4);
		this.field4 = field4;
	}
	
	
	

}
