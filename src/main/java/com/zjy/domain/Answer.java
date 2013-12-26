package com.zjy.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013年12月13日
 */
@Entity
@Table(name = "Answer")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	/**
	 * 答案内容
	 */
	@Column(name = "content")
	private String content;
	
	/**
	 * 支持数
	 */
	@Column(name="support")
	private Long support;
	
	/**
	 * 反对数
	 */
	@Column(name="opposition")
	private Long opposition;
	
	/**
	 * 答案创建时间
	 */
	@DateTimeFormat(style="M-")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createTime")
	private Date createTime;
	
	/**
	 * 对应问题
	 */
	@ManyToOne
	private Question question;
	
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

	public Long getSupport() {
		return support;
	}

	public void setSupport(Long support) {
		this.support = support;
	}

	public Long getOpposition() {
		return opposition;
	}

	public void setOpposition(Long opposition) {
		this.opposition = opposition;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
