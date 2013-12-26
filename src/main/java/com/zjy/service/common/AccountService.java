package com.zjy.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.types.expr.BooleanExpression;
import com.zjy.domain.Account;
import com.zjy.domain.QAccount;
import com.zjy.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public Account findAccountByUserName(String username){
		
		BooleanExpression expression = QAccount.account.username.eq(username);
		
		return accountRepository.findOne(expression);
//		Account account = new Account();
//		account.setUsername(username);
//		account.setPassword("123456");
//		return account;
		
	}
}
