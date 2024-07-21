package br.com.takahashi.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.takahashi.data.vo.v1.BookVO;
import br.com.takahashi.exceptions.RequiredObjectIsNullException;
import br.com.takahashi.model.Book;
import br.com.takahashi.repositories.BookRepository;
import br.com.takahashi.services.BookService;
import br.com.takahashi.unittests.mapper.mocks.MockBook;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	MockBook input;
	
	@InjectMocks
	private BookService bookService;
	
	@Mock
	BookRepository bookRepository;
	
	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockBook();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		List<Book> book = input.mockEntityList();
		
		when(bookRepository.findAll()).thenReturn(book);
		
		var books = bookService.findAll();
		assertEquals(12, books.size());
		
		var bookOne = books.get(1);
		assertNotNull(bookOne);
		assertNotNull(bookOne.getKey());
		assertNotNull(bookOne.getLinks());
		System.out.println(bookOne.toString());
		assertTrue(bookOne.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Author1", bookOne.getAuthor());
		assertEquals(LocalDateTime.of(1, 1, 1, 1, 1), bookOne.getLaunchDate());
		assertEquals(BigDecimal.ONE, bookOne.getPrice());
		assertEquals("title1", bookOne.getTitle());

		var bookFour = books.get(4);
		assertNotNull(bookFour);
		assertNotNull(bookFour.getKey());
		assertNotNull(bookFour.getLinks());
		assertTrue(bookFour.toString().contains("links: [</api/book/v1/4>;rel=\"self\"]"));
		assertEquals("Author4", bookFour.getAuthor());
		assertEquals(LocalDateTime.of(4, 4, 4, 4, 4), bookFour.getLaunchDate());
		assertEquals(BigDecimal.valueOf(4), bookFour.getPrice());
		assertEquals("title4", bookFour.getTitle());
	}

	@Test
	void testFindById() {
		Book book = input.mockEntity(1);
		book.setId(1);
		when(bookRepository.findById(1)).thenReturn(Optional.of(book));
		
		var result = bookService.findById(1);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Author1", result.getAuthor());
		assertEquals(LocalDateTime.of(1, 1, 1, 1, 1), result.getLaunchDate());
		assertEquals(BigDecimal.ONE, result.getPrice());
		assertEquals("title1", result.getTitle());
	}

	@Test
	void testCreate() {
		Book book = input.mockEntity(1);
		Book persisted = book;
		persisted.setId(1);
		
		BookVO vo = input.mockVO(1);
		vo.setKey(1);
		
		when(bookRepository.save(book)).thenReturn(persisted);
		
		var result = bookService.create(vo);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Author1", result.getAuthor());
		assertEquals(LocalDateTime.of(1, 1, 1, 1, 1), result.getLaunchDate());
		assertEquals(BigDecimal.ONE, result.getPrice());
		assertEquals("title1", result.getTitle());
	}
	
	@Test
	void createWithNullBook() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			bookService.create(null);
		});
		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testUpdate() {
		Book book = input.mockEntity(1);
		Book persisted = book;
		persisted.setId(1);
		
		BookVO vo = input.mockVO(1);
		vo.setKey(1);
		when(bookRepository.findById(1)).thenReturn(Optional.of(book));
		when(bookRepository.save(book)).thenReturn(persisted);
		
		var result = bookService.update(vo);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));
		assertEquals("Author1", result.getAuthor());
		assertEquals(LocalDateTime.of(1, 1, 1, 1, 1), result.getLaunchDate());
		assertEquals(BigDecimal.ONE, result.getPrice());
		assertEquals("title1", result.getTitle());
	}

	@Test
	void updateWithNullBook() {
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			bookService.update(null);
		});
		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	
	@Test
	void testDelete() {
		Book book = input.mockEntity(1);
		book.setId(1);
		
		BookVO vo = input.mockVO(1);
		vo.setKey(1);
		when(bookRepository.findById(1)).thenReturn(Optional.of(book));
		
		bookService.delete(1);
	}
}
