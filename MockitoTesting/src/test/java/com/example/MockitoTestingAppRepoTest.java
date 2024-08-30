package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.entity.Book;
import com.example.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class MockitoTestingAppRepoTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testFindById()
	{
		Book book = new Book();
		
		book.setTitle("C# for Beginners");
		book.setAuthor("John");
		entityManager.persist(book);
		
		
		Optional<Book> found = bookRepository.findById(book.getId());
		
		
		assertThat(found.isPresent()).isTrue();
		assertThat(found.get().getTitle()).isEqualTo(book.getTitle());
		assertThat(found.get().getAuthor()).isEqualTo(book.getAuthor());
		
	}

}
