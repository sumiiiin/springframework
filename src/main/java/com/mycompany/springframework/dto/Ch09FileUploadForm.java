package com.mycompany.springframework.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch09FileUploadForm {
	private String title;
	private String desc;
	private MultipartFile attach;
	// 필드 이름은 jsp에서 가져오는 데이터의 이름과 같아야 한다.
	
}
