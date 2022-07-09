package com.sumanshekhar.java.core.exception_handling;

public class ExceptionExample {

	public static void main(String[] args) {
		System.out.println("START");
		float x = (float) (9 / 0.0);// Infinity

		// Unchecked Exceptions
		System.out.println(6 / 0);// Arithmetic Exception

		int[] fibonachi = { 1, 1, 2, 3, 5 };// ArrayIndexOutOfBoundsException:
		for (int i = 0; i <= fibonachi.length; i++) {
			System.out.println(fibonachi[i]);
		}
		
		System.out.println("END");

	}
}
