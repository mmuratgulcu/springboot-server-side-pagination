package com.gulcu.murat.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gulcu.murat.entities.Book;
import com.gulcu.murat.service.impl.BookServiceImpl;
import com.gulcu.murat.util.TPage;

@RestController
@RequestMapping("/book")
public class BookController {

	private final BookServiceImpl bookServiceImpl;

	public BookController(BookServiceImpl bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}

	@GetMapping("/pagination/v1")
	public ResponseEntity<Page<Book>> pagination(@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
		return ResponseEntity.ok(bookServiceImpl.findAll(currentPage,pageSize));
	}

	// book/pagination/v2?page=0&size=2&sort=id
	@GetMapping("/pagination/v2")
	public ResponseEntity<Page<Book>> pagination(Pageable pageable) {
		return ResponseEntity.ok(bookServiceImpl.findAll(pageable));
	}

	// Slice ve Page farkı fazla kayıt olduğunda Page kayıt sayısını öğrenmek için
	// ekstra count sorgusu atar.
	// Slice ise istenilen kayıt sayısının bir fazlasını aratarak başka kayıt olup
	// olmadığını anlar. Daha hızlı
	// book/pagination/v3?page=0&size=3&sort=isbn
	@GetMapping("/pagination/v3")
	public Slice<Book> paginationV3(Pageable pageable) {
		return bookServiceImpl.findAllSlice(pageable);
	}

	@GetMapping("/pagination/v4")
	public ResponseEntity<TPage<Book>> paginationV4(Pageable pageable) {		
		return ResponseEntity.ok(bookServiceImpl.customPagination(pageable));
	}

	@PostMapping("/save")
	public ResponseEntity<Book> save(@RequestBody Book book) {
		return ResponseEntity.ok(bookServiceImpl.save(book));
	}

}
