package com.sumanshekhar.java.core.strings;

public class StringMethods {

	public static void main(String[] args) {

		String x = "YhilLs";
		String u = "yhills";

		if (x.equals(u)) {// compares contents [Case Sensitive]
			System.out.println("SAME1");
		}

		if (x.equalsIgnoreCase(u)) {// compares contents [Case Insensitive]
			System.out.println("SAME2");
		}

		System.out.println(u.length());// Returns the length
		String a = "Dora";
		String b = "Mon";
		String c = a + b;// + operator is overloaded, it can add numbers, and it can concatenate string
		System.out.println(c);

//		c=a*b;

		int num = 6;
		boolean bool = false;

		String numString = "" + num;// convert any literal to String
		String boolString = "" + b;

		System.out.println("5" + 6 + "0");// 560
		System.out.println("5" + "6" + "0");// 560
		System.out.println("5" + 6 + 0);// 560
		System.out.println(5 + 6 + "0");// 110
		System.out.println("0" + 7 * 2);// 014
		System.out.println(0 + 7 * 2);// 14

		System.out.println(x.contains("ih"));// checks if it contains the supplied sample or not
		System.out.println(x.charAt(0));// Returns character at specified index
		System.out.println(x.indexOf("hi"));// Returns index of specified String if found else returns -1
		System.out.println(x.substring(2));// Used to extract a specified piece of String
		System.out.println(x.substring(2, 5));

	}

}
