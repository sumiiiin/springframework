package com.mycompany.springframework.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.mycompany.springframework.dto.Ch17Member;

public class Ch17UserDetails extends User{
	//userdetails인터페이스를 구현하다가 오버라이딩 할 추상매소드가 많이 나와서 이미 이걸 구현한 User라는 클래스를 상속 받음. 그럼 Ch17User도 userdetails를 구현한 구현객체가 된다.
//	public Ch17UserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
//			boolean credentialsNonExpired, boolean accountNonLocked,
//			Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//		// TODO Auto-generated constructor stub
//	}
	// 기본적으로 부모 생성자를 호출해야 한다....
	

	private Ch17Member member;
	
	public Ch17UserDetails(Ch17Member member, List<GrantedAuthority> authorities) {
		super(member.getMid(), member.getMpassword(), member.isMenabled(), true, true, true, authorities);
		// 스프링 시큐리티는 기본적으로 사용자가 여러개의 권한을 가질 수 있다고 생각한다. 그래서 권한이 여러개면 List<GrantedAuthority>에 담아서 매개변수에 넣어야 한다.
		this.member = member;

	}
	
	
	public Ch17Member getMember() {
		return member;
	}
	
	

	
	
}
