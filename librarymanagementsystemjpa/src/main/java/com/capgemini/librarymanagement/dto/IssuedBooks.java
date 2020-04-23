package com.capgemini.librarymanagement.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class IssuedBooks implements Serializable{
	@Id
	@Column
	private String book_id;
	@Column
	private String user_email;
	@Column
	private Date date_added;
	@Column
	private Date return_date;
	@Column
	private int fine;
	
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	@Override
	public String toString() {
		return "IssuedBooks [book_id=" + book_id + ", user_email=" + user_email + ", date_added=" + date_added
				+ ", return_date=" + return_date + ", fine=" + fine + "]";
	}
	
}
