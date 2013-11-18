package com.springmvcmaventutorial.service.api;

import java.util.List;

import com.springmvcmaventutorial.bean.Member;

public interface MemberService {

	public Member saveMember(Member member);
	public void deleteMember(Member member);
	public List<Member> getMemberList();
	public Member getMember(Long id);
}
