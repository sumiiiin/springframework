package com.mycompany.springframework.dto;

import java.util.Date;

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
	private byte[] battachdate;
	// blob타입은 byte[]배열로 받아도 되고 blob타입으로 받아도 된다.
}
