package com.mycompany.springframework.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dao.mybatis.ch13_BoardDao;
import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.dto.Ch13Pager;
import com.mycompany.springframework.service.Ch13Service;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;


@Controller
@Slf4j
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource // 서비스 주입
	private Ch13Service service;
	
	@GetMapping("/writeBoardForm")
	public String writeBoardForm() {
		return "ch13/writerBoardForm";
	}
	
	@PostMapping("/writeBoard")
	public String writeBoard(Ch13Board board) {	
		// 요청 데이터의 유효성 검사
		log.info("origiinal filename: " + board.getBattach().getOriginalFilename());
		log.info("filetype: " + board.getBattach().getContentType());
		// battach가 multipart타입이라 뒤에 있는 get 메소드를 사용할 수 있다.
		// 만약 우리가 blob을 사용한다면... 사용을 못 할지도?
		
		// 첨부 파일이 있는지 여부 조사
		if(board.getBattach() != null && !board.getBattach().isEmpty()) {// battach가 null이 아니거나 비어있지 않다면
			//DTO 추가 설정(첨부 파일이 넘어 왔을 경우)
			board.setBattachoname(board.getBattach().getOriginalFilename());
			board.setBattachtype(board.getBattach().getContentType());
			try {
				board.setBattachdata(board.getBattach().getBytes()); // 예외 처리 하라고 나옴
			}catch(Exception e){
				// 비즈니스 로직 때문에 생기는 예외는 아니라서 간단하게 처리 한다.
				// 그럴거면 그냥 떠넘기기 해도 되는거 아냐?
			}
			log.info("첨부파일 있음");
		} else {
			log.info("첨부파일 없음");
		}
		
		
		// 로그인 된 사용자 아이디 설정
		board.setMid("user");
		
		// 로그인이 필요한 지 조사
		
		
		// 비즈니스 로직 처리를 서비스로 위임
		service.writeBoard(board);
		
		return "redirect:/ch13/boardList";
	}
	
	@GetMapping("/boardList")
	public String boardList(String pageNo, Model model, HttpSession session) {// 처음 목록에 들어가면 값이 들어가지 않는데 그럼 매개변수가 없으니까 기본값을 지정한다.
		// pageNo를 받지 못했을 경우, 세션에 저장되어 있는지 확인
		if(pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo == null) {
				// 세션에 저장되어 있지 않을 경우 "1"로 강제 세팅
				pageNo = "1";
			}
		}
		// 세션에 pageNo 저장
		session.setAttribute("pageNo", pageNo);
		
		// 문자열을 정수로 변환
		int intPageNo = Integer.parseInt(pageNo);

		
		// Pager 객체 생성
		int rowsPagingTarget = service.getTotalRows();
		Ch13Pager pager = new Ch13Pager(10,10, rowsPagingTarget, intPageNo); // Pager객체 생성
		
		// Service에서 게시물 목록 요청
		List<Ch13Board> boardList = service.getBoardList(pager); // service에서 가져옴 
		
		// 가져온 객체들을 jsp에 사용할 수 있도록 추가
		model.addAttribute("pager", pager);
		model.addAttribute("boardList", boardList);
		return "ch13/boardList";
	}
	
	@GetMapping("/detailBoard")
	public String detailBoard(int bno, Model model) { // 게시목 보여줄 jsp매핑
		Ch13Board board = service.getBoard(bno); // getBoard라는 메소드가 board객체를 리턴하도록 만들 예정
		model.addAttribute("board", board);
		return "ch13/detailBoard";
	}
	
   // 게시물 첨부파일 보기 메소드
	   @GetMapping("/attachDownload")
	   public void attachDownload(int bno, HttpServletResponse response) throws Exception {
	      //다운로드할 데이터를 준비
	      Ch13Board board= service.getBoard(bno);
	      byte[] data = service.getAttachData(bno);
	      //응답 헤더 구성
	      response.setContentType(board.getBattachtype());
	      String fileName= new String(board.getBattachoname().getBytes("UTF-8"), "ISO-8859-1");
	      
	      response.setHeader("content-disposition", "attachment; fielname=\""+fileName+"\""); 
	      //응답 본문에 파일 데이터 출력
	      OutputStream os = response.getOutputStream();
	      os.write(data);
	      os.flush();
	      os.close();
	   }
	   
	   
	   @GetMapping("/updateBoardForm")
	   public String updateBoardForm(int bno, Model model) {
	      Ch13Board board= service.getBoard(bno);
	      model.addAttribute("board", board);
	      return"ch13/updateBoardForm";
	   }
	   
	   @PostMapping("/updateBoard")
	   public String updateBoard(Ch13Board board) {
			
			// 첨부 파일이 있는지 여부 조사
			if(board.getBattach() != null && !board.getBattach().isEmpty()) {// battach가 null이 아니거나 비어있지 않다면
				//DTO 추가 설정(첨부 파일이 넘어 왔을 경우)
				board.setBattachoname(board.getBattach().getOriginalFilename());
				board.setBattachtype(board.getBattach().getContentType());
				try {
					board.setBattachdata(board.getBattach().getBytes()); // 예외 처리 하라고 나옴
				}catch(Exception e){
					// 비즈니스 로직 때문에 생기는 예외는 아니라서 간단하게 처리 한다.
					// 그럴거면 그냥 떠넘기기 해도 되는거 아냐?
				}
				log.info("첨부파일 있음");
			} else {
				log.info("첨부파일 없음");
			}

			// 비즈니스 로직 처리를 서비스로 위임
			service.updateBoard(board);
			
			return "redirect:/ch13/detailBoard?bno="+board.getBno();
	   }
	   
	   @GetMapping("/deleteBoard")
	   public String deleteBoard(int bno) {
		   service.removeBoard(bno);
		   return "redirect:/ch13/boardList";
	   }
	
	
	
	
	
	
	
	
	
}
