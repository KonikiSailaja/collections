package com.capgemini.librarymanagement.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Request implements Serializable{
	@Id
	@Column
	private String book_Id;
	@Column
	private String email;
	@Column
	private String status;
	
	public String getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(String book_Id) {
		this.book_Id = book_Id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Request [book_Id=" + book_Id + ", email=" + email + ", status=" + status + "]";
	}
	
}
