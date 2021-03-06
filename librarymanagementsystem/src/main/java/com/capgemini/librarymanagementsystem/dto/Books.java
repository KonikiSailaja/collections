package com.capgemini.librarymanagementsystem.dto;

import java.io.Serializable;
import java.util.Date;

public class Books implements Serializable {
	private String bookId;
	private String bookName;
	private String author;
	private String dateAdded;
	private int returnDate;
	private String bookPublisher;
	private boolean isIssued;
	private boolean isReturn;
	private String userEmail;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail2) {
		this.userEmail = userEmail2;
	}

	public boolean getIsIssued() {
		return isIssued;
	}

	public void setIsIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public boolean getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookPublisher() {
		return getBookPublisher();
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(int returnDate) {
		this.returnDate = returnDate;
	}

}
