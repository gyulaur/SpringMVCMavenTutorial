package com.springmvcmaventutorial.controller;  
  
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvcmaventutorial.bean.Member;
import com.springmvcmaventutorial.service.api.MemberService;
  
@Controller  
public class MemberController {
	
    MemberService memberService;
    
    public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    @RequestMapping(value = "memberregistration", method = RequestMethod.GET)
	public String newMember(ModelMap model) {
		model.addAttribute("member", new Member());
		return "memberregistration";
 
	}
    
    @RequestMapping(value = "savemember", method = RequestMethod.POST)
	public String saveMember(Member member, BindingResult result, ModelMap model) {
    	if (result.hasErrors()){
    		return "memberregistration";
    	} else {
    		memberService.saveMember(member);
			return "redirect:home";
    	}
	}
    
    @RequestMapping(value = "deletemember", method = RequestMethod.GET)
	public String deleteMember(ModelMap model) {
    	List<Member> memberList = memberService.getMemberList();
    	
		model.addAttribute("memberList", memberList);
		model.addAttribute("member", new Member());
		return "deletemember";
 
	}
    
    @RequestMapping(value = "deletemember", method = RequestMethod.POST)
	public String deleteMember(Member member, BindingResult result, ModelMap model) {
    	memberService.deleteMember(member); 
    	return "redirect:home";
	}
    
    @RequestMapping(value = "editmember", method = RequestMethod.GET)
	public String selectMemberToEdit(ModelMap model) {
    	List<Member> memberList = memberService.getMemberList();
    	
		model.addAttribute("memberList", memberList);
		model.addAttribute("member", new Member());
		return "selectmembertoedit";
 
	}
    
    @RequestMapping(value = "editselectedmember", method = RequestMethod.POST)
	public String editSelectedMember(Member member, ModelMap model) {
		member = memberService.getMember(member.getId());
    	model.addAttribute("member", member);
		return "editmember";
 
	}    
    
    @RequestMapping(value = "editmember", method = RequestMethod.POST)
	public String editMember(Member member, BindingResult result, ModelMap model) {
    	memberService.saveMember(member); 
    	return "redirect:home";
	}
    
    @RequestMapping(value = "memberlist", method = RequestMethod.GET)
	public String memberList(ModelMap model) {
    	List<Member> memberList = memberService.getMemberList();   	
		model.addAttribute("memberList", memberList);
		
		return "memberlist";
	}
}  