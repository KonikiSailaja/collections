package com.capgemini.librarymanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.librarymanagement.exception.LibraryExceptions;




public class LibraryValidation {
	public boolean validateId(String id) {
		Pattern pattern = Pattern.compile("[0-9]{6}");
		Matcher matcher = pattern.matcher(id);
		if (matcher.matches())
			return true;
		else
			throw new IllegalArgumentException("Enter Valid Id");
	}

	public boolean validateName(String name) {
		Pattern pattern = Pattern.compile("[a-zA-Z]*");
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches())
			return true;
		else
			throw new IllegalArgumentException("Enter Valid Name");
	}

	public boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*@[a-zA-Z]*+([.][a-zA-Z]+)+");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches())
			return true;
		else
			throw new IllegalArgumentException("Enter Valid Email Id");
	}

	public boolean validatePassword(String pwd) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]{6}");
		Matcher matcher = pattern.matcher(pwd);
		if (matcher.matches())
			return true;
		else
			throw new IllegalArgumentException("Enter Valid Password");

	}
	public boolean validateMobileNumber(String mobileNumber) {
		
			Pattern pattern=Pattern.compile("[0-9]{10}");
			Matcher matcher=pattern.matcher(mobileNumber);
			if(matcher.matches())
			return true;
			else
			throw new LibraryExceptions("Enter Valid Mobile Number");
			}

}
