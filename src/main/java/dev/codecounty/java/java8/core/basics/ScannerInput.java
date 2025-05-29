package dev.codecounty.java.java8.core.basics;

import java.util.Scanner;

public class ScannerInput {

	public static void main(String[] args) {

//		Scanner Class [Inbuilt Class for taking input]
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Age");// this will go to next line after printing
		System.out.print("Enter your name");// this will not change the line after printing
		System.out.println();// blank empty line
//		System.out.print();//Error

//		String next = sc.next();//inputs only one word
		String next = sc.nextLine();// inputs whole sentence
		System.out.println(next);

		float height = sc.nextFloat();
		System.out.println("Height ~> " + height);
		System.out.println("Enter a number to be squared");
		int integer = sc.nextInt();
		int result = findSqr(integer);
		System.out.println(result);

		sc.close();// closing the Scanner resource

	}

	static int findSqr(int x) {// formal parameters
		int result = x * x;
		return result;
	}

}
