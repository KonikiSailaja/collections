package com.capgemini.librarymanagementsystem.service;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.UserDAO;
import com.capgemini.librarymanagementsystem.dto.Books;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.factory.LibraryFactory;

public class UserServiceImplementation implements UserService {

	private UserDAO dao = LibraryFactory.getUserDAO();

	@Override
	public boolean register(User user, int count) {

		return dao.register(user, count);
	}

	@Override
	public boolean login(String email, String password) {

		return dao.login(email, password);
	}

	@Override
	public boolean searchBookName(String bookname) {

		return dao.searchBookName(bookname);
	}

	@Override
	public boolean borrowBook(String bookId, String userId) {

		return dao.borrowBook(bookId, userId);
	}

	@Override
	public String returnBook(Date returndate) {

		return dao.returnBook(returndate);
	}

}