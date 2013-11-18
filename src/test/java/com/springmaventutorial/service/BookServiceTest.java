package com.springmaventutorial.service;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.springmvcmaventutorial.bean.Book;
import com.springmvcmaventutorial.dao.BookMapper;
import com.springmvcmaventutorial.service.impl.BookServiceImpl;

public class BookServiceTest {
	private BookServiceImpl bookService;
    private BookMapper bookMapper;
	
	@Before
    public void setUp() {
         bookService = new BookServiceImpl();
         bookMapper = createStrictMock(BookMapper.class);
         bookService.setBookMapper(bookMapper);
    }
	
	//insert
	@Test
	public void insertBookTest() {
		Book book = createBook(null, "");		
		Book returnBook = createBook(1L, "");
		
		bookMapper.insertBook(book);
		expect(bookMapper.selectBook(1L)).andReturn(returnBook);
		replay(bookMapper);
		
		bookService.saveBook(book);
		assertEquals(bookService.getBook(1L),returnBook);		
		
		verify(bookMapper);
	}
	//delete
	@Test
	public void deleteBookTest() {
		Book book = createBook(null, "");		
		Book returnBook = createBook(1L, "");
		
		bookMapper.insertBook(book);
		bookMapper.deleteBook(1L);
		expect(bookMapper.selectBook(1L)).andReturn(null);
		replay(bookMapper);
		
		bookService.saveBook(book);
		bookService.deleteBook(returnBook);
		assertEquals(bookService.getBook(1L),null);		
		
		verify(bookMapper);
	}
	
	//booklist
	@Test
	public void getBookListTest() {
		Book book1 = createBook(null, "1");		
		Book returnBook1 = createBook(1L, "1");		
		Book book2 = createBook(null, "2");		
		Book returnBook2 = createBook(2L, "2");		
		Book book3 = createBook(null,"3");		
		Book returnBook3 = createBook(3L,"3");		
		List<Book> returnBookList = Arrays.asList(returnBook1, returnBook2, returnBook3);
		
		bookMapper.insertBook(book1);
		bookMapper.insertBook(book2);
		bookMapper.insertBook(book3);		
		expect(bookMapper.selectBookList()).andReturn(returnBookList);
		replay(bookMapper);
		
		bookService.saveBook(book1);
		bookService.saveBook(book2);
		bookService.saveBook(book3);		
		assertEquals(bookService.getBookList(),returnBookList);		
		
		verify(bookMapper);
	}
	
	private Book createBook(Long id, String suffix){
		Book book = new Book();
		book.setId(id);
		book.setAuthor("PuskInOrOut" + suffix);
		book.setTitle("puskOutOrIn" + suffix);
		book.setQuantity(1);
		
		return book;
	}
}