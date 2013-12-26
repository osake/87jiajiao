package com.zjy.controller.common;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zjy.domain.Account;
import com.zjy.service.common.RegisterService;

@Controller
public class RegisterController {
	final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		if(logger.isDebugEnabled()){
			logger.debug("dispatch to /register");
		}
		
		return "register";
	}
	/**
	 * 注册账号提交
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@Valid Account account,BindingResult bindingResult,
			RedirectAttributes redirectAttributes){
		// 待验证Account
		
		if(logger.isDebugEnabled()){
			logger.debug("Account: " + account.toString());
		}
		// 数据校验失败，重新返回注册界面
		if(bindingResult.hasErrors()){
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getFieldError().getDefaultMessage());
			
			return "redirect:/register";
		}
		
		// 通过验证后的账号保存到数据库
		registerService.registerAccount(account);
		
		
		return "redirect:/login";
	}
}
