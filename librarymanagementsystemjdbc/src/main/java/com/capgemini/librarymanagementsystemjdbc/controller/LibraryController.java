package com.capgemini.librarymanagementsystemjdbc.controller;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemjdbc.dto.Books;
import com.capgemini.librarymanagementsystemjdbc.dto.User;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryExceptions;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryFactory;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemjdbc.service.UserService;
import com.capgemini.librarymanagementsystemjdbc.validation.LibraryValidation;

public class LibraryController {

	static int count = 0;

	public static void main(String[] args) {

		LibraryController controller = new LibraryController();

		try {
			controller.operations();
		} catch (InputMismatchException e) {
			System.out.println("Enter valid data");
		} finally {
			try {
				controller.operations();
			} catch (InputMismatchException e) {
				System.out.println("Enter valid data");
			} finally {
				controller.operations();
			}
		}
	}

	public void operations() {

		LibraryValidation validate = new LibraryValidation();

		try {

			Scanner sc = new Scanner(System.in);
			int choice = 0;
			do {
				System.out.println("press 1 to Admin");
				System.out.println("press 2 to user");
				System.out.println("press 3 to register");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter Admin Mail ID");
					String adminEmail = sc.next();
					System.out.println("Enter Admin Password");
					String adminPwd = sc.next();

					AdminService adminService = LibraryFactory.getAdminService();
					boolean adminInfo = false;
					try {
						adminInfo = adminService.adminLogin(adminEmail, adminPwd);
					} catch (LibraryExceptions e) {
						System.err.println(e.getMessage());
						break;
					}

					if (adminInfo == true) {
						System.out.println("Login Successfull");
						int choice1;
						do {
							System.out.println("press 0 to Terminate");
							System.out.println("press 1 to AddBook");
							System.out.println("press 2 to RemoveBook");
							System.out.println("press 3 to IssueBook");
							System.out.println("press 4 to CollectBook");
							System.out.println("press 5 to AddUser");
							System.out.println("press 6 to RemoveUser");
							System.out.println("press 7 to UpdateUser");
							System.out.println("Enter your choice");

							choice1 = sc.nextInt();
							switch (choice1) {

							case 1:
								Books book = new Books();
								try {
									System.out.println("Enter the 6 digit Book Id");
									String bookId = sc.next();
									if (validate.validateId(bookId))
										book.setBookId(bookId);
									System.out.println("Enter Book Name");
									String bookName = sc.next();
									if (validate.validateName(bookName))
										book.setBookName(bookName);
									System.out.println("Enter Author Name");
									String authorName = sc.next();
									if (validate.validateName(authorName))
										book.setAuthor(authorName);
									System.out.println("Enter Publishers Name");
									String bookPublisher = sc.next();
									if (validate.validateName(authorName))
										book.setBookPublisher(bookPublisher);

									boolean res = false;

									res = adminService.addBook(book);
									if (res) {
										System.out.println("Book successfully added");
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;
							case 2:
								System.out.println("Enter Id To Remove The Book");
								String removeId = sc.next();
								if (validate.validateId(removeId)) {
								}
								boolean remove = false;
								try {
									remove = adminService.removeBook(removeId);
									if (remove) {
										System.out.println("Book Removed Successfully");
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;

							case 3:
								try {
									System.out.println("Enter the User Email Id");
									String userEmail = sc.next();
									if (validate.validateEmail(userEmail)) {
									}
									System.out.println("Enter the Book Id to issue book");
									String bookId1 = sc.next();
									if (validate.validateId(bookId1)) {
									}
									boolean issued = false;

									issued = adminService.issueBook(userEmail, bookId1);
									if (issued) {
										System.out.println("Book Issued Successfully");
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;
							case 4:
								try {
									System.out.println("Enter the User Mail Id");
									String userEmail1 = sc.next();
									if (validate.validateEmail(userEmail1)) {
									}
									System.out.println("Enter The Book Id To Return");
									String bookId2 = sc.next();
									if (validate.validateId(bookId2)) {
									}
									boolean collected = false;

									collected = adminService.collectBook(userEmail1, bookId2);
									if (collected) {
										System.out.println("Book Collected Successfully");
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;
							case 5:
								try {
									User user = new User();
									System.out.println("Enter Email");
									String email = sc.next();
									if (validate.validateEmail(email))
										user.setEmail(email);
									System.out.println("Enter the 6 digit password");
									String password1 = sc.next();
									if (validate.validatePassword(password1))
										user.setPassword(password1);
									System.out.println("Enter User Name");
									String userName = sc.next();
									if (validate.validateName(userName))
										user.setUserName(userName);
									System.out.println("Enter The First Name");
									String firstName = sc.next();
									if (validate.validateName(firstName))
										user.setFirstName(firstName);
									System.out.println("Enter The Last Name");
									String lastName = sc.next();
									if (validate.validateName(lastName))
										user.setLastName(lastName);
									System.out.println("Enter The Department");
									String department = sc.next();
									if (validate.validateName(department))
										user.setDepartment(department);
									System.out.println("Enter The 6 digit User Id");
									String userId1 = sc.next();
									if (validate.validateId(userId1))
										user.setUserId(userId1);
									System.out.println("Enter The Mobile Number");
									String mobileNumber = sc.next();
									if (validate.validateMobileNumber(mobileNumber))
										user.setMobileNum(mobileNumber);
									System.out.println("Enter The Number Of Books");
									int numberOfBooks = sc.nextInt();
									user.setNumberOfBooks(numberOfBooks);

									boolean admininfo1 = false;
									admininfo1 = adminService.addUser(user);
									if (admininfo1) {
										System.out.println("User successfully added");
										count++;
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;
							case 6:
								try {
									System.out.println("Enter Email Id To Remove User");
									String userEmail2 = sc.next();
									if (validate.validateEmail(userEmail2)) {
									}
									boolean remove1 = false;

									remove1 = adminService.removeUser(userEmail2);
									if (remove1) {
										System.out.println("User Removed Successfully");
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;
							case 7:
								User user5 = new User();
								try {
									System.out.println("Enter Email");
									String email1 = sc.next();
									if (validate.validateEmail(email1))
										user5.setEmail(email1);
									System.out.println("Enter the 6 digit password");
									String password2 = sc.next();
									if (validate.validatePassword(password2))
										user5.setPassword(password2);
									System.out.println("Enter User Name");
									String userName1 = sc.next();
									if (validate.validateName(userName1))
										user5.setUserName(userName1);
									System.out.println("Enter The First Name");
									String firstName1 = sc.next();
									if (validate.validateName(firstName1))
										user5.setFirstName(firstName1);
									System.out.println("Enter The Last Name");
									String lastName1 = sc.next();
									if (validate.validateName(lastName1))
										user5.setLastName(lastName1);
									System.out.println("Enter The Department");
									String department1 = sc.next();
									if (validate.validateName(department1))
										user5.setDepartment(department1);
									System.out.println("Enter The 6 digit User Id");
									String userId3 = sc.next();
									if (validate.validateId(userId3))
										user5.setUserId(userId3);
									System.out.println("Enter The Mobile Number");
									String mobileNumber1 = sc.next();
									if (validate.validateMobileNumber(mobileNumber1))
										user5.setMobileNum(mobileNumber1);
									System.out.println("Enter The Number Of Books");
									int numberOfBooks1 = sc.nextInt();
									user5.setNumberOfBooks(numberOfBooks1);

									boolean admininfo2 = false;
									admininfo2 = adminService.updateUser(user5);
									if (admininfo2) {
										System.out.println("User successfully Updated");
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;
							}

						} while (choice1 != 0);
						break;
					}
				case 2:
					System.out.println("Enter User Mail Id");
					String userMail = sc.next();
					System.out.println("Enter User Password");
					String userPwd = sc.next();

					UserService service1 = LibraryFactory.getUserService();
					boolean userInfo = false;
					try {
						userInfo = service1.login(userMail, userPwd);
					} catch (LibraryExceptions e) {
						System.err.println(e.getMessage());
						break;
					}

					if (userInfo == true) {
						System.out.println("Login Successfull");
						int choice2;
						do {
							System.out.println("press 0 to Terminate");
							System.out.println("Press 1 to search for book");
							System.out.println("Press 2 to borrow book");
							System.out.println("Enter your choice");
							choice2 = sc.nextInt();

							switch (choice2) {
							case 1:
								try {
									System.out.println("Enter book name");
									String name = sc.next();
									if (validate.validateName(name)) {
									}

									boolean result = service1.searchBookName(name);
									if (result) {
										System.out.println("Book is present");
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;
							case 2:
								try {
									System.out.println("Enter book id");
									String id = sc.next();
									if (validate.validateId(id)) {
									}
									System.out.println("Enter User Email id");
									String userEmailId = sc.next();
									if (validate.validateEmail(userEmailId)) {
									}
									Date presentDate = new Date();
// System.out.println("Present date="+presentDate);

									boolean res = service1.borrowBook(id, userEmailId);
									if (res) {
										System.out.println("Book is borrowed");
										//String returnDate = service1.returnBook(presentDate);
										//System.out.println("The book should be borrowed by " + returnDate);
									}
								} catch (LibraryExceptions e) {
									System.err.println(e.getMessage());
								}
								break;

							}
						} while (choice2 != 0);
						break;
					}
				case 3:
					UserService service2 = LibraryFactory.getUserService();
					User information = new User();
					try {
						System.out.println("Enter the 6 digit User Id");
						String regId = sc.next();
						if (validate.validateId(regId))
							information.setUserId(regId);
						System.out.println("Enter Username");
						String regUserName = sc.next();
						if (validate.validateName(regUserName))
							information.setUserName(regUserName);
						System.out.println("Enter the 6 digit Password");
						String regPassword = sc.next();
						if (validate.validatePassword(regPassword))
							information.setPassword(regPassword);
						System.out.println("Enter Firstname");
						String regFirstName = sc.next();
						if (validate.validateName(regFirstName))
							information.setFirstName(regFirstName);
						System.out.println("Enter Lastname");
						String regLastName = sc.next();
						if (validate.validateName(regLastName))
							information.setLastName(regLastName);
						System.out.println("Enter Department");
						String regDepartment = sc.next();
						if (validate.validateName(regDepartment))
							information.setDepartment(regDepartment);
						System.out.println("Enter Email");
						String regEmail = sc.next();
						if (validate.validateEmail(regEmail))
							information.setEmail(regEmail);
						System.out.println("Enter MobileNumber");
						String mobileNumber = sc.next();
						if (validate.validateMobileNumber(mobileNumber))
							information.setMobileNum(mobileNumber);
						System.out.println("Enter NoOfBooks");
						int noOfBooks = sc.nextInt();
						information.setNumberOfBooks(noOfBooks);

						boolean check1 = false;
						check1 = service2.register(information);
						if (check1) {
							System.out.println("Admin Registered the user successfully");
							count++;
						}
					} catch (LibraryExceptions e) {
						System.err.println(e.getMessage());
					}
					break;

				default:
					break;
				}
			} while (choice != 0);
		} catch (IllegalArgumentException e) {
			
			System.err.println(e.getMessage());

		}

	}

}
