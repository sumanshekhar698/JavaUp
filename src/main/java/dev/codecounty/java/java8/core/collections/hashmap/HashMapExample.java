package dev.codecounty.java.java8.core.collections.hashmap;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	// PROS: k:v storage, No Duplicate Keys, Faster searching
	// CONS: Takes More Space, prohibits Random Access via Indexing
	public static void main(String[] args) {

		HashMap<Integer, String> studentListRollNumberWise = new HashMap<>();
		studentListRollNumberWise.put(1, "Sam");// Entry
		studentListRollNumberWise.put(2, "Ronnie");
		studentListRollNumberWise.put(6, "Christopher");
		studentListRollNumberWise.put(9, "Jack");
		studentListRollNumberWise.put(10, "Jane");
		studentListRollNumberWise.put(10, "Jim");
		studentListRollNumberWise.remove(9);// removes the whole k:v entry
		studentListRollNumberWise.replace(1, "Samntha");
		System.out.println(studentListRollNumberWise);

		boolean containsKey = studentListRollNumberWise.containsKey(1);// searching
		System.out.println(containsKey);
		boolean containsValue = studentListRollNumberWise.containsValue("1");
		System.out.println(containsValue);

		String string = studentListRollNumberWise.get(1);// gets the value for corresponding keys
		System.out.println(string);

//		keys can only be Immutable Values; String, WrapperClasses are immutable
//		[String Buffer, Builder...] are mutable
		HashMap<String, Integer> fibonacci = new HashMap<>();
		fibonacci.put("1", 1);

//		Iterating a HashMap
		for (Entry<Integer, String> entry : studentListRollNumberWise.entrySet()) {
			System.out.println(entry);
			Integer key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + "--> " + val);
		}

		System.out.println("KEYS");
//		Iterating a HashMap Keys only
		for (Integer key : studentListRollNumberWise.keySet()) {
			System.out.print(key + " ");
		}

//		Iterating a HashMap Values only
		for (String value : studentListRollNumberWise.values()) {
			System.out.println(value);
		}

		// Exporting the EntrySet of a HashMap
		Set<Entry<Integer, String>> entrySet = studentListRollNumberWise.entrySet();
	}
}
