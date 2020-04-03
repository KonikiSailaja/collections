package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Books;
import com.capgemini.librarymanagementsystem.dto.User;

import com.capgemini.librarymanagementsystem.factory.LibraryFactory;

public class AdminServiceImplementation implements AdminService {
	private AdminDAO dao = LibraryFactory.getAdminDAO();

	@Override
	public boolean adminLogin(String adminEmail, String adminPassword) {

		return dao.adminLogin(adminEmail, adminPassword);
	}

	@Override
	public boolean register(Admin admin) {

		return dao.register(admin);
	}

	@Override
	public boolean addBook(Books book) {

		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(String bookId) {

		return dao.removeBook(bookId);
	}

	@Override
	public boolean issueBook(String userEmail, String bookId) {

		return dao.issueBook(userEmail, bookId);
	}

	@Override
	public boolean collectBook(String userEmail, String bookId) {

		return dao.collectBook(userEmail, bookId);
	}

	@Override
	public boolean addUser(User user, int count) {

		return dao.addUser(user, count);
	}

	@Override
	public boolean removeUser(String userEmail) {

		return dao.removeUser(userEmail);
	}

	@Override
	public boolean updateUser(User user) {

		return dao.updateUser(user);
	}

}