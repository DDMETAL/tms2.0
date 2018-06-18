package com.dmetal.tms.common.web;

import java.io.Serializable;

/** 借助此对象封装分页信息
 * 当前页
 * 记录页
 * 页数(总页数)
 * .....
 */
public class PageObject implements Serializable{
	private static final long serialVersionUID = 1L;
	/**当前页*/
	private int pageCurrent=1;
	/**记录数(表中有多少条记录)*/
	private int rowCount;
	/**总页数*/
	private int pageCount;
	/**每页要显示的记录数*/
	private int pageSize=3;
	/**取下页数据的起始记录*/
	private int pageIndex;
	
	/**返回总页数*/
	public int getPageCount() {
		//在此方法中通过rowCount,pageSize计算总页数
		int pages=rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pages+=1;
		}
		return pages;
	}
	
	/**根据当前页计算当前页记录的开始位置*/
	public int getPageIndex() {
		return (pageCurrent-1)*pageSize;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
}
