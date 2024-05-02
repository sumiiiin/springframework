package com.mycompany.springframework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.ch13_BoardDao;
import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.dto.Ch13Pager;

import lombok.extern.slf4j.Slf4j;

@Service// 관리 객체로 만들어진다.
@Slf4j 
public class Ch13Service {
	@Autowired
	private ch13_BoardDao boardDao; // dao주입, mybatis가 인터페이스의 구현 객체를 만들고 그 구현객체가 들어옴
	
	public void writeBoard(Ch13Board board) {
		// 비즈니스 로직 처리를 위한 코드 있으면 넣어라
		int rowNum = boardDao.insert(board); // 1개의 행이 삽입되었습니다의 1값이 리턴 된다.
		log.info("rowNum: " + rowNum+", bno"+ board.getBno());
	}
	
	public List<Ch13Board> getBoardList(Ch13Pager pager) {
		// 비즈니스 로직 처리를 위한 코드 있으면 넣어라
		List<Ch13Board> boardList = boardDao.selectByPage(pager);
		return boardList;
	}
	
	public int getTotalRows() {
		// 비즈니스 로직 처리를 위한 코드 있으면 넣어라
		int totalRows = boardDao.count();
		return totalRows;
	}

	public Ch13Board getBoard(int bno) {
		Ch13Board board = boardDao.selectByBno(bno);
		return board;
	}


	public byte[] getAttachData(int bno) {
		Ch13Board data = boardDao.selectAttachData(bno);
		return data.getBattachdata();
	}

	public void updateBoard(Ch13Board board) {
		boardDao.update(board); // 1개의 행이 삽입되었습니다의 1값이 리턴 된다.
		
		
	}

	public void removeBoard(int bno) {
		boardDao.deleteByBno(bno);
		
	}
}
