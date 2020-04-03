package com.java.practice;

import java.util.Scanner;

public class Sample6 {
	Scanner scanner = new Scanner(System.in);

	public void addition() {
		System.out.println("***ADDITION***");
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a + b;
		System.out.println(c);
	}

	public void multiplication() {
		System.out.println("***MULTIPLICATION***");
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a * b;
		System.out.println(c);
	}

	public void division() {
		System.out.println("***DIVISION***");
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a / b;
		System.out.println(c);
	}

	public void substraction() {
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
		Sample6 sample = new Sample6();
		sample.addition();
		sample.multiplication();
		sample.division();
		sample.substraction();

	}
}
