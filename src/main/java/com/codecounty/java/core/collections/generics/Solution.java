package com.codecounty.java.core.collections.generics;

import java.lang.reflect.Method;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Printer myPrinter = new Printer();
		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = { "Hello", "World" };
		myPrinter.printArray(intArray);
		myPrinter.printArray(stringArray);
		int count = 0;

		for (Method method : Printer.class.getDeclaredMethods()) {
			String name = method.getName();

			if (name.equals("printArray"))
				count++;
		}

		if (count > 1)
			System.out.println("Method overloading is not allowed!");
	}
}

class Printer {

	/*
	 * To use generics, we change each int into a T. Now the T can represent a
	 * generic type, such as Long, Double, Byte, or objects we make such as Teacher,
	 * Box, Airplaine, etc. For example, our new method can print out an array of
	 * Teachers. We no longer need to make a separate function for each type of
	 * information that we want to print.
	 * 
	 * We also add the T (with brackets) before the void which is just syntax to
	 * indicate that our function works with generic types.
	 */
	
	/*
	 * Generics have it's own naming convention:
	 * 
	 * T: Type E: Element V: Value K: Key N: Number
	 */
	public <T> void printArray(T[] array) {
		for (T item : array)
			System.out.println(item);
	}

	static <T> void printArray(T data) {
		System.out.println(data);
	}
}
