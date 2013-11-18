package com.springmvcmaventutorial.dao;

import java.util.List;

import com.springmvcmaventutorial.bean.Member;

public interface MemberMapper {
	public void insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(Long personId);
	public List<Member> selectMemberList();
	public Member selectMember(Long personId);
}
