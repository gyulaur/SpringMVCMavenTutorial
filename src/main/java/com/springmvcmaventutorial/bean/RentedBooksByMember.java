package com.springmvcmaventutorial.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("serial")
public class RentedBooksByMember implements Serializable {
	private UUID uuid = UUID.randomUUID();
	private Member member;
	private List<Book> rentedBookList = new ArrayList<Book>();
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public List<Book> getRentedBookList() {
		return rentedBookList;
	}
	public void setRentedBookList(List<Book> rentedBookList) {
		this.rentedBookList = rentedBookList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentedBooksByMember other = (RentedBooksByMember) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "RentedBooksByMember [uuid=" + uuid + ", member=" + member
				+ ", rentedBookList=" + rentedBookList + "]";
	}
}
