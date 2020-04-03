package com.capgemini.librarymanagementsystem.dao;

import com.capgemini.librarymanagementsystem.db.LibraryDataBase;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Books;
import com.capgemini.librarymanagementsystem.dto.User;

import com.capgemini.librarymanagementsystem.exception.LibraryExceptions;

public class AdminDAOImplementation implements AdminDAO {

	@Override
	public boolean adminLogin(String adminEmail, String adminpassword) {

		for (Admin admin1 : LibraryDataBase.admin) {
			if (admin1.getEmail().equals(adminEmail) && admin1.getPassword().equals(adminpassword)) {
				return true;
			}
		}
		throw new LibraryExceptions("Invalid Login Credentials");
	}

	@Override
	public boolean register(Admin admin) {

		boolean check = false;
		for (Admin admin2 : LibraryDataBase.admin) {
			if (admin2.getEmail().equals(admin.getEmail())) {
				return false;
			} else {
				check = true;
			}
		}
		if (check == true) {
			LibraryDataBase.admin.add(admin);
			return check;
		} else {
			throw new LibraryExceptions("Email already exists");
		}
	}

	@Override
	public boolean addBook(Books book) {

		for (Books book1 : LibraryDataBase.books) {
			if (book1.getBookId().equals(book.getBookId())) {
				throw new LibraryExceptions("Book already exists");
			}
		}
		LibraryDataBase.books.add(book);
		return true;
	}

	@Override
	public boolean removeBook(String bookid) {

		for (Books book3 : LibraryDataBase.books) {
			if (book3.getBookId().equals(bookid)) {
				LibraryDataBase.books.remove(book3);
				return true;
			}
		}
		throw new LibraryExceptions("Book does not exists to remove");

	}

	@Override
	public boolean issueBook(String userEmail, String bookId) {

		for (User user4 : LibraryDataBase.userInfo) {
			if (user4.getEmail().equals(userEmail)) {
				for (Books book4 : LibraryDataBase.books) {
					if (book4.getBookId().equals(bookId) && (book4.getIsIssued() == false))
						if (user4.getNumberOfBooks() >= 0 && user4.getNumberOfBooks() < 3) {
							user4.setNumberOfBooks(user4.getNumberOfBooks() + 1);
							book4.setIsIssued(true);
							book4.setIsReturn(false);
							book4.setUserEmail(userEmail);
							return true;
						}
				}
			}
		}
		throw new LibraryExceptions("Book Not Issued");
	}

	@Override
	public boolean collectBook(String userEmail, String BookId) {

		for (User user4 : LibraryDataBase.userInfo) {
			if (user4.getEmail().equals(userEmail)) {
				for (Books book4 : LibraryDataBase.books) {
					if (book4.getBookId().equals(BookId)) {
						if (book4.getIsIssued() == true && book4.getIsReturn() == false
								&& book4.getUserEmail().equals(userEmail)) {
							book4.setIsReturn(true);
							book4.setIsIssued(false);
							user4.setNumberOfBooks(user4.getNumberOfBooks() - 1);
							return true;
						}
						throw new LibraryExceptions("Book did not issued");
					}
				}
				throw new LibraryExceptions("Book not exists");
			}
		}
		throw new LibraryExceptions("User does not exists");

	}

	public static boolean acceptRequest(User user, int count) {
		boolean isAdded = false;
		if (count == 0) {
			LibraryDataBase.userInfo.add(user);
			isAdded = true;
		}
		if (count > 0) {
			for (User user1 : LibraryDataBase.userInfo) {
				if (user1.getEmail().equals(user.getEmail())) {
					throw new LibraryExceptions("Email already exists");

				}
			}
			LibraryDataBase.userInfo.add(user);
			isAdded = true;
		}

		return isAdded;

	}

	public boolean addUser(User user, int count) {
		boolean isAdded = false;
		if (count == 0) {
			LibraryDataBase.userInfo.add(user);
			isAdded = true;
		}
		if (count > 0) {
			for (User user1 : LibraryDataBase.userInfo) {
				if (user1.getEmail().equals(user.getEmail())) {
					throw new LibraryExceptions("Email already exists");

				}
			}
			LibraryDataBase.userInfo.add(user);
			isAdded = true;
		}

		return isAdded;
	}

	@Override
	public boolean removeUser(String userEmail) {
		for (User user2 : LibraryDataBase.userInfo) {
			if (user2.getEmail().equals(userEmail)) {
				LibraryDataBase.userInfo.remove(user2);
				return true;
			}
		}
		throw new LibraryExceptions("User does not Exists to remove");
	}

	@Override

	public boolean updateUser(User user) {
		boolean isUpdated = false;
		for (User user3 : LibraryDataBase.userInfo) {
			if (user3.getEmail().equals(user.getEmail())) {
				user3 = user;
				return true;
			}
		}
		throw new LibraryExceptions("User does not exists to update");
	}

}