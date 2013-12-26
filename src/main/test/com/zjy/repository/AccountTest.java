package com.zjy.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.types.expr.BooleanExpression;
import com.zjy.domain.Account;
import com.zjy.domain.QAccount;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext*.xml")
public class AccountTest {

	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void test() {
		
		BooleanExpression booleanExpression = QAccount.account.username.eq("zjy");
		
		Account account = accountRepository.findOne(booleanExpression);
		
		if(account == null){
			System.out.println("null");
		}else{
			System.out.println("Account: " + account.getUsername() + " : " + account.getPassword());
		}
		
	}

}
