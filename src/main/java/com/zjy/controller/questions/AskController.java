package com.zjy.controller.questions;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zjy.domain.Question;
import com.zjy.service.questions.QuestionService;

/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013年12月12日
 */
@Controller
@Scope("request")
@RequestMapping("/questions/*")
public class AskController {
	static final Logger logger = LoggerFactory.getLogger(AskController.class);
	
	/**
	 * 问题服务
	 */
	@Autowired
	private QuestionService questionService;
	/**
	 * 跳转到提问页面
	 * @return
	 */
	@RequestMapping(value="ask",method=RequestMethod.GET)
	public String ask(){
		return "ask";
	}
	
	/**
	 * 提问
	 * @return
	 */
	@RequestMapping(value="ask",method=RequestMethod.POST)
	public String ask(@Valid Question question,BindingResult bindingResult,
			RedirectAttributes redirectAttributes){
		if(logger.isDebugEnabled()){
			logger.debug("提问: " + question.toString());
		}
		// 数据校验失败，重新返回注册界面
		if(bindingResult.hasErrors()){
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getFieldError().getDefaultMessage());
			
			return "redirect:/questions/ask";
		}
		
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.getPrincipal();
		
		// 保存到数据库
		questionService.saveQuestioin(question);
		
		return "redirect:/";
	}
}
