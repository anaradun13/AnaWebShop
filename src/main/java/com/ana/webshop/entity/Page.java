package com.ana.webshop.entity;

import java.io.Serializable;
import java.util.List;

/**
 * pagination entity
 * 
 * @param <T> generic
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int pageSize = 5;
	private int totalPages;
	private int currentPage;
	private List<T> result;

	public Page() {
	}

	public Page(int totalPages, int currentPage, List<T> result) {
		setTotalPages(totalPages);
		setCurrentPage(currentPage);
		setResult(result);
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}
