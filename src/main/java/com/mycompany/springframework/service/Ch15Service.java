package com.mycompany.springframework.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springframework.dao.mybatis.ch13_AccountDao;
import com.mycompany.springframework.dto.Ch15Account;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch15Service {
	@Autowired
	private ch13_AccountDao accountDao;
	
	public List<Ch15Account> getAccountList(){ // 전체 계좌에 대한 잔고를 보여주는 기능
		List<Ch15Account> accountList = accountDao.selectAll();
		return accountList;
	}
	
	@Transactional // 이 메소드가 실행 될 때 DB에 오류가 난다면 모든 메소드 실행문을 취소 처리 하겠다.
	public void transfer(int fromAno, int toAno, int amount) {
		// 출금 작업
		Ch15Account fromAccount = accountDao.selectByAno(fromAno);
		if(fromAccount == null) {
			throw new RuntimeException("출금 계좌 없음");
		}
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		accountDao.updateBalance(fromAccount);
		
		// 입금 작업
		Ch15Account toAccount = accountDao.selectByAno(toAno);
		if(toAccount == null) {
			throw new RuntimeException("출금 계좌 없음");
		}
		toAccount.setBalance(toAccount.getBalance() + amount);
		accountDao.updateBalance(toAccount);
		
		// 출금잔액이 충분한지에 대한 유효성 검사는 알아서 추가하자
		
	}
}
