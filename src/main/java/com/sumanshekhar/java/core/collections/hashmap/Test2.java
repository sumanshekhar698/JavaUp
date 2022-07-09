package com.sumanshekhar.java.core.collections.hashmap;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test2 {

	public static void main(String[] args) {

		String sample = "DictionaryO";
		String lowerCase = sample.toLowerCase();

		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

		for (int i = 0; i < lowerCase.length(); i++) {
			if (hashMap.containsKey(lowerCase.charAt(i))) {
				int number = hashMap.get(lowerCase.charAt(i));
				hashMap.put(lowerCase.charAt(i), ++number);

			} else {
				hashMap.put(lowerCase.charAt(i), 1);
			}
		}

		for (Entry<Character, Integer> e : hashMap.entrySet()) {
			if (e.getValue() > 1)
				System.out.println(e.getKey());
		}

		System.out.println("He3lllo");

	}

}
