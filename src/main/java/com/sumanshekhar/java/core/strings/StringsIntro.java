package com.sumanshekhar.java.core.strings;

public class StringsIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String is just a sequence of characters

		char[] charArray = { 'D', 'O', 'B' };

		String a = "DOB";// String Literal
		String c = "DOB";
		

		String b = new String(charArray);// Declaration using new keyword
//		string="Shekhar";
		String d = new String("DOB");

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		System.out.println(d);

		if (a == c)// == will not compare the contents of String, It will just compare the memory
					// address
			System.out.println("SAME1");

		if (b == d)
			System.out.println("SAME2");
		

		if (a == d)
			System.out.println("SAME2.5");

		if (a.equals(c))// == will not compare the contents of String, It will just compare the memory
			// address
			System.out.println("SAME3");

		if (b.equals(d))
			System.out.println("SAME4");

	}

}
