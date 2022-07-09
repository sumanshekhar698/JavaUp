package com.sumanshekhar.java.core.basics;

public class MainUncheckedExceptionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("START");
		int x[] = { 3, 6, 7, 8, 1, 0 };

		// Unchecked Exception
		try {
			for (int i = 0; i <= x.length; i++) {
				System.out.print(x[i] + " ");
			}
			System.out.println("Marker 1");// Skipped
		} catch (Exception e) {
//			System.out.println(0 / 0);
			e.printStackTrace();
		}

		finally {
			System.out.println("END");
		}

	}
}
