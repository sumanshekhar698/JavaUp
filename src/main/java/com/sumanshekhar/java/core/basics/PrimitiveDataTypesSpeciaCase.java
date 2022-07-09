package com.sumanshekhar.java.core.basics;

public class PrimitiveDataTypesSpeciaCase {

	public static void main(String[] args) {

		System.out.println(Byte.MAX_VALUE);
		byte b = 127;// range is checked
		b += 2;
//		b= b+1;
		System.out.println(b);// -127
		
//		Static type language advantage is fast and stable execution
		int x =9;
		float m = x;
	
//		JDK 10/11 we have dynamic type option
//		var x =9;
//		var g = x;

	}

}
