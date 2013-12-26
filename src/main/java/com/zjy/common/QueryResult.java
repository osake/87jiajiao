package com.zjy.common;

import java.util.List;

/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013年12月13日
 */
public class QueryResult<T> {
	/**
	 * 查询结果列表
	 */
	private List<T> result;
	
	/**
	 * 查询总数
	 */
	private Long totalCount;

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
}
