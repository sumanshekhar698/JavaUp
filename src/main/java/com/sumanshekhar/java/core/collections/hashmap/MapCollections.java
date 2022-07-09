package com.sumanshekhar.java.core.collections.hashmap;

import java.util.*;

public class MapCollections {

	public static void main(String[] args) {
//HASH MAP
		System.out.println("\n\n+++++++++++++++++HashMap++++++++++++++++");
		// Create an empty hash map by declaring object
		// of string and integer type
		HashMap<String, Integer> map = new HashMap<>(10, 0.75f);

		// Adding elements to the Map
		// using standard add() method
		map.put("vishal", 10);
		map.put("sachin", 30);
		map.put("vaibhav", 20);
		map.remove("vaibhav");
		// Print size and content of the Map
		System.out.println("Size of map is:- " + map.size());

		// Printing elements in object of Map
		System.out.println(map);

		// Checking if a key is present and if
		// present, print value by passing
		// random element
		if (map.containsKey("vishal")) {

			// Mapping
			Integer a = map.get("vishal");

			// Printing value fr the corresponding key
			System.out.println("value for key" + " \"vishal\" is:- " + a);

		}

//		Traversing the Map
		for (Map.Entry<String, Integer> e : map.entrySet())
			System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());

//		LinkedHashMap
		System.out.println("\n\n+++++++++++++++++LinkedHashMap++++++++++++++++");
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();

		// Adding entries in Map
		// using put() method
		lhm.put("one", "practice.geeksforgeeks.org");
		lhm.put("two", "code.geeksforgeeks.org");
		lhm.put("four", "quiz.geeksforgeeks.org");

		// Printing all entries inside Map
		System.out.println(lhm);

		// Note: It prints the elements in same order
		// as they were inserted

		// Getting and printing value for a specic key
		System.out.println("Getting value for key 'one': " + lhm.get("one"));

		// Getting size of Map using size() method
		System.out.println("Size of the map: " + lhm.size());

		// Checking whether Map is empty or not
		System.out.println("Is map empty? " + lhm.isEmpty());

		// Using containsKey() method to check for a key
		System.out.println("Contains key 'two'? " + lhm.containsKey("two"));

		// Using containsKey() method to check for a value
		System.out.println("Contains value 'practice.geeks" + "forgeeks.org'? "
				+ lhm.containsValue("practice" + ".geeksforgeeks.org"));

		// Removing entry using remove() method
		System.out.println("delete element 'one': " + lhm.remove("one"));

		// Printing mappings to the console
		System.out.println("Mappings of LinkedHashMap : " + lhm);

//		TreeMap
		System.out.println("\n\n+++++++++++++++++TreeMap++++++++++++++++");
		// Creating an empty TreeMap
		TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>();

		// Mapping string values to int keys
		// using put() method
		tree_map.put(10, "Geeks");
		tree_map.put(15, "4");
		tree_map.put(20, "Geeks");
		tree_map.put(25, "Welcomes");
		tree_map.put(30, "You");

		// Printing the elements of TreeMap
		System.out.println("TreeMap: " + tree_map);

		TreeMap<Student, Integer> tree_mapS = new TreeMap<Student, Integer>(new Sortbyroll());

		// Mapping string values to int keys
		tree_mapS.put(new Student(111, "bbbb", "london"), 2);
		tree_mapS.put(new Student(131, "aaaa", "nyc"), 3);
		tree_mapS.put(new Student(121, "cccc", "jaipur"), 1);

		// Printing the elements of TreeMap
		System.out.println("TreeMap: " + tree_mapS);
	}
}

class Student {

	// Attributes of a student
	int rollno;
	String name, address;

	// Constructor
	public Student(int rollno, String name, String address) {

		// This keyword refers to current object itself
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	// Method of this class
	// To print student details
	public String toString() {
		return this.rollno + " " + this.name + " " + this.address;
	}
}

// Class 2
// Helper class - Comparator implementation
class Sortbyroll implements Comparator<Student> {

	// Used for sorting in ascending order of
	// roll number
	public int compare(Student a, Student b) {
		return a.rollno - b.rollno;
	}
}
