package com.mycompany.springframework.dto;

import lombok.Data;

@Data
public class Ch04LoginForm {
	private String mid; //loginForm.jsp의 form id를 필드에 넣음
	private String mpassword;
}
