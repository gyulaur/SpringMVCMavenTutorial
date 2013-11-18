package com.springmvcmaventutorial.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.springmvcmaventutorial.bean.Book;
import com.springmvcmaventutorial.bean.Member;
import com.springmvcmaventutorial.bean.RentedBooksByMember;
import com.springmvcmaventutorial.dao.BookMapper;
import com.springmvcmaventutorial.dao.RentMapper;
import com.springmvcmaventutorial.service.api.RentService;

public class RentServiceImpl implements RentService {
	private RentMapper rentMapper;
	private BookMapper bookMapper;
	
	public RentMapper getRentMapper() {
		return rentMapper;
	}

	public void setRentMapper(RentMapper rentMapper) {
		this.rentMapper = rentMapper;
	}

	public BookMapper getBookMapper() {
		return bookMapper;
	}

	public void setBookMapper(BookMapper bookMapper) {
		this.bookMapper = bookMapper;
	}

	public void rentBook(RentedBooksByMember rentedBooksByMember) {
		for (Book book : rentedBooksByMember.getRentedBookList()){
			if (book.getId() != null){
				rentMapper.insertRentedBook(rentedBooksByMember.getMember().getId(), book.getId(), getNowDate());
			}
		}
	}

	public RentedBooksByMember getRentedBooksByMember(Member member) {
		return rentMapper.selectRentedBooksByMember(member.getId());
	}

	public void takingBackBooksFromMember(RentedBooksByMember rentedBooksByMember) {
		for (Book book : rentedBooksByMember.getRentedBookList()){
			rentMapper.deleteRentedBook(rentedBooksByMember.getMember().getId(), book.getId());
		}
	}

	public List<RentedBooksByMember> getRentedBooksByMemberList() {
		return rentMapper.selectRentedBooksByMemberList();
	}
	
	public List<Book> getRentableBookList(){
		List<Book> rentedBookList = rentMapper.selectRentedBooks();
		List<Book> allBookList = bookMapper.selectBookList();
		List<Book> rentableBookList = new ArrayList<Book>();

		for (Book rentedBook : rentedBookList){
			int index = allBookList.indexOf(rentedBook);
			Book book = allBookList.get(index);
			book.setQuantity(book.getQuantity()-1);
		}
		
		for (Book book : allBookList){
			if (book.getQuantity() >0){
				rentableBookList.add(book);
			}
		}
		
		return rentableBookList;
	}
	
	private Date getNowDate() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		return new Date(year + month + day);
	}
}
