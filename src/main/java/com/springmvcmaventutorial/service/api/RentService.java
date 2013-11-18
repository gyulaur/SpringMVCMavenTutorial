package com.springmvcmaventutorial.service.api;

import java.util.List;

import com.springmvcmaventutorial.bean.Book;
import com.springmvcmaventutorial.bean.Member;
import com.springmvcmaventutorial.bean.RentedBooksByMember;

public interface RentService {

	public void rentBook(RentedBooksByMember rentedBooksByMember);
	public RentedBooksByMember getRentedBooksByMember(Member member);
	public void takingBackBooksFromMember(RentedBooksByMember rentedBooksByMember);
	public List<RentedBooksByMember> getRentedBooksByMemberList();
	public List<Book> getRentableBookList();
}
