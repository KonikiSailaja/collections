package com.java.practice;

import java.util.Scanner;

public class Sample4 {
	public static void addition() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The a value");
		int a = scanner.nextInt();
		System.out.println("Enter The b value");
		int b = scanner.nextInt();
		System.out.println("Enter The c value");
		int c = a + b;
		System.out.println(c);
	}
	public static void main(String[] args) {
		Sample4.addition();
	}
}
