package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Book;
import com.example.service.BookService;

@Controller
@RequestMapping("api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/{id}") 
	public ResponseEntity<Book> getBookById(@PathVariable Long id)
	{
		Book book = bookService.getBookById(id);
		if(book != null)
		{
			return ResponseEntity.ok(book);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
}
