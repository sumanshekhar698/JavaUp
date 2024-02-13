package com.codecounty.java.core.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListUsingGenerics {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();// Generic //Default Capacity : 10
		System.out.println(a);

		ArrayList<Integer> b = new ArrayList<Integer>(6);
		// Generic Illegal Capacity: -1 when negative
		// capacity feeded

		// HInt you can create a ArryList of an ArrayList

		for (int i = 0; i < 10; i++) {
			a.add(i * i);
		}

		System.out.println(a);

		Integer integer = a.get(a.size() - 1);
		System.out.println(integer);

		a.add(999);// O(n) = n
		System.out.println(a);

//		a.clear();
		System.out.println(a);

		ArrayList<Object> c = new ArrayList<>(a);// Anything which is implement Collection
		System.out.println("ARRAYLIST c ==> " + c);

//		a.clone();
//		a.

//		a.

		Collections.rotate(a, -2);// Collections is a utility classs
		System.out.println(a);
		Collections.sort(a);
//		Collections.shuffle(a);
		System.out.println(a);

		System.out.println("Interation using a for loop");
		for (int i = 0; i < a.size(); i++) {// Worst Way
			System.out.print(a.get(i) + " ");
		}

		System.out.println("\nInteration using a for each");
		for (Integer element : a) {
			System.out.print(element + " ");
		}
		
		
		System.out.println("\n Iteration using Iterator");
		Iterator<Integer> iteratorOfa = a.iterator();
		while (iteratorOfa.hasNext()) {
			Integer integerElementFromIterator = (Integer) iteratorOfa.next();
			System.out.print(integerElementFromIterator + " ");
		}
		
		
//		int m [] ={6,	8,	9,	88,	88	,88	,90,	90,	100};
//		iteratorOfa.
	
		System.out.println("\nArraylist a");
		
		System.out.println(a);
		a.add(7,49);
		System.out.println(a);

		System.out.println("First Occurence"+a.indexOf(49));
		System.out.println("Last Occurence"+a.lastIndexOf(49));
		
		Collections.rotate(a, 4);
		System.out.println(a);
		
		
//		n times
		boolean contains = a.contains(8);
		int indexOf = a.indexOf(8);
		System.out.println(indexOf);

		
//		int []
		
		
		
		
//		Bianry Search >> WHer you can apply BS on an unsorted array
//		New Question
//		[0, 1, 4, 9, 16, 25, 36, 49, 49, 64, 81, 999]  BS to search
//		[49, 64, 81, 999, 0, 1, 4, 9, 16, 25, 36, 49]  

//		search(9)
//		unique element

//		time  (log n)
//		space O(1)
//		4
		
		
		
		
				

	}

}
