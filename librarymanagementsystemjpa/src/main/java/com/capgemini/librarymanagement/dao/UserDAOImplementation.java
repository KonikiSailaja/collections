package com.capgemini.librarymanagement.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagement.dto.Books;
import com.capgemini.librarymanagement.dto.Request;
import com.capgemini.librarymanagement.dto.Users;

public class UserDAOImplementation implements UserDAO{

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBook(Books book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBook(String bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean issueBook(String userEmail, String bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collectBook(String userEmail, String bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUser(String userEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean searchBookName(String bookname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void returnBook(Date returndate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean requestBook(String bookid, String userEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Request> viewAllRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptRequest(String userEmail, String bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectRequest(String userEmail, String bookId) {
		// TODO Auto-generated method stub
		return false;
	}

}
