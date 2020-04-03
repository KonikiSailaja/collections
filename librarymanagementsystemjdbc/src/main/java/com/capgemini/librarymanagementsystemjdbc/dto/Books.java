package com.capgemini.librarymanagementsystemjdbc.dto;

import java.io.Serializable;
import java.sql.Date;


public class Books implements Serializable {
	private String bookId;
	private String bookName;
	private String author;
	private String bookPublisher;

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
}
