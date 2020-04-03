package com.capgemini.librarymanagementsystemjdbc.factory;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDAOImplementation;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemjdbc.service.AdminServiceImplementation;
import com.capgemini.librarymanagementsystemjdbc.service.UserService;
import com.capgemini.librarymanagementsystemjdbc.service.UserServiceImplementation;

public class LibraryFactory {
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImplementation();
	}

	public static AdminService getAdminService() {
		return new AdminServiceImplementation();
	}

	public static UserDAO getUserDAO() {
		return new UserDAOImplementation();

	}

	public static UserService getUserService() {
		return new UserServiceImplementation();
	}

}
