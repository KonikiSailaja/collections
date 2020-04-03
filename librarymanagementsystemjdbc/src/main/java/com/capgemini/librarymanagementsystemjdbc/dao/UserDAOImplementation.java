package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryExceptions;

public class UserDAOImplementation implements UserDAO{

	@Override
	public boolean register(User user) {
		try(FileInputStream	fin = new FileInputStream("db.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl=pro.getProperty("dburl");
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query = pro.getProperty("add_user");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, user.getUserName());
					pstmt.setString(2, user.getEmail());
					pstmt.setString(3, user.getPassword());
					pstmt.setString(4, user.getFirstName());
					pstmt.setString(5, user.getLastName());
					pstmt.setString(6, user.getDepartment());
					pstmt.setString(7, user.getUserId());
					pstmt.setString(8, user.getMobileNum());
					pstmt.setInt(9, 0);
					pstmt.setString(10, "user");
					
					int count = pstmt.executeUpdate();
					if(count!=0) {
						return true;
					}	
				} throw new LibraryExceptions("user not registered");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean login(String email, String password) {
		//User bean = new User(); 
		try(FileInputStream fin = new FileInputStream("db.properties")){
			Properties pro = new Properties();
			pro.load(fin);
			Class.forName(pro.getProperty("path")).newInstance();
			String dburl=pro.getProperty("dburl");
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query = pro.getProperty("auth_student");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){ 
					pstmt.setString(1, email);
					pstmt.setString(2, password); 

					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {
						return true;
					}else {
						throw new LibraryExceptions("invalid email and password");	
					}
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean searchBookName(String bname) {
		//Books bean = new Books();
		try(FileInputStream	fin = new FileInputStream("db.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("search_book_name");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, bname);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {	
						return true;
					} throw new LibraryExceptions("Book Not Found");
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean requestBook(String bookid, String userEmail) {
		try(FileInputStream	fin = new FileInputStream("db.properties")){

			Properties pro = new Properties();
			pro.load(fin);
			Class.forName(pro.getProperty("path")).newInstance();
			String dburl=pro.getProperty("dburl");
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query = pro.getProperty("request_book");
				try(Statement stmt = conn.createStatement()){	
					int count= stmt.executeUpdate(query);
					if(count!=0) {
						return true;
					}
					throw new LibraryExceptions("Request not sent");
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}	
	@Override
	public void returnBook(Date returndate) {
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public boolean borrowBook(String bookId, String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	
}