package com.springmaventutorial.service;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.springmvcmaventutorial.bean.Book;
import com.springmvcmaventutorial.bean.Member;
import com.springmvcmaventutorial.bean.RentedBooksByMember;
import com.springmvcmaventutorial.dao.BookMapper;
import com.springmvcmaventutorial.dao.RentMapper;
import com.springmvcmaventutorial.service.impl.RentServiceImpl;

public class RentServiceTest {
    private BookMapper bookMapper;
    private RentServiceImpl rentService;
    private RentMapper rentMapper;
	
	@Before
    public void setUp() {
         rentService = new RentServiceImpl();
         rentMapper = createStrictMock(RentMapper.class);
         bookMapper = createStrictMock(BookMapper.class);
         rentService.setRentMapper(rentMapper);
         rentService.setBookMapper(bookMapper);
    }
	
	//rent book
	@Test
	public void getRentedBooksByMemberTest() {		
		Book book1 = createBook(1L, "1");
		Book book2 = createBook(2L, "2");
		Member member = createMember(1L, "");	
		RentedBooksByMember rentedBooksByMember = createRentedBooksByMember(member, Arrays.asList(book1, book2));
		
		rentMapper.insertRentedBook(member.getId(), book1.getId(), getNowDate());
		rentMapper.insertRentedBook(member.getId(), book2.getId(), getNowDate());
		expect(rentMapper.selectRentedBooksByMember(member.getId())).andReturn(rentedBooksByMember);
		replay(rentMapper);
		
		rentService.rentBook(rentedBooksByMember);
		assertEquals(rentedBooksByMember.getRentedBookList(), rentService.getRentedBooksByMember(member).getRentedBookList());
		
		verify(rentMapper);
	}
	
	//taking back book
	@Test
	public void takingBackBooksFromMemberTest() {
		Book book1 = createBook(1L, "1");
		Book book2 = createBook(2L, "2");
		Member member = createMember(1L, "");		
		RentedBooksByMember rentedBooksByMember = createRentedBooksByMember(member, Arrays.asList(book1, book2));		
		RentedBooksByMember takingBackBooksFromMember = createRentedBooksByMember(member, Arrays.asList(book1));		
		RentedBooksByMember afterTakingBackBooksFromMember = createRentedBooksByMember(member, Arrays.asList(book2));
		
		rentMapper.insertRentedBook(member.getId(), book1.getId(), getNowDate());
		rentMapper.insertRentedBook(member.getId(), book2.getId(), getNowDate());
		rentMapper.deleteRentedBook(member.getId(), book1.getId());
		expect(rentMapper.selectRentedBooksByMember(member.getId())).andReturn(afterTakingBackBooksFromMember);
		replay(rentMapper);
		
		rentService.rentBook(rentedBooksByMember);
		rentService.takingBackBooksFromMember(takingBackBooksFromMember);
		assertEquals(afterTakingBackBooksFromMember.getRentedBookList(), rentService.getRentedBooksByMember(member).getRentedBookList());
		
		verify(rentMapper);
	}

