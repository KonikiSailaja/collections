package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.dto.Admin;
import com.capgemini.librarymanagementsystemjdbc.dto.Books;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryExceptions;

public class AdminDAOImplementation implements AdminDAO {

	@Override
	public boolean adminLogin(String adminEmail, String adminpassword) {
		// TODO Auto-generated method stub
		// Admin bean = new Admin();

		try (FileInputStream fin = new FileInputStream("db.properties")) {
			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl = pro.getProperty("dburl");
			try (Connection conn = DriverManager.getConnection(dburl)) {
				String query = pro.getProperty("auth_student");
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
					// LinkedList<Admin> bean2 = new LinkedList<Admin>();

					pstmt.setString(1, adminEmail);
					pstmt.setString(2, adminpassword);

					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						return true;
					}
					throw new LibraryExceptions("invalid email and password");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean addBook(Books book) {
		// TODO Auto-generated method stub
		try (FileInputStream fin = new FileInputStream("db.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl = pro.getProperty("dburl");
			try (Connection conn = DriverManager.getConnection(dburl)) {
				String query = pro.getProperty("add_book");
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
					pstmt.setString(1, book.getBookId());
					pstmt.setString(2, book.getBookName());
					pstmt.setString(3, book.getAuthor());
					pstmt.setString(4, book.getBookPublisher());
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					}
					throw new LibraryExceptions("book not added");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeBook(String bookid) {
		// TODO Auto-generated method stub
		try (FileInputStream fin = new FileInputStream("db.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl = pro.getProperty("dburl");
			try (Connection conn = DriverManager.getConnection(dburl)) {
				String query = pro.getProperty("remove_book");
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
					pstmt.setString(1, bookid);
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					}
					throw new LibraryExceptions("book not removed");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean issueBook(String userEmail, String bookId) {
		
		try(FileInputStream	fin = new FileInputStream("db.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl=pro.getProperty("dburl");
			try(Connection conn = DriverManager.getConnection(dburl)){
				String query = pro.getProperty("get_book");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					
					pstmt.setString(1, bookId);

					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {
						query = pro.getProperty("get_user");
						try(PreparedStatement pstmt1 = conn.prepareStatement(query)){
							
							pstmt1.setString(1, userEmail);
							pstmt1.setString(2, "user");

							ResultSet rs1 = pstmt1.executeQuery();
							if(rs1.next()) {
								query = pro.getProperty("issue_book");
								try(PreparedStatement pstmt11 = conn.prepareStatement(query)){
									pstmt11.setString(1, bookId);
									pstmt11.setString(2, userEmail );
									
									SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
								    Date date = new Date();  
								    String d1=formatter.format(date);
								    java.sql.Date dateAdded=(java.sql.Date) formatter.parse(d1);
									pstmt11.setDate(3, dateAdded);
						
									Calendar c = Calendar.getInstance();
									c.add(Calendar.DAY_OF_MONTH, 10);
									String newDate = formatter.format(c.getTime());
									java.sql.Date returndate=(java.sql.Date) formatter.parse(newDate);
									pstmt11.setDate(4,returndate);
									
									pstmt11.setInt(5, 0);
									
									int count = pstmt11.executeUpdate();
									if(count!=0) {
										return true;
									}
									throw new LibraryExceptions("book not issued");
								}	
							}
						}throw new LibraryExceptions("invalid book Id");
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}	
	@Override
	public boolean collectBook(String userEmail, String bookId) {
		
		try (FileInputStream fin = new FileInputStream("db.properties")) {
			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl = pro.getProperty("dburl");
			try (Connection conn = DriverManager.getConnection(dburl)) {
				String query = pro.getProperty("get_user");
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {

					pstmt.setString(1, userEmail);
					pstmt.setString(2, "user");

					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						query = pro.getProperty("get_book");
						try (PreparedStatement pstmt1 = conn.prepareStatement(query)) {

							pstmt1.setString(1, bookId);

							ResultSet rs1 = pstmt1.executeQuery();
							if (rs1.next()) {
								query = pro.getProperty("collect_book");
								try (PreparedStatement pstmt11 = conn.prepareStatement(query)) {
									pstmt11.setString(1, bookId);

									int count = pstmt11.executeUpdate();
									if (count != 0) {
										return true;
									}
									throw new LibraryExceptions("book not issued");
								}
							}
						}
						throw new LibraryExceptions("invalid book Id");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		return false;
	}

//	public static boolean acceptRequest(User user, int count) {
//		// TODO Auto-generated method stub
//		boolean isAdded = false;
//		if (count == 0) {
//			LibraryDatabase.userInfo.add(user);
//			isAdded = true;
//		}
//		if (count > 0) {
//			for (User user1 : LibraryDatabase.userInfo) {
//				if (user1.getEmail().equals(user.getEmail())) {
//					throw new LibraryExceptions("Email already exists");
//				}
//			}
//			LibraryDatabase.userInfo.add(user);
//			isAdded = true;
//		}
//		return isAdded;
//	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try (FileInputStream fin = new FileInputStream("db.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl = pro.getProperty("dburl");
			try (Connection conn = DriverManager.getConnection(dburl)) {
				String query = pro.getProperty("add_user");
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
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
					int count1 = pstmt.executeUpdate();
					if (count1 != 0) {
						return true;
					} else {
						throw new LibraryExceptions("User not registered");
					}
				}

			} catch (LibraryExceptions e) {
				throw new LibraryExceptions("Book Already exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean removeUser(String userEmail) {

		try (FileInputStream fin = new FileInputStream("db.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl = pro.getProperty("dburl");
			try (Connection conn = DriverManager.getConnection(dburl)) {
				String query = pro.getProperty("remove_user");
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
					pstmt.setString(1, userEmail);
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					}
					throw new LibraryExceptions("user not removed");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {

		try (FileInputStream fin = new FileInputStream("db.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			String dburl = pro.getProperty("dburl");
			try (Connection conn = DriverManager.getConnection(dburl)) {
				String query = pro.getProperty("update_user");
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
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
					pstmt.setString(11, user.getEmail());
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					}
					throw new LibraryExceptions("user not upated");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
