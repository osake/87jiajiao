package com.zjy.service.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjy.domain.Answer;
import com.zjy.repository.AnswerRepository;

/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013-12-15
 */
@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	
	/**
	 * 保存答案
	 * @param answer
	 */
	@Transactional
	public void saveAnswer(Answer answer){
		answerRepository.save(answer);
	}
}
