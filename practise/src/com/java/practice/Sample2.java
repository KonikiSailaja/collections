package com.java.practice;

import java.util.Scanner;

public class Sample2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a + b;
		System.out.println(c);
	}
}
