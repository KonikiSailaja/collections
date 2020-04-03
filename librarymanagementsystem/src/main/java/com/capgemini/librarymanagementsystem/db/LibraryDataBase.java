package com.capgemini.librarymanagementsystem.db;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Books;
import com.capgemini.librarymanagementsystem.dto.User;

public class LibraryDataBase {

	public static final List<User> userInfo = new LinkedList<User>();
	public static final List<Admin> admin = new LinkedList<Admin>();
	public static final List<Books> books = new LinkedList<Books>();

	static {
		Admin admin1 = new Admin();
		admin1.setadminName("kishore");
		admin1.setId("1");
		admin1.setEmail("kishore@gmail.com");
		admin1.setPassword("kishore");
		admin.add(admin1);

		Admin admin2 = new Admin();
		admin2.setadminName("krish");
		admin2.setId("2");
		admin2.setEmail("krish@gmail.com");
		admin2.setPassword("krish");
		admin.add(admin2);

	}

}
