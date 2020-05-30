package com.gulcu.murat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gulcu.murat.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
