package com.mycompany.springframework.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data //getter setter 만들려고
public class Ch03Dto { // 필드의 이름은 요청url에서 오는 name이랑 같아야 한다.
	private String param1;
	private int param2;
	private double param3;
	private boolean param4;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date param5;
	
}
