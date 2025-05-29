package dev.codecounty.java.java8.core.exception_handling;

public class ExceptionHandlingBasics2 {

	public static void main(String[] args) {

		System.out.println("START");

		int[] x = { 2, 6, 7, 8 };

		try {
			x[4] = 8 / 0;
		} catch (ArithmeticException e) {// It will be caught here because evaluation happens from left to right
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("END");
	}
}
