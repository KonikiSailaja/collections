package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.Date;

import com.capgemini.librarymanagementsystemjdbc.dto.User;



public interface UserDAO {

	boolean register(User user);

	boolean login(String email, String password);

	boolean searchBookName(String bookname);

	boolean borrowBook(String bookId, String userId);

	void returnBook(Date returndate);
	
	boolean requestBook(String bookid, String userEmail);

}
