package com.springmvcmaventutorial.controller;  
  
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvcmaventutorial.bean.Book;
import com.springmvcmaventutorial.service.api.BookService;
  
@Controller  
public class BookController { 
	
    private BookService bookService;
  
    public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "bookregistration", method = RequestMethod.GET)
	public String newBook(ModelMap model) {
		model.addAttribute("book", new Book());
		return "bookregistration";
 
	}
    
    @RequestMapping(value = "savebook", method = RequestMethod.POST)
	public String saveBook(Book book, BindingResult result, ModelMap model) {
    	if (result.hasErrors()){
    		return "bookregistration";
    	} else {
    		bookService.saveBook(book);
			return "redirect:home";
    	}
	}
    
    @RequestMapping(value = "deletebook", method = RequestMethod.GET)
	public String deleteBook(ModelMap model) {
    	List<Book> bookList = bookService.getBookList();
    	
		model.addAttribute("bookList", bookList);
		model.addAttribute("book", new Book());
		return "deletebook";
 
	}
    
    @RequestMapping(value = "deletebook", method = RequestMethod.POST)
	public String deleteBook(Book book, BindingResult result, ModelMap model) {
    	bookService.deleteBook(book); 
    	return "redirect:home";
	}
    
    @RequestMapping(value = "editbook", method = RequestMethod.GET)
	public String selectBookToEdit(ModelMap model) {
    	List<Book> bookList = bookService.getBookList();
    	
		model.addAttribute("bookList", bookList);
		model.addAttribute("book", new Book());
		return "selectbooktoedit";
 
	}
    
    @RequestMapping(value = "editselectedbook", method = RequestMethod.POST)
	public String editSelectedBook(Book book, ModelMap model) {
		book = bookService.getBook(book.getId());
    	model.addAttribute("book", book);
		return "editbook";
 
	}    
    
    @RequestMapping(value = "editbook", method = RequestMethod.POST)
	public String editBook(Book book, BindingResult result, ModelMap model) {
    	bookService.saveBook(book); 
    	return "redirect:home";
	}
    
    @RequestMapping(value = "booklist", method = RequestMethod.GET)
	public String bookList(ModelMap model) {
    	List<Book> bookList = bookService.getBookList();   	
		model.addAttribute("bookList", bookList);
		
		return "booklist";
	}
}  