package com.capgemini.librarymanagement.service;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagement.dao.UserDAO;
import com.capgemini.librarymanagement.dto.Books;
import com.capgemini.librarymanagement.dto.Request;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.factory.LibraryFactory;


public class UserServiceImplementation implements UserService{
	
	private UserDAO dao = LibraryFactory.getUserDAO();

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	@Override
	public boolean addBook(Books book) {
		// TODO Auto-generated method stub
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(String bookId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bookId);
	}

	@Override
	public boolean issueBook(String userEmail, String bookId) {
		// TODO Auto-generated method stub
		return dao.issueBook(userEmail, bookId);
	}

	@Override
	public boolean collectBook(String userEmail, String bookId) {
		// TODO Auto-generated method stub
		return dao.collectBook(userEmail, bookId);
	}

	@Override
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public boolean removeUser(String userEmail) {
		// TODO Auto-generated method stub
		return dao.removeUser(userEmail);
	}

	@Override
	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public boolean searchBookName(String bookname) {
		// TODO Auto-generated method stub
		return dao.searchBookName(bookname);
	}

	@Override
	public void returnBook(Date returndate) {
		// TODO Auto-generated method stub
		 dao.returnBook(returndate);
	}

	@Override
	public boolean requestBook(String bookid, String userEmail) {
		// TODO Auto-generated method stub
		return dao.requestBook(bookid, userEmail);
	}

	@Override
	public List<Request> viewAllRequest() {
		// TODO Auto-generated method stub
		return dao.viewAllRequest();
	}

	@Override
	public boolean acceptRequest(String userEmail, String bookId) {
		// TODO Auto-generated method stub
		return dao.acceptRequest(userEmail, bookId);
	}

	@Override
	public boolean rejectRequest(String userEmail, String bookId) {
		// TODO Auto-generated method stub
		return dao.rejectRequest(userEmail, bookId);
	}

}
