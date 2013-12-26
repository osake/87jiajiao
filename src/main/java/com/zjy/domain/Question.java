package com.zjy.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013年12月12日
 */
/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013-12-15
 */
@Entity
@Table(name = "Question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	/**
	 * 问题内容
	 */
	@Column(name = "content")
	private String content;
	
	/**
	 * 提问时间
	 */
	@DateTimeFormat(style="M-")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createTime")
	private Date createTime;

	/**
	 * 答案列表
	 */
	@OneToMany(cascade=CascadeType.ALL,mappedBy="question")
	private List<Answer> answerList;
	
	/**
	 * 作者账号信息
	 */
	@ManyToOne
	private Account account;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
