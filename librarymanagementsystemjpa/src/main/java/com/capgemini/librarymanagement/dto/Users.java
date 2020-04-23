package com.capgemini.librarymanagement.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Users implements Serializable {
	@Column
	private String name;
	@Id
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String department;
	@Column
	private String user_id;
	@Column
	private String mobile_num;
	@Column
	private int no_of_books;
	@Column
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMobile_num() {
		return mobile_num;
	}

	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}

	public int getNo_of_books() {
		return no_of_books;
	}

	public void setNo_of_books(int no_of_books) {
		this.no_of_books = no_of_books;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Users [name=" + name + ", email=" + email + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", department=" + department + ", user_id=" + user_id + ", mobile_num="
				+ mobile_num + ", no_of_books=" + no_of_books + ", role=" + role + "]";
	}
}
