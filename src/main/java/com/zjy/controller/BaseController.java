package com.zjy.controller;

/**
 * @author	zhangjunyong
 * email:	junyong62@163.com
 * created: 2013年12月13日
 */
public class BaseController {
	/**
	 * 起始页
	 */
	private int start;
	/**
	 * 每页数据个数,默认每页20个
	 */
	private int limit = 2;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
