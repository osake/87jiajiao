package com.zjy.controller.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjy.domain.Account;

@Controller
public class LoginController {
	final Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	/**
	 * 登录操作
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Account account){
		
		boolean hasError = false;
		
		if(logger.isDebugEnabled()){
			logger.debug("User : " + account.getUsername() + " try to login with password: " + account.getPassword());
		}
		
		
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(account.getUsername(), account.getPassword());
		
		try{
			currentUser.login(token);
		}catch (UnknownAccountException uae ) {
		    //username wasn't in the system, show them an error message?
			hasError = true;
			logger.warn("没有该账号！");
		} catch (IncorrectCredentialsException ice ) {
		    //password didn't match, try again?
			hasError = true;
			logger.warn("密码不匹配");
		} catch (LockedAccountException lae ) {
		    //account for that username is locked - can't login.  Show them a message?
			hasError = true;
			logger.warn("账号已被锁定");
		}catch (AuthenticationException ae ) {
		    //unexpected condition - error?
			hasError = true;
			logger.warn("其它认证错误");
		}
		if(hasError){
			// 登录认证出错，返回登陆页面
			return "redirect:/login";	
		}else{
			return "redirect:/";
		}
	}
	@RequestMapping("/logout")
	public String logout(){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "redirect:/";
	}
}
