package com.zjy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zjy.domain.Question;
import com.zjy.service.questions.QuestionService;

/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013-12-14
 */
@Controller
public class IndexController{
	static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	/**
	 * 问题服务
	 */
	@Autowired
	private QuestionService questionService;
	/**
	 * 默认项目首页
	 * @param model
	 * @return
	 */
	/**
	 * 每页20条记录
	 */
	private int limit = 2;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(@RequestParam(value="start",required=false) Integer start,ModelMap model){
		// 系统首页，没有传递参数时，默认为0
		if(start == null || start < 0){
			start = 0;
		}
		if(logger.isDebugEnabled()){
			logger.debug("visit / with start: " + start + " and limit :" + limit);
		}
		Page<Question> page = questionService.listQuestions(start, limit);
		
		if(logger.isDebugEnabled()){
			logger.debug("Total Count:" + page.getTotalPages());
		}
		model.addAttribute("page", page);
		
		return "index";
	}
}
