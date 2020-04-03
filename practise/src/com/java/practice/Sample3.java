package com.java.practice;

import java.util.Scanner;

public class Sample3 {
	public void addition() {
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
		Sample3 sample=new Sample3();
		sample.addition();
	}
}
