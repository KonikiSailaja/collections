package com.java.practice;

import java.util.Scanner;

public class Sample5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("1 is Addition");
		System.out.println("2 is Multiplication");
		System.out.println("3 is division");
		System.out.println("4 is Substraction");
        int choice;
		do {
	    choice = scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println("***ADDITION***");
			System.out.println("Enter The a value");
			int a = scanner.nextInt();
			System.out.println("Enter The b value");
			int b = scanner.nextInt();
			System.out.println("Enter The c value");
			int c = a + b;
			System.out.println(c);
			break;
		case 2:
			System.out.println("***MULTIPLICATION***");
			System.out.println("Enter The a value");
			 a = scanner.nextInt();
			System.out.println("Enter The b value");
			 b = scanner.nextInt();
			System.out.println("Enter The c value");
			 c = a * b;
			System.out.println(c);
			break;
		case 3:
			System.out.println("***DIVISION***");
			System.out.println("Enter The a value");
			 a = scanner.nextInt();
			System.out.println("Enter The b value");
			 b = scanner.nextInt();
			System.out.println("Enter The c value");
			 c = a / b;
			System.out.println(c);
			break;
		case 4:	
			System.out.println("***SUBSTRACTION***");
			System.out.println("Enter The a value");
			 a = scanner.nextInt();
			System.out.println("Enter The b value");
			 b = scanner.nextInt();
			System.out.println("Enter The c value");
			 c = a - b;
			System.out.println(c);
			break;
		default:
			System.out.println("check your input");
			break;
	 }
		
    }while(choice!=0);
        
  }
	   
}

