package com.mycompany.springframework.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springframework.dto.Ch09FileUploadForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	@GetMapping("/fileUploadForm")
	public String fileUploadForm(Model model) {
		model.addAttribute("chNum","ch09");
		return "ch09/fileUploadForm";
	}
	
/*	@PostMapping("/fielUpLoad")
	public String fileUpload(String title, String desc, MultipartFile attach) throws IllegalStateException, IOException {
		log.info("제목: "+title);
		log.info("설명: "+desc);

		// 파일의 정보 얻기
		log.info("(사용자가 선택 한)원래 파일 이름: " + attach.getOriginalFilename());
		log.info("파일의 종류: " + attach.getContentType());
		log.info("파일의 크기: "+ attach.getSize());
		
		// 영구적 파일로 저장
		File destDir = new File("C:/Temp/uploadFiles");
		if(!destDir.exists()) destDir.mkdirs(); // 템프에 uploadFiles폴더가 없으면 만들어
		
		// 유일할 파일 이름을 만들기 위한 날짜 집어넣기
		File destFile = new File(destDir, new Date().getTime()+"-"+attach.getOriginalFilename());
		
		attach.transferTo(destFile);
		
		return "redirect:/ch09/fileUploadForm";
	}*/
	
	@PostMapping("/fielUpLoad")
	public String fileUpload(Ch09FileUploadForm form) throws IllegalStateException, IOException {
		log.info("제목: "+form.getTitle());
		log.info("설명: "+form.getDesc());

		// 파일의 정보 얻기
		log.info("(사용자가 선택 한)원래 파일 이름: " + form.getAttach().getOriginalFilename());
		log.info("파일의 종류: " + form.getAttach().getContentType());
		log.info("파일의 크기: "+ form.getAttach().getSize());
		
		// 영구적 파일로 저장
		File destDir = new File("C:/Temp/uploadFiles");
		if(!destDir.exists()) destDir.mkdirs(); // 템프에 uploadFiles폴더가 없으면 만들어
		
		// 유일할 파일 이름을 만들기 위한 날짜 집어넣기
		File destFile = new File(destDir, new Date().getTime()+"-"+form.getAttach().getOriginalFilename());
		
		form.getAttach().transferTo(destFile);
		
		return "redirect:/ch09/fileUploadForm";
	}
	
	   @PostMapping(value="/fileUploadAjax", produces="application/json; charset=UTF-8")
	   @ResponseBody
	   public String fileUploadAjax(Ch09FileUploadForm form) throws IOException {
	      log.info("제목: " + form.getTitle());
	      log.info("설명: " + form.getDesc());
	      //파일의 정보 얻기
	      log.info("사용자가 선택한 파일 이름: " + form.getAttach().getOriginalFilename());
	      log.info("파일의 종류: " + form.getAttach().getContentType());
	      log.info("파일의 크기: " + form.getAttach().getSize());
	      //영구적 파일로 저장
	      File destDir = new File("C:/Temp/uploadFiles");
	      if(!destDir.exists()) destDir.mkdirs();
	      String fileName = new Date().getTime()+"-"+ form.getAttach().getOriginalFilename();
	      File destFile = new File(destDir, fileName);
	      form.getAttach().transferTo(destFile);
	      //JSON 응답 생성
	      JSONObject jsonObject = new JSONObject();
	      jsonObject.put("result", "success");
	      jsonObject.put("originalFileName", form.getAttach().getOriginalFilename());
	      jsonObject.put("savedFileName", fileName);
	      return jsonObject.toString();
	   }
	   
	   @GetMapping("/downloadFileList")
	   public String downloadFileList(Model model) {
		   File destDir = new File("C:/Temp/uploadFiles");
		   String[] fileNames = destDir.list();// 디렉토리에 있는 파일의 이름을 전부 배열로 리턴
		   model.addAttribute("fileNames", fileNames);
		   model.addAttribute("chNum", "ch09");
		   
		   return "ch09/downloadFileList";
	   }
	   
/*	   @GetMapping("/downloadFile")
	   public void downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		   String filePath = "C:/Temp/uploadFiles/" + fileName;
		   String fileType = request.getServletContext().getMimeType(fileName); //image/jpeg

		   // 한글로 되어 있는 파일 이름 => ISO-8859-1 문자 셋으로 구성된 파일 이름으로 변환해야 함
		   fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		   
		   // 응답 헤더에 저장 할 내용
		   response.setContentType(fileType);
		   response.setHeader("Content-Disposition", "attachment; filename=\"fileName\"" + fileName + "\""); // fileName은 위의 변수이다.
		   
		   // 응답 본문에 파일 데이터 출력
		   OutputStream os = response.getOutputStream();
		   Path path = Paths.get(filePath);
		   Files.copy(path, os);
		   os.flush();
		   os.close();
	   }*/
	   // 교수님 코드 내꺼랑 비교하기
	   @GetMapping("/downloadFile")
	   public void downloadFile(String fileName, 
	         HttpServletRequest request, HttpServletResponse response) throws Exception {
	      String filePath = "C:/Temp/uploadFiles/" + fileName; // DB안배워서 temp사용하는건데 나중엔 안함
	      String fileType = request.getServletContext().getMimeType(fileName); //image/jpeg
	      //한글로 되어 있는 파일 이름 => ISO-8859-1 문자셋으로 구성된 파일 이름
	      fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
	      
	      //응답 헤더에 저장할 내용
	      response.setContentType(fileType);
	      response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); // 이 코드가 없으면 다운이 아니라 파일이 열린다.
	      
	      //응답 본문에 파일 데이터 출력
	      OutputStream os = response.getOutputStream();
	      Path path = Paths.get(filePath);
	      Files.copy(path, os);
	      os.flush();
	      os.close();
	   }

}
