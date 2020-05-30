package com.gulcu.murat.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.gulcu.murat.dao.BookRepository;
import com.gulcu.murat.entities.Book;
import com.gulcu.murat.service.BookService;
import com.gulcu.murat.util.TPage;

@Service
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Page<Book> findAll(Integer currentPage,Integer pageSize) {
		Pageable pageable = PageRequest.of(currentPage, pageSize);
		return bookRepository.findAll(pageable);
	}

	@Override
	public Book save(Book book) {		
		return bookRepository.save(book);
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {		
		return bookRepository.findAll(pageable);
	}

	@Override
	public Slice<Book> findAllSlice(Pageable pageable) {		
		return bookRepository.findAll(pageable);
	}

	@Override
	public TPage<Book> customPagination(Pageable pageable) {
		Page<Book> books = bookRepository.findAll(pageable);
		TPage<Book> response = new TPage<>();
		response.setStat(books);
		return response;
	}

}
