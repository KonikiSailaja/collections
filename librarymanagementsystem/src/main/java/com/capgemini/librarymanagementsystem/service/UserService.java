package com.capgemini.librarymanagementsystem.service;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Books;
import com.capgemini.librarymanagementsystem.dto.User;

public interface UserService {
	boolean register(User user, int count);

	boolean login(String email, String password);

	boolean searchBookName(String bookname);

	boolean borrowBook(String bookId, String userId);

	String returnBook(Date returndate);

}
