package com.springmvcmaventutorial.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvcmaventutorial.bean.Book;
import com.springmvcmaventutorial.bean.Member;
import com.springmvcmaventutorial.bean.RentedBooksByMember;
import com.springmvcmaventutorial.service.api.BookService;
import com.springmvcmaventutorial.service.api.MemberService;
import com.springmvcmaventutorial.service.api.RentService;

@Controller
public class RentController {
	
	MemberService memberService;	
	BookService bookService;	
	RentService rentService;	
	
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public RentService getRentService() {
		return rentService;
	}

	public void setRentService(RentService rentService) {
		this.rentService = rentService;
	}

	@RequestMapping(value = "rentabook", method = RequestMethod.GET)
	public String rentABook(ModelMap model) {
		setRentABookModel(new RentedBooksByMember(), model);		
		return "rentabook"; 
	}
	
	@RequestMapping(value = "rentabook", method = RequestMethod.POST)
	public String rentABook(RentedBooksByMember rentedBooksByMember, BindingResult result, ModelMap model) {
		if (rentedBooksByMember.getMember().getId() != 0){
			boolean isRentable = true;
			int index = -1;
			List<Book> rentedBooks = rentService.getRentedBooksByMember(rentedBooksByMember.getMember()).getRentedBookList();
			
			for (Book book : rentedBooksByMember.getRentedBookList()){
				if (rentedBooks.contains(book)){
					//hiba, mar kikolcsonozte a konyvet
					index = rentedBooksByMember.getRentedBookList().indexOf(book);
					isRentable = false;
				}
			}
			if (isRentable){
				rentService.rentBook(rentedBooksByMember);
	    		return "redirect:home";
			} else {
				setRentABookModel(rentedBooksByMember, model);
				result.rejectValue("rentedBookList["+index+"].id","rentedBookList.notvalid", "Már ki lett kölcsönözve ez a könyv!");
				return "rentabook";
			}
    	} else {
    		setRentABookModel(rentedBooksByMember, model);
			result.rejectValue("member.id","member.notvalid", "Kötelező Tagot választani!");
			return "rentabook";
    	}
	}
	
	private void setRentABookModel(RentedBooksByMember rentedBooksByMember, ModelMap model) {
		model.addAttribute("memberList", memberService.getMemberList());
		model.addAttribute("bookList", rentService.getRentableBookList());		
		model.addAttribute("rentedBooksByMember", rentedBooksByMember);
	}

	@RequestMapping(value = "takingbackbook", method = RequestMethod.GET)
	public String takingBackBook(ModelMap model) {
		model.addAttribute("memberList", memberService.getMemberList());				
		model.addAttribute("member", new Member());
		
		return "selectRenter"; 
	}
	
	@RequestMapping(value = "selectrenter", method = RequestMethod.POST)
	public String selectRenter(Member member, ModelMap model) {
		member = memberService.getMember(member.getId());
		
		RentedBooksByMember rentedBooksByMember = new RentedBooksByMember();
		rentedBooksByMember.setMember(member);
		
		model.addAttribute("rentedBookList",rentService.getRentedBooksByMember(member).getRentedBookList());
		model.addAttribute("takinkBackBookFromMember", rentedBooksByMember);		
		model.addAttribute("member", member);

		return "takingbackbook";
	}
	
	@RequestMapping(value = "takingbackbook", method = RequestMethod.POST)
	public String takingBackBook(RentedBooksByMember rentedBooksByMember, ModelMap model) {
		rentedBooksByMember.setMember(memberService.getMember(rentedBooksByMember.getMember().getId()));
		rentService.takingBackBooksFromMember(rentedBooksByMember);
		return "redirect:home";
	}
	
	@RequestMapping(value = "rentedbooklist", method = RequestMethod.GET)
	public String rentedBook(ModelMap model) {
		model.addAttribute("rentedBooksByMemberList", rentService.getRentedBooksByMemberList());				
		
		
		return "rentedbook"; 
	}
	
	@RequestMapping(value = "rentablebooklist", method = RequestMethod.GET)
	public String bookList(ModelMap model) {
    	List<Book> bookList = rentService.getRentableBookList();   	
		model.addAttribute("bookList", bookList);
		
		return "rentablebook";
	}
}
