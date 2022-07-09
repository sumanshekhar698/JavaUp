package com.sumanshekhar.java.core.collections.generics;

import java.util.ArrayList;
import java.util.List;
//https://docs.oracle.com/javase/tutorial/extra/generics/subtype.html
public class GenericsWithInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> ls = new ArrayList<String>(); // 1
//		List<Object> lo = ls; // 2 
		
		/*
		 * Line 1 is certainly legal. The trickier part of the question is line 2. This
		 * boils down to the question: is a List of String a List of Object. Most people
		 * instinctively answer, "Sure!" Well, take a look at the next few lines:
		 */

//		lo.add(new Object()); // 3
		String s = ls.get(0); // 4: Attempts to assign an Object to a String!

	}

}
