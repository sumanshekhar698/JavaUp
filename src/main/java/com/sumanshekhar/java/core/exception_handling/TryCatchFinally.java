package com.sumanshekhar.java.core.exception_handling;

import java.util.Scanner;

public class TryCatchFinally {

	public static void main(String[] args) {
		System.out.println("START");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter you age");
		int age = scanner.nextInt();
		int m;
		try {
			int y = 100 / age;
			System.out.println(y);
		} catch (Exception e) {
			System.exit(1);
			m = 7 / 0;
			e.printStackTrace();
		} finally {
			scanner.close();
			System.out.println("CLOSED");
		}

		System.out.println("END");

	}

}
