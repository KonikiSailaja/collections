package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Books;
import com.capgemini.librarymanagementsystem.dto.User;

public interface AdminService {
	boolean adminLogin(String adminEmail, String adminPassword);

	boolean register(Admin admin);

	boolean addBook(Books book);

	boolean removeBook(String removeId);

	boolean issueBook(String userEmail, String bookId);

	boolean collectBook(String userEmail, String bookId);

	boolean addUser(User user, int count);

	boolean removeUser(String userEmail);

	boolean updateUser(User user);

}
