package com.springmvcmaventutorial.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springmvcmaventutorial.bean.Book;
import com.springmvcmaventutorial.bean.RentedBooksByMember;

public interface RentMapper {
	public void insertRentedBook(@Param("personId") Long personId, @Param("bookId") Long bookId, @Param("rentedDate") Date rentedDate);
	public RentedBooksByMember selectRentedBooksByMember(@Param("personId") Long memberId);
	public void deleteRentedBook(@Param("personId") Long memberId, @Param("bookId") Long bookId);
	public List<RentedBooksByMember> selectRentedBooksByMemberList();
	public List<Book> selectRentedBooks();
}
