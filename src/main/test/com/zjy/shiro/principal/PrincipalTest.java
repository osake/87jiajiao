package com.zjy.shiro.principal;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:META-INF/spring/applicationContext.xml"})
public class PrincipalTest {
	static final Logger logger = LoggerFactory.getLogger(PrincipalTest.class);

	@Test
	public void testLogin() {
		// 1. Build the Subject instance for the test to run:
		Subject subject = SecurityUtils.getSubject();

		if (subject != null) {
			logger.info("not null");
		}
	}

}
