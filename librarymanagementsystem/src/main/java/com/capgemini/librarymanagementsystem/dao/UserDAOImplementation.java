package com.capgemini.librarymanagementsystem.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystem.db.LibraryDataBase;
import com.capgemini.librarymanagementsystem.dto.Books;
import com.capgemini.librarymanagementsystem.dto.User;

import com.capgemini.librarymanagementsystem.exception.LibraryExceptions;

public class UserDAOImplementation implements UserDAO {

	@Override
	public boolean register(User user, int count) {

		boolean isAccepted = false;

		isAccepted = AdminDAOImplementation.acceptRequest(user, count);
		if (isAccepted)
			isAccepted = true;
		else
			throw new LibraryExceptions("Email already exists");

		return isAccepted;
	}

	@Override
	public boolean login(String email, String password) {

		for (User user2 : LibraryDataBase.userInfo) {
			if (user2.getEmail().equals(email) && user2.getPassword().equals(password)) {
				return true;
			}
		}
		throw new LibraryExceptions("Invalid User Login Credentials");
	}

	@Override
	public boolean searchBookName(String bookname) {

		for (Books books : LibraryDataBase.books) {
			if (books.getBookName().equals(bookname)) {
				return true;
			}
		}

		throw new LibraryExceptions("searched book is not available");
	}

	@Override
	public boolean borrowBook(String bookid, String Email) {

		for (User user4 : LibraryDataBase.userInfo) {
			if (user4.getEmail().equals(Email)) {
				for (Books book4 : LibraryDataBase.books) {
					if (book4.getBookId().equals(bookid)) {
						if (user4.getNumberOfBooks() >= 0 && user4.getNumberOfBooks() < 3) {
							user4.setNumberOfBooks(user4.getNumberOfBooks() + 1);
							book4.setIsIssued(true);
							book4.setIsReturn(false);
							return true;
						}
					}

				}
				throw new LibraryExceptions("Book does not exists");
			}
		}
		throw new LibraryExceptions("User does not exists");

	}

	@Override
	public String returnBook(Date presentDate) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 7);
		String newDate = sdf.format(c.getTime());
		return newDate;

	}
}