package dev.codecounty.java.java8.core.exception_handling;

public class TryFinally {

	public static void main(String[] args) {

		try {
			int x = 7 / 0;
		} finally {
			System.out.println("Finally Exceuted");
		}

	}
}
