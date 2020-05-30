package com.gulcu.murat.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.gulcu.murat.entities.Book;
import com.gulcu.murat.util.TPage;

public interface BookService {

	Page<Book> findAll(Pageable  pageable);
	Slice<Book> findAllSlice(Pageable pageable);
	TPage<Book> customPagination (Pageable pageable);
	Page<Book> findAll(Integer currentPage,Integer pageSize);
	Book save(Book book);
}
