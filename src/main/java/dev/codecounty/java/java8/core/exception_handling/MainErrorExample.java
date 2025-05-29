package dev.codecounty.java.java8.core.exception_handling;

public class MainErrorExample {
	static long counter = 0;

	public static void main(String[] args) {

		System.out.println("START");
		call();
		System.out.println("END");
	}

	private static void call() {// Uncontrolled Recursion
		System.out.println(++MainErrorExample.counter);
		call();
	}

}
