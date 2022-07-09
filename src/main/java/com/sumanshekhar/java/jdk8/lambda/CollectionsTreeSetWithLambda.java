package com.sumanshekhar.java.jdk8.lambda;

import java.util.TreeSet;

public class CollectionsTreeSetWithLambda {

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
		 * SET: TreeSet -> Insertion order sorted in ascending by default ; Duplicates
		 * not Allowed
		 */

		TreeSet<Integer> treeSetD = new TreeSet<Integer>();
		treeSetD.add(3);
		treeSetD.add(1);
		treeSetD.add(4);
		treeSetD.add(4);
		treeSetD.add(5);
		treeSetD.add(9);
		/*
		 * DEFAULT sorting int -> ascending ; Strings -> dictionary
		 */
		System.out.println("treeSetD sorted in ascending order by default-> " + treeSetD);

		/*
		 * CUSTOM sorting needs a custom Comparator object passed in its constructor
		 * Here we are doing it via λ
		 */
		TreeSet<Integer> treeSetCu = new TreeSet<Integer>((i, j) -> {// λ way
			return (i > j) ? -1 : (i < j) ? +1 : 0;// Up edited λ
		});

		TreeSet<Integer> treeSetC = new TreeSet<Integer>((i, j) -> (i > j) ? -1 : (i < j) ? +1 : 0);// Enhanced λ
		treeSetC.add(3);
		treeSetC.add(1);
		treeSetC.add(4);
		treeSetC.add(4);
		treeSetC.add(5);
		treeSetC.add(9);
		System.out.println("treeSetC custom sorting in descending order by passing the λ -> " + treeSetC);

	}
}
