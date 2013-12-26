package com.zjy.service.questions;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjy.domain.Question;
import com.zjy.repository.QuestionRepository;

/**
 * @author zhangjunyong email: junyong62@163.com created: 2013年12月13日
 */
@Service
public class QuestionService {
	// 问题Repository
	@Autowired
	private QuestionRepository questionRepository;

	
	public Question findById(Long id){
		return questionRepository.findOne(id);
	}
	/**
	 * 保存问题
	 * 
	 * @param question
	 */
	@Transactional
	public void saveQuestioin(Question question) {
		// 设置时间为系统当前时间
		question.setCreateTime(Calendar.getInstance().getTime());
		questionRepository.save(question);
	}
	/**
	 * 分页查询问题
	 * 按时间降序排列，即最新的问题显示在最上边
	 * @param start
	 * @param limit
	 * @return
	 */
	public Page<Question> listQuestions(int start, int limit) {
		Page<Question> page = questionRepository.findAll(new PageRequest(start, limit, new Sort(
				Direction.DESC, "createTime")));
		return page;
	}
}