	@Test
	public void getRentedBooksByMemberListTest() {
		Book book1 = createBook(1L, "1");
		Book book2 = createBook(2L, "2");
		Book book3 = createBook(3L, "3");
		Book book4 = createBook(4L, "4");
		Book book5 = createBook(5L, "5");
		Book book6 = createBook(6L, "6");
		Member member1 = createMember(1L, "1");
		Member member2 = createMember(2L, "2");	
		Member member3 = createMember(3L, "3");	
		RentedBooksByMember rentedBooksByMember1 = createRentedBooksByMember(member1, Arrays.asList(book1, book2));
		RentedBooksByMember rentedBooksByMember2 = createRentedBooksByMember(member2, Arrays.asList(book3, book4));
		RentedBooksByMember rentedBooksByMember3 = createRentedBooksByMember(member3, Arrays.asList(book5, book6));
		List<RentedBooksByMember> rentedBooksByMemberList = Arrays.asList(rentedBooksByMember1, rentedBooksByMember2, rentedBooksByMember3);
				
		rentMapper.insertRentedBook(member1.getId(), book1.getId(), getNowDate());
		rentMapper.insertRentedBook(member1.getId(), book2.getId(), getNowDate());
		rentMapper.insertRentedBook(member2.getId(), book3.getId(), getNowDate());
		rentMapper.insertRentedBook(member2.getId(), book4.getId(), getNowDate());
		rentMapper.insertRentedBook(member3.getId(), book5.getId(), getNowDate());
		rentMapper.insertRentedBook(member3.getId(), book6.getId(), getNowDate());

		expect(rentMapper.selectRentedBooksByMemberList()).andReturn(rentedBooksByMemberList);
		replay(rentMapper);
		
		rentService.rentBook(rentedBooksByMember1);
		rentService.rentBook(rentedBooksByMember2);
		rentService.rentBook(rentedBooksByMember3);
		List<RentedBooksByMember> resultRentedBooksByMemberList = rentService.getRentedBooksByMemberList();
		assertEquals(resultRentedBooksByMemberList.size(), 3);
		assertEquals(resultRentedBooksByMemberList.get(0).getRentedBookList(), rentedBooksByMember1.getRentedBookList());
		assertEquals(resultRentedBooksByMemberList.get(1).getRentedBookList(), rentedBooksByMember2.getRentedBookList());
		assertEquals(resultRentedBooksByMemberList.get(2).getRentedBookList(), rentedBooksByMember3.getRentedBookList());
		
		
		verify(rentMapper);
	}
	@Test
	public void getRentableBookListTest(){
		Book book1 = createBook(1L, "1");
		Book book2 = createBook(2L, "2");
		Book book3 = createBook(3L, "3");
		Book book4 = createBook(4L, "4");
		Book book5 = createBook(5L, "5");
		Book book6 = createBook(6L, "6");
		
		Member member1 = createMember(1L, "1");
		Member member2 = createMember(2L, "2");	
		
		RentedBooksByMember rentedBooksByMember1 = createRentedBooksByMember(member1, Arrays.asList(book1, book2));
		RentedBooksByMember rentedBooksByMember2 = createRentedBooksByMember(member2, Arrays.asList(book3, book4));
		
		rentMapper.insertRentedBook(member1.getId(), book1.getId(), getNowDate());
		rentMapper.insertRentedBook(member1.getId(), book2.getId(), getNowDate());
		rentMapper.insertRentedBook(member2.getId(), book3.getId(), getNowDate());
		rentMapper.insertRentedBook(member2.getId(), book4.getId(), getNowDate());
		expect(rentMapper.selectRentedBooks()).andReturn(Arrays.asList(book1, book2, book3, book4));
		expect(bookMapper.selectBookList()).andReturn(Arrays.asList(book1, book2, book3, book4, book5, book6));
		replay(rentMapper);
		replay(bookMapper);
		
		rentService.rentBook(rentedBooksByMember1);
		rentService.rentBook(rentedBooksByMember2);

		List<Book> resultRentableBooks = rentService.getRentableBookList();
		assertEquals(2, resultRentableBooks.size());
		assertEquals(Arrays.asList(book5, book6),resultRentableBooks);
		
		verify(rentMapper);		
	}
	
	private Member createMember(Long id, String suffix){
		Member member = new Member();
		member.setId(id);
		member.setFirstName("Nagy");
		member.setLastName("Kis" + suffix);
		member.setBirthDate(new Date());
		member.setPhoneNumber("+361/123-4567");
		member.setCity("Budapest");
		member.setZipCode("1063");
		member.setStreetAddress1("1");
		member.setStreetAddress2("2");
		member.setStreetAddress3("3");
		
		return member;
	}
	
	private Book createBook(Long id, String suffix){
		Book book = new Book();
		book.setId(id);
		book.setAuthor("PuskInOrOut" + suffix);
		book.setTitle("puskOutOrIn" + suffix);
		book.setQuantity(1);
		
		return book;
	}
	
	private RentedBooksByMember createRentedBooksByMember(Member member, List<Book> bookList) {
		RentedBooksByMember rentedBooksByMember = new RentedBooksByMember();
		rentedBooksByMember.setMember(member);
		rentedBooksByMember.setRentedBookList(bookList);
		
		return rentedBooksByMember;
	}
	
	private Date getNowDate() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		return new Date(year + month + day);
	}
}
