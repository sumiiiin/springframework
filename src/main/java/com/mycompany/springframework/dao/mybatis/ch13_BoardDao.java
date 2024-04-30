package com.mycompany.springframework.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;
import com.mycompany.springframework.dto.Ch13Board;

@Mapper
public interface ch13_BoardDao {
	public int insert(Ch13Board board);// 추상메소드 public생략해도 public이래 왜?
}
