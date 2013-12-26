package com.zjy.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjy.domain.Account;
import com.zjy.repository.AccountRepository;

@Service
public class RegisterService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
	public void registerAccount(Account account){
		accountRepository.save(account);
	}
}
