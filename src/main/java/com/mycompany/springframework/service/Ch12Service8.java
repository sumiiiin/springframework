package com.mycompany.springframework.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.Ch12Dao3;
import com.mycompany.springframework.dao.Ch12Dao4;
import com.mycompany.springframework.dao.Ch12Dao5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch12Service8 {
	// 필드 주입
	//@Autowired // ch12Dao3필드에 자동적으로 관리객체를 주입해줌(관리객체만 된다.)
	@Resource
	private Ch12Dao3 ch12Dao3;
	private Ch12Dao4 ch12Dao4;
	private Ch12Dao5 ch12Dao5;
	
	// 생성자 주입 (이건 resource 안 된다.)
	@Autowired
	public Ch12Service8(Ch12Dao4 ch12Dao4) {
		log.info("실행");
		this.ch12Dao4 = ch12Dao4;
	}
	
	// setter 주입
	@Autowired
	//@Resource
	public void setCh12Dao5(Ch12Dao5 ch12Dao5) {
		log.info("실행");
		this.ch12Dao5 = ch12Dao5;
	}

}
