package com.springmaventutorial.service;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.springmvcmaventutorial.bean.Member;
import com.springmvcmaventutorial.dao.MemberMapper;
import com.springmvcmaventutorial.service.impl.MemberServiceImpl;

public class MemberServiceTest {
	private MemberServiceImpl memberService;
    private MemberMapper memberMapper;
	
	@Before
    public void setUp() {
         memberService = new MemberServiceImpl();
         memberMapper = createStrictMock(MemberMapper.class);
         memberService.setMemberMapper(memberMapper);
    }
	
	//insert
	@Test
	public void insertMemberTest() {
		Member member = createMember(null, "");		
		Member returnMember = createMember(1L, "");
		
		memberMapper.insertMember(member);
		expect(memberMapper.selectMember(1L)).andReturn(returnMember);
		replay(memberMapper);
		
		memberService.saveMember(member);
		assertEquals(memberService.getMember(1L),returnMember);		
		
		verify(memberMapper);
	}
	//delete
	@Test
	public void deleteMemberTest() {
		Member member = createMember(null, "");		
		Member returnMember = createMember(1L, "");
		
		memberMapper.insertMember(member);
		memberMapper.deleteMember(1L);
		expect(memberMapper.selectMember(1L)).andReturn(null);
		replay(memberMapper);
		
		memberService.saveMember(member);
		memberService.deleteMember(returnMember);
		assertEquals(memberService.getMember(1L),null);		
		
		verify(memberMapper);
	}
	
	//memberlist
	@Test
	public void getMemberListTest() {
		Member member1 = createMember(null, "1");		
		Member returnMember1 = createMember(1L, "1");		
		Member member2 = createMember(null, "2");		
		Member returnMember2 = createMember(2L, "2");		
		Member member3 = createMember(null,"3");		
		Member returnMember3 = createMember(3L,"3");		
		List<Member> returnMemberList = Arrays.asList(returnMember1, returnMember2, returnMember3);
		
		memberMapper.insertMember(member1);
		memberMapper.insertMember(member2);
		memberMapper.insertMember(member3);		
		expect(memberMapper.selectMemberList()).andReturn(returnMemberList);
		replay(memberMapper);
		
		memberService.saveMember(member1);
		memberService.saveMember(member2);
		memberService.saveMember(member3);		
		assertEquals(memberService.getMemberList(),returnMemberList);		
		
		verify(memberMapper);
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
}