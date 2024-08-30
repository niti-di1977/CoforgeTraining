package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;

@ExtendWith(MockitoExtension.class)
public class MockitoTestingAppServiceTest {

    @Mock
    private BookRepository bookRepository;

    
    //When book service is initiated then book repository will be injected there in Book Service
    @InjectMocks
    private BookService bookService;

    @Test
    void testGetBookById() {
        Book expectedBook = new Book();
        Long bookId = 2L;
        expectedBook.setId(bookId);
        expectedBook.setTitle("Java Programming");
        expectedBook.setAuthor("John");
        
        Book actualBook = new Book();
        Long bookIds = 3L;
        actualBook.setId(bookIds);
        actualBook.setTitle("Java Programming");
        actualBook.setAuthor("John");

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(actualBook));

        Book actual = bookService.getBookById(bookId);

        assertEquals(expectedBook, actual);
    }
}
