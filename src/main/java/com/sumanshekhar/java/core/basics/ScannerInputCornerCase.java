package com.sumanshekhar.java.core.basics;

import java.util.Scanner;

public class ScannerInputCornerCase {

	public static void main(String[] args) {

//		Scanner Class [Inbuilt]
		System.out.println("START");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the age");
		int age = sc.nextInt();
		System.out.println("AGE -> " + age);

		System.out.println("Enter the name");
		sc.nextLine();// Flushing
		String name = sc.nextLine();
		System.out.println("NAME -> " + name);

		System.out.println("END");

	}

}
