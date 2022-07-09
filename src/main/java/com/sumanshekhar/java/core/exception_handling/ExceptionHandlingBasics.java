package com.sumanshekhar.java.core.exception_handling;

public class ExceptionHandlingBasics {

	public static void main(String[] args) {

		System.out.println("START");

//		NumberFormatException
// Arithmetic Exception
		int y = 9;
		String z = "" + y;
		try {
//			int x = 6 / 0;// Unchecked
			String x = "6O";
			int parseInt = Integer.parseInt(x);
			System.out.println(parseInt);
		} catch (ArithmeticException e) {
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
