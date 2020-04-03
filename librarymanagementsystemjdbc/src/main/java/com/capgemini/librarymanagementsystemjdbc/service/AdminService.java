package com.capgemini.librarymanagementsystemjdbc.service;

import com.capgemini.librarymanagementsystemjdbc.dto.Admin;
import com.capgemini.librarymanagementsystemjdbc.dto.Books;
import com.capgemini.librarymanagementsystemjdbc.dto.User;

public interface AdminService {
	boolean adminLogin(String adminEmail, String adminPassword);

	boolean addBook(Books book);

	boolean removeBook(String removeId);

	boolean issueBook(String userEmail, String bookId1);

	boolean collectBook(String userEmail1, String bookId2);

	boolean addUser(User user);

	boolean removeUser(String userEmail);

	boolean updateUser(User user);

}
