package com.mycompany.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.ch13_MemberDao;
import com.mycompany.springframework.dto.Ch17Member;

@Service
public class Ch17Service {
	@Autowired
	private ch13_MemberDao memberDao;
	
	public void join(Ch17Member member) {
		// 사용자로 부터 받아온 비밀번호를 암호화 해서 DTO에 저장한다.
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		member.setMpassword(passwordEncoder.encode(member.getMpassword()));
		
		member.setMenabled(true);//회원가입할 때 처음부터 비 활성호 ㅏ되면 안돼??
		memberDao.insert(member);
	}
	
}
