package com.capgemini.librarymanagement.service;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagement.dto.Books;
import com.capgemini.librarymanagement.dto.Request;
import com.capgemini.librarymanagement.dto.Users;

public interface UserService {
	boolean login(String email, String password);

	boolean addBook(Books book);

	boolean removeBook(String bookId);

	boolean issueBook(String userEmail, String bookId);

	boolean collectBook(String userEmail, String bookId);

	boolean addUser(Users user);

	boolean removeUser(String userEmail);

	boolean updateUser(Users user);
	
	boolean searchBookName(String bookname);

	void returnBook(Date returndate);
	
	boolean requestBook(String bookid, String userEmail);
	
	List<Request> viewAllRequest();
	 
	boolean acceptRequest(String userEmail, String bookId);
	
	boolean rejectRequest(String userEmail, String bookId);


}
