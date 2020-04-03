package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.Date;

import com.capgemini.librarymanagementsystemjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryFactory;

public class UserServiceImplementation implements UserService{

	private UserDAO dao = LibraryFactory.getUserDAO();

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return dao.register(user);
	}

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	@Override
	public boolean searchBookName(String bookname) {
		// TODO Auto-generated method stub
		return dao.searchBookName(bookname);
	}

	@Override
	public boolean borrowBook(String bookId, String userId) {
		// TODO Auto-generated method stub
		return dao.borrowBook(bookId, userId);
	}

	@Override
	public void returnBook(Date returndate) {
		// TODO Auto-generated method stub
		//return dao.returnBook(returndate);
	}

}
