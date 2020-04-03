package com.capgemini.librarymanagementsystemjdbc.dao;

import com.capgemini.librarymanagementsystemjdbc.dto.Admin;
import com.capgemini.librarymanagementsystemjdbc.dto.Books;
import com.capgemini.librarymanagementsystemjdbc.dto.User;

public interface AdminDAO {
	boolean adminLogin(String adminEmail, String adminpassword);

	boolean addBook(Books book);

	boolean removeBook(String bookId);

	boolean issueBook(String userEmail, String bookId);

	boolean collectBook(String userEmail, String bookId);

	boolean addUser(User user);

	boolean removeUser(String userEmail);

	boolean updateUser(User user);

}
