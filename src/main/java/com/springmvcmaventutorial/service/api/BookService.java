package com.springmvcmaventutorial.service.api;

import java.util.List;

import com.springmvcmaventutorial.bean.Book;

public interface BookService {
	public Book saveBook(Book book);
	public void deleteBook(Book book);
	public List<Book> getBookList();
	public Book getBook(Long id);
}
