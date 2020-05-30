package com.gulcu.murat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class Book {

	@Id
	@SequenceGenerator(name = "book_gen",sequenceName = "book_seq",allocationSize = 1)
	@GeneratedValue(generator = "book_gen",strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String isbn;
	private String title;
	private String author;	
	
}
