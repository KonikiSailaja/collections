package com.java.practice;

public class Pattern11 {
	public static void main(String[] args) {
		for(int i=5;i>=1;i--) {
		for(int a=i;a>1;a--) {
			System.out.print(" ");
		}
		for(int j=5;j>=i;j--) {
			System.out.print("*");
		}
		System.out.println();
		}
	}
}	

