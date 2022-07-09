package com.hackerrank.java.easy;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-exception-handling/problem
class MyCalculator {
	/*
	 * Create the method long power(int, int) here.
	 */

	long power(int a, int b) throws Exception {
		if (a < 0 || b < 0)
			throw new Exception("n or p should not be negative.");
		else if (a == 0 && b == 0)
			throw new Exception("n and p should not be zero.");

		return (long) Math.pow(a, b);

	}
}

public class JavaExceptionHandling {
	public static final MyCalculator my_calculator = new MyCalculator();
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int p = in.nextInt();

			try {
				System.out.println(my_calculator.power(n, p));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
