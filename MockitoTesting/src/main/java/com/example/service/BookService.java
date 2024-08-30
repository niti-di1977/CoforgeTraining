package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book getBookById(Long id)
	{
		
		return bookRepository.findById(id).orElse(null);
	}

}
