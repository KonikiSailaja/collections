package com.capgemini.librarymanagement.factory;

import com.capgemini.librarymanagement.dao.UserDAO;
import com.capgemini.librarymanagement.dao.UserDAOImplementation;
import com.capgemini.librarymanagement.service.UserService;
import com.capgemini.librarymanagement.service.UserServiceImplementation;

public class LibraryFactory {
	
	public static UserDAO getUserDAO() {
		return new UserDAOImplementation();

	}

	public static UserService getUserService() {
		return new UserServiceImplementation();
	}

}
