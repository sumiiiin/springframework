package com.mycompany.springframework.dto;

import lombok.Data;

@Data
public class Ch08CartItem {
	private Ch08Product product; // 이미 있는건 또 만들지말고 객체 불러오기
	private int amount;
	
}
