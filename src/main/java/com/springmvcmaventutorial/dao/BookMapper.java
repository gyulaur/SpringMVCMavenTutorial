package com.springmvcmaventutorial.dao;

import java.util.List;

import com.springmvcmaventutorial.bean.Book;

public interface BookMapper {
	public void insertBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Long bookId);
	public List<Book> selectBookList();
	public Book selectBook(Long bookId);
}
