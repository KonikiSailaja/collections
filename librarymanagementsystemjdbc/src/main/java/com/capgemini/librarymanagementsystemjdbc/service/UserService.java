package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.Date;

import com.capgemini.librarymanagementsystemjdbc.dto.User;



public interface UserService {
	boolean register(User user);

	boolean login(String email, String password);

	boolean searchBookName(String bookname);

	boolean borrowBook(String bookId, String userId);

	void returnBook(Date presentDate);

}
