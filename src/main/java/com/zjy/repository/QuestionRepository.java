package com.zjy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.zjy.domain.Question;
/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013年12月13日
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>,
		QueryDslPredicateExecutor<Question> {

}
