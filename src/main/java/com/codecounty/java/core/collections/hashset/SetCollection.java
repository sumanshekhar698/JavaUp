package com.codecounty.java.core.collections.hashset;

import java.util.*;

class SetCollection {

	public static void main(String[] args) {
		// HashSet
		System.out.println("\n\n+++++++++++++++++HashSet++++++++++++++++");

		// Instantiate an object of HashSet
		HashSet<ArrayList> set = new HashSet<>();

		// create ArrayList list1
		ArrayList<Integer> list1 = new ArrayList<>();

		// create ArrayList list2
		ArrayList<Integer> list2 = new ArrayList<>();

		// Add elements using add method
		list1.add(1);
		list1.add(2);
		list2.add(1);
		list2.add(2);
		set.add(list1);
		set.add(list2);

		// print the set size to understand the
		// internal storage of ArrayList in Set
		System.out.println(set.size());// 1 instead of 2 because
		/*
		 * Before storing an Object, HashSet checks whether there is an existing entry
		 * using hashCode() and equals() methods. In the above example, two lists are
		 * considered equal if they have the same elements in the same order. When you
		 * invoke the hashCode() method on the two lists, they both would give the same
		 * hash since they are equal.
		 */
		// Creating an empty HashSet

		HashSet<String> h = new HashSet<String>();

		// Adding elements into HashSet
		// usind add() method
		h.add("India");
		h.add("Australia");
		h.add("South Africa");

		// Adding duplicate elements
		h.add("India");

		// Displaying the HashSet
		System.out.println(h);
		System.out.println("List contains India or not:" + h.contains("India"));

		// Removing items from HashSet
		// using remove() method
		h.remove("Australia");
		System.out.println("List after removing Australia:" + h);

		// Display message
		System.out.println("Iterating over list:");

		// Iterating over hashSet items
		Iterator<String> i = h.iterator();

		// Holds true till there is single element remaining
		while (i.hasNext())
			// Iterating over elements
			// using next() method
			System.out.println(i.next());

		// LinkedHashSet
		System.out.println("\n\n+++++++++++++++++LinkedHashSet++++++++++++++++");
		// Creating an empty LinkedHashSet of string type
		LinkedHashSet<String> linkedset = new LinkedHashSet<String>();

		// Adding element to LinkedHashSet
		// using add() method
		linkedset.add("A");
		linkedset.add("B");
		linkedset.add("C");
		linkedset.add("D");

		// Note: This will not add new element
		// as A already exists
		linkedset.add("A");
		linkedset.add("E");

		// Getting size of LinkedHashSet
		// using size() method
		System.out.println("Size of LinkedHashSet = " + linkedset.size());

		System.out.println("Original LinkedHashSet:" + linkedset);

		// Removing existing entry from above Set
		// using remove() method
		System.out.println("Removing D from LinkedHashSet: " + linkedset.remove("D"));

		// Removing existing entry from above Set
		// that does not exist in Set
		System.out.println("Trying to Remove Z which is not " + "present: " + linkedset.remove("Z"));

		// Checking for element whether it is present inside
		// Set or not using contains() method
		System.out.println("Checking if A is present=" + linkedset.contains("A"));

		// Noew lastly printing the updated LinekdHashMap
		System.out.println("Updated LinkedHashSet: " + linkedset);
		// LinkedHashSet
		System.out.println("\n\n+++++++++++++++++TreeSet++++++++++++++++");
		SortedSet<String> ts = new TreeSet<String>();

		// Adding elements into the TreeSet
		// using add()
		ts.add("India");
		ts.add("Australia");
		ts.add("South Africa");

		// Adding the duplicate
		// element
		ts.add("India");

		// Displaying the TreeSet
		System.out.println(ts);

		// Removing items from TreeSet
		// using remove()
		ts.remove("Australia");
		System.out.println("Set after removing " + "Australia:" + ts);

		// Iterating over Tree set items
		System.out.println("Iterating over set:");
		Iterator<String> iTree = ts.iterator();
		while (iTree.hasNext())
			System.out.println(iTree.next());

		// create tree set object
		TreeSet<Integer> treeadd = new TreeSet<Integer>();

		// populate the TreeSet using add() method
		treeadd.add(10);
		treeadd.add(20);
		treeadd.add(30);
		treeadd.add(40);

		// Print the TreeSet
		System.out.println("TreeSet: " + treeadd);

		// create descending iterator
		// using descendingIterator() method
		Iterator<Integer> iterator = treeadd.descendingIterator();

		System.out.println("\nValues using DescendingIterator:");

		// printing the integrated value
		while (iterator.hasNext()) {
			System.out.println("Value : " + iterator.next());
		}

	}
}