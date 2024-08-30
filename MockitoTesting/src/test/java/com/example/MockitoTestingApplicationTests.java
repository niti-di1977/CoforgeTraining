package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controller.BookController;
import com.example.entity.Book;
import com.example.service.BookService;


@WebMvcTest(BookController.class)
@ExtendWith(MockitoExtension.class)
class MockitoTestingApplicationTests {
	@Test
	void contextLoads() {
	}
	/*To test  Controller*/
	@Autowired 
	private MockMvc mockmvc;
	
	@MockBean
	private BookService bookService;
	
	@Test
	public void testGetBookById() throws Exception
	{
		Book book = new Book();
		Long bookId = 1L;
		book.setId(bookId);
		book.setTitle("Java Programming");
		book.setAuthor("John");
		
		Mockito.when(bookService.getBookById(bookId)).thenReturn(book);
		
		mockmvc.perform(get("/api/books/{id}",bookId))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title",is("Java Programming")))
				.andExpect(jsonPath("$.author", is("John")));
		
		
		
		
	}
}
