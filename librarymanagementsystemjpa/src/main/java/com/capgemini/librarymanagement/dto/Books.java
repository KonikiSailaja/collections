package com.capgemini.librarymanagement.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Books implements Serializable {
	@Id
	@Column
	private String book_id;
	@Column
	private String book_name;
	@Column
	private String author;
	@Column
	private String book_publisher;
	
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", book_name=" + book_name + ", author=" + author + ", book_publisher="
				+ book_publisher + "]";
	}
	
}
