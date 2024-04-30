package com.mycompany.springframework.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.Ch12DaoInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch12Service9 {
	// 필드 주입
	@Autowired @Qualifier("ch12Dao6") // ch12Dao3필드에 자동적으로 관리객체를 주입해줌(관리객체만 된다.)
	private Ch12DaoInterface field1; // 인터페이스에는 구현객체가 대입될 수 있다. 근데 구현객체가 2개라서 에러가 난다(같은 타입이라서). 그래서 이름으로 지정해서 주입한다.
	
	@Resource(name="ch12Dao7") // 리소스의 경우 이름을 속성 값으로 넣는다.
	private Ch12DaoInterface field2;

	// 생성자 주입
	@Autowired 
	public Ch12Service9(@Qualifier("ch12Dao6")Ch12DaoInterface filed1) {
		
	}
	
	// setter 주입
	@Resource(name="ch12Dao7")
	public void setField2(Ch12DaoInterface field2) {
		this.field2 = field2;
	}
	
	

}
