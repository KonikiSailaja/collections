package com.capgemini.librarymanagementsystemjdbc.service;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.Admin;
import com.capgemini.librarymanagementsystemjdbc.dto.Books;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryFactory;

public class AdminServiceImplementation implements AdminService{
	
	private AdminDAO dao = LibraryFactory.getAdminDAO();
	@Override
	public boolean adminLogin(String adminEmail, String adminPassword) {
		// TODO Auto-generated method stub
		return dao.adminLogin(adminEmail, adminPassword);
	}


	@Override
	public boolean addBook(Books book) {
		// TODO Auto-generated method stub
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(String removeId) {
		// TODO Auto-generated method stub
		return dao.removeBook(removeId);
	}

	@Override
	public boolean issueBook(String userEmail, String bookId1) {
		// TODO Auto-generated method stub
		return dao.issueBook(userEmail, bookId1);
	}

	@Override
	public boolean collectBook(String userEmail1, String bookId2) {
		// TODO Auto-generated method stub
		return dao.collectBook(userEmail1,bookId2);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public boolean removeUser(String userEmail) {
		// TODO Auto-generated method stub
		return dao.removeUser(userEmail);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

}
