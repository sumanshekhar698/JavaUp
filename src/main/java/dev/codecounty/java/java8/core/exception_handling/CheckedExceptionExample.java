package dev.codecounty.java.java8.core.exception_handling;

public class CheckedExceptionExample {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);// Will be checked at compile time , so must to handle this
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("HELLO");
		}

	}

}
