package dev.codecounty.java.java8.specials.lambda;

import java.util.TreeMap;

public class CollectionsTreeMapWithLambda {

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
		 * MAP: TreeMap -> Insertion order of keys sorted in ascending by default ;
		 * Duplicates keys:V will get override
		 */

		TreeMap<Integer, String> treeMapD = new TreeMap<Integer, String>();
//		HashMap<int, String> hashMap = new HashMap<int,String>();//ERROR  : int not an Object
		treeMapD.put(55, "Amrita");
		treeMapD.put(06, "Apurv");
		treeMapD.put(34, "Ashutosh");// will get override
		treeMapD.put(22, "Debayan");
		treeMapD.put(22, "Deepak");
		System.out.println("TreeMap KEYS sorted in ascending by DEFAULT -> " + treeMapD);

		/*
		 * CUSTOM sorting needs a custom Comparator object passed in its constructor
		 * Here we are doing it via λ
		 */
		TreeMap<Integer, String> treeMapC = new TreeMap<Integer, String>((i, j) -> (i > j) ? -1 : (i < j) ? 1 : 0);
		treeMapC.put(55, "Amrita");
		treeMapC.put(06, "Apurv");
		treeMapC.put(34, "Ashutosh");// will get override
		treeMapC.put(22, "Debayan");
		treeMapC.put(22, "Deepak");
		System.out.println("TreeMap KEYS sorted in ascending order in a custom fashion -> " + treeMapC);

	}
}
