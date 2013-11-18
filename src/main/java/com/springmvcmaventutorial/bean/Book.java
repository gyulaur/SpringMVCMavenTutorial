package com.springmvcmaventutorial.bean;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Book implements Serializable{
	private Long id;
	private String author;
	private String title;
	private Integer quantity;
	private Date rentedDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTitleWithAuthor(){
		return this.author + ": " + this.title;
	}
	public Date getRentedDate() {
		return rentedDate;
	}
	public void setRentedDate(Date rentedDate) {
		this.rentedDate = rentedDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title
				+ ", quantity=" + quantity + ", rentedDate=" + rentedDate + "]";
	}
}