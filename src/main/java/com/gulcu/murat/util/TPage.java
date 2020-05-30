package com.gulcu.murat.util;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class TPage<T> {

	private int pageNumber;
	private int pageSize;
	private Sort sort;
	private int totalPages;
	private Long totalElements;
	private List<T> content;

	public void setStat(Page<T> page) {
		this.pageNumber = page.getNumber();
		this.pageSize = page.getSize();
		this.sort = page.getSort();
		this.totalPages = page.getTotalPages();
		this.totalElements = page.getTotalElements();
		this.content = page.getContent();
	}
}
