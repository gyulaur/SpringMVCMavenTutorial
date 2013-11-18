package com.springmvcmaventutorial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvcmaventutorial.bean.Member;
import com.springmvcmaventutorial.dao.MemberMapper;
import com.springmvcmaventutorial.service.api.MemberService;

public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberMapper getMemberMapper() {
		return memberMapper;
	}

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	public Member saveMember(Member member) {
		if (member.getId() != null){
			memberMapper.updateMember(member);
		} else {
			memberMapper.insertMember(member);
		}
		
		return member;
	}

	public void deleteMember(Member member) {
		memberMapper.deleteMember(member.getId());
	}

	public List<Member> getMemberList() {
		return memberMapper.selectMemberList();
	}

	public Member getMember(Long id) {
		return memberMapper.selectMember(id);
	}
}