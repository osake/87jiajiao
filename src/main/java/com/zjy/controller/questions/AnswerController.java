package com.zjy.controller.questions;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjy.domain.Answer;
import com.zjy.domain.Question;
import com.zjy.service.questions.AnswerService;
import com.zjy.service.questions.QuestionService;

/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013年12月13日
 */
@Controller
@Scope("request")
@RequestMapping("/questions/*")
public class AnswerController{
	static final Logger logger = LoggerFactory.getLogger(AnswerController.class);
	/**
	 * 问题服务
	 */
	@Autowired
	private QuestionService questionService;
	/**
	 * 答案服务
	 */
	@Autowired
	private AnswerService answerService;
	
	/**
	 * 跳转到答案页面
	 * @return
	 */
	@RequestMapping(value="answers/{id}",method=RequestMethod.GET)
	public String answers(@PathVariable(value="id") Long id,ModelMap model){
		
		Question question = questionService.findById(id);
		model.addAttribute("question", question);
		return "answers";
	}
	
	/**
	 * 查询结果
	 * @return
	 */
	@RequestMapping(value="answer",method=RequestMethod.POST)
	public String listAnswers(Long id,@Valid Answer answer,ModelMap model){
		
		if(logger.isDebugEnabled()){
			logger.debug("Answer to question("+ id +") is : " + answer.toString());
		}
		Question question = questionService.findById(id);
		answer.setQuestion(question);
		answerService.saveAnswer(answer);
		
		return "redirect:/questions/answers/" + id;
	}
}
