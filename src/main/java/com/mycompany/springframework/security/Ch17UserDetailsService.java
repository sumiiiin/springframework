package com.mycompany.springframework.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.ch13_MemberDao;
import com.mycompany.springframework.dto.Ch17Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // security랑 관련이 있어서 service패키지에 안 만듦
public class Ch17UserDetailsService implements UserDetailsService{
	@Autowired
	private ch13_MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("로그인 인증 실행");
		Ch17Member member = memberDao.selectByMid(username);
		
		// 아이디가 없으면 예외처리 함
		if(member == null) {
			throw new UsernameNotFoundException("해당 아이디가 존재하지 않습니다.");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(member.getMrole()));
		
		UserDetails userDetails = new Ch17UserDetails(member, authorities);
		return userDetails;
	}
}
