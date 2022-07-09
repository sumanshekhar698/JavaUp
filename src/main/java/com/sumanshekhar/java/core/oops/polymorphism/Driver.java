package com.sumanshekhar.java.core.oops.polymorphism;

public class Driver {

	public static void main(String[] args) {
//		Method Overloading
		MathOperations mathOperations = new MathOperations();
		System.out.println(mathOperations.area(10.0f));
		System.out.println(mathOperations.area(10));
		System.out.println(mathOperations.area(10,8));
		
	}

}
