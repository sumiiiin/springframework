package com.mycompany.springframework.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.springframework.dto.Ch17Member;

@Mapper // mapper의 클래스 이름이 import뒤에 붙는 것들이다.
// member.xml과 매핑되어 있다.
public interface ch13_MemberDao {
	public Ch17Member selectByMid(String username);

	public int insert(Ch17Member member);	// 실제 반영된 행수가 리턴되도록 타입을 int로 함
}
