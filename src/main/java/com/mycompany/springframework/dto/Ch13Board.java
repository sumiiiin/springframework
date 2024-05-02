package com.mycompany.springframework.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch13Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private Date bdate;
	private String mid;
	private int bhitcount;
	private String battachoname;
	private String battachsname;
	private String battachtype;
	private byte[] battachdata;
	// blob타입은 byte[]배열로 받아도 되고 blob타입으로 받아도 된다.
	
	// 첨부파일을 받을 필드
	private MultipartFile battach; // 이 필드로 받고 조각조각 나눠서 위의 필드에 저장하는 건가?
}
