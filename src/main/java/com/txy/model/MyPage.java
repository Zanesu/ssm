package com.txy.model;

import java.util.List;

import com.txy.util.Constans;

public class MyPage<T> {
	/**
	 * 页码开始标志
	 */
	private int startPage;
	/**
	 * 页码结束标志
	 */
	private int endPage;
	/**
	 * 页码总数
	 */
	private int totalPage;
	/**
	 * 当前页码
	 */
	private int page = 1;
	private List<T> content;
	/***
	 * 一页内展示的数量
	 */
	private int pagenum = Constans.PAGESIZE;
	/**
	 * 当前展示页，页码展示个数
	 */
	private int pageCount = 8;

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		/**
		 * 设置页码初始至结�?
		 */
		if (totalPage % pagenum == 0) {
			this.totalPage = totalPage / pagenum;
		} else {
			this.totalPage = totalPage / pagenum + 1;

		}

		setEndOrStart();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
		setEndOrStart();
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	/**
	 * 设置页码开始结束，只展示中间8个页码切换按钮
	 */
	private void setEndOrStart() {
		if (this.totalPage == 0) {
			return;
		}
		// 第一种情况，页码不足页码需要展示的个数
		if (totalPage <= pageCount) {
			startPage = 1;
			endPage = totalPage;
			return;
		}
		// 第二种情况，页码在头部，
		if (page <= pageCount / 2) {
			startPage = 1;
			endPage = pageCount;
			return;
		}
		// 第三种情况，页码在尾部
		if ((totalPage - page) < pageCount / 2) {
			endPage = totalPage;
			startPage = totalPage - pageCount+1;
			return;
		}
		// 第三种情况，页码在中间
		startPage = page - pageCount/2+1;
		endPage = page + pageCount/2;
	}

}
