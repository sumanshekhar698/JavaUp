package com.sumanshekhar.java.core.collections.hashset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
	// PROS: Searching , No Duplicates
	// CONS: Takes More Space, prohibits Random Access via Indexing
	public static void main(String[] args) {

		HashSet<Integer> hashSetInteger = new HashSet();
		hashSetInteger.add(null);
		hashSetInteger.add(1);
		hashSetInteger.add(2);
		hashSetInteger.add(4);
		hashSetInteger.add(6);
		hashSetInteger.add(9);
		hashSetInteger.add(4);
		hashSetInteger.add(4);
		hashSetInteger.add(4);
		hashSetInteger.add(4);
		hashSetInteger.add(40);
		hashSetInteger.add(45);
		hashSetInteger.add(46);
		hashSetInteger.add(47);
		hashSetInteger.add(48);
		hashSetInteger.add(499);
		hashSetInteger.add(49);
		System.out.println(hashSetInteger);

		HashSet<String> hashSetStrings = new HashSet();
		hashSetStrings.add("Jan");
		hashSetStrings.add("Feb");
		hashSetStrings.add("Mar");
		hashSetStrings.add("Apr");
		hashSetStrings.add("May");
		hashSetStrings.add("June");
		hashSetStrings.remove("Mar");
		System.out.println(hashSetStrings);

//		Iterator on HashSet
		Iterator<String> iterator = hashSetStrings.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}

		ArrayList<Integer> arrayList = new <Integer>ArrayList();
		arrayList.add(4);
		arrayList.add(14);
		arrayList.add(44);
		arrayList.add(44);
		arrayList.add(44);
		arrayList.add(45);
		arrayList.add(49);
		arrayList.add(4);
		arrayList.add(433);
		Collections.sort(arrayList);
		System.out.println(arrayList);

		ArrayList<Integer> arrayList2 = new <Integer>ArrayList();
		arrayList2.add(3);
		arrayList2.add(34);
		arrayList2.add(35);
		arrayList2.add(3);

//		Converting an ArrayList to HashSet
		HashSet<Integer> hashSet = new HashSet<>(arrayList);
		System.out.println(hashSet);

//		Searching in HashSet
		boolean contains = hashSet.contains(434);// fastest among all the collections
		System.out.println(contains);

//		Extending my existing HashSet
		hashSet.addAll(arrayList2);
		System.out.println(hashSet);

	}

}
