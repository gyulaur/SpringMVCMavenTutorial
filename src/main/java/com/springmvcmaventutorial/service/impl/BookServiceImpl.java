package com.springmvcmaventutorial.service.impl;

import java.util.List;

import com.springmvcmaventutorial.bean.Book;
import com.springmvcmaventutorial.dao.BookMapper;
import com.springmvcmaventutorial.service.api.BookService;

public class BookServiceImpl implements BookService {
	private BookMapper bookMapper;
	
	public BookMapper getBookMapper() {
		return bookMapper;
	}

	public void setBookMapper(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	public Book saveBook(Book book) {
		if (book.getId() != null){
			bookMapper.updateBook(book);
		} else {
			bookMapper.insertBook(book);
		}
		
		return book;
	}

	public void deleteBook(Book book) {
		bookMapper.deleteBook(book.getId());
	}

	public List<Book> getBookList() {
		return bookMapper.selectBookList();
	}

	public Book getBook(Long id) {
		return bookMapper.selectBook(id);
	}
}	
