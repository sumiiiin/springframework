package com.mycompany.springframework.service;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.ch13_BoardDao;
import com.mycompany.springframework.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Service// 관리 객체로 만들어진다.
@Slf4j 
public class Ch13Service {
	@Autowired
	private ch13_BoardDao boardDao; // mybatis가 인터페이스의 구현 객체를 만들고 그 구현객체가 들어옴
	
	public void writeBoard(Ch13Board board) {
		// 비즈니스 로직 처리를 위한 코드...
		int rowNum = boardDao.insert(board); // 1개의 행이 삽입되었습니다의 1값이 리턴 된다.
		log.info("rowNum: " + rowNum+", bno"+ board.getBno());
		
	}
}
