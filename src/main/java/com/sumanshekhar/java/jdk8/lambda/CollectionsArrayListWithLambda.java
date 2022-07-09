package com.sumanshekhar.java.jdk8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsArrayListWithLambda {

	public static void main(String[] args) {

		/*
		 * COMPARATOR Functional Interface: public int compare(Object1 , Object2). This
		 * interface is used to define our custom sorting algo
		 */

		/*
		 * public int compare(obj1 , obj2). { • return -ve: if obj1 comes before obj2 •
		 * return +ve: if obj1 comes after obj2 • return 0: if obj1 == obj2 }
		 */

		/*
		 * LIST: ArrayList -> Insertion order preserved ; Duplicates Allowed
		 */

		ArrayList<Integer> integerList = new ArrayList<Integer>();
		integerList.add(3);
		integerList.add(1);
		integerList.add(4);
		integerList.add(5);
		integerList.add(9);
		System.out.println("integerList before sorting -> " + integerList);
		/*
		 * DEFAULT sorting int -> ascending Strings -> dictionary
		 */
		Collections.sort(integerList);
		System.out.println("integerList after DEFAULT sorting -> " + integerList);

		/*
		 * CUSTOM sorting need a custom Comparator object
		 */
//		Collections.sort(integerList, new MyCustomComparator());
		Collections.sort(integerList, new MyCustomComparatorTernary());// using Ternary

		Collections.sort(integerList, (i, j) -> {// λ way
			return (i > j) ? -1 : (i < j) ? +1 : 0;
		});
		Collections.sort(integerList, (i, j) -> (i > j) ? -1 : (i < j) ? +1 : 0);// Optimized λ
		System.out.println("integerList after CUSTOM [descending] sorting -> " + integerList);

//		integerList.sort(null)
	}

}

class MyCustomComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer i, Integer j) {
		if (i > j)
			return -1;
		else if (i < j)
			return +1;
		else
			return 0;
	}
}

class MyCustomComparatorTernary implements Comparator<Integer> {

	@Override
	public int compare(Integer i, Integer j) {
		return (i > j) ? -1 : (i < j) ? +1 : 0;
	}
}
