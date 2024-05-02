package com.mycompany.springframework.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.dto.Ch13Pager;

@Mapper
public interface ch13_BoardDao {
	public int insert(Ch13Board board);// 추상메소드 public생략해도 public이래 왜?
	public int count(); //xml의 아이디 값을 메소드 이름으로 사용, 태그 하나마다 메소드 다 만들어야 해 딱히 매개변수는 없음
	public List<Ch13Board> selectByPage(Ch13Pager pager); // 객체 여러개 받아야 해서 list로 받는다.
	public Ch13Board selectByBno(int bno);
	public Ch13Board selectAttachData(int bno);
	public int update(Ch13Board board);
	public int deleteByBno(int bno); // 왠만하면 int로 둬라 삭제된 행 수 ..이런거 받으려고?
}
