package com.java.practice;

import java.util.Scanner;

public class Sample7 {

	static Scanner scanner = new Scanner(System.in);

	public static void addition() {
		System.out.println("***ADDITION***");
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a + b;
		System.out.println(c);
	}

	public static void multiplication() {
		System.out.println("***MULTIPLICATION***");
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a * b;
		System.out.println(c);
	}

	public static void division() {
		System.out.println("***DIVISION***");
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a / b;
		System.out.println(c);
	}

	public static void substraction() {
		System.out.println("***SUBSTRACTION***");
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a - b;
		System.out.println(c);
	}

	public static void main(String[] args) {
		
		Sample7.addition();
		Sample7.multiplication();
		Sample7.division();
		Sample7.substraction();

	}

}

