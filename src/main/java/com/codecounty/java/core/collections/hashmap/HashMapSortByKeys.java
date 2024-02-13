package com.codecounty.java.core.collections.hashmap;

import java.util.*;

public class HashMapSortByKeys {

	public static void main(String[] args) {

		// 1. using TreeMap constructor to sort the HashMap
		System.out.println("Using TreeMap\n\n");
		HashMap<Integer, String> hm0 = new HashMap<Integer, String>();
		// addding keys and values to HashMap
		hm0.put(23, "Yash");
		hm0.put(17, "Arun");
		hm0.put(15, "Swarit");
		hm0.put(9, "Neelesh");
		Iterator<Integer> it = hm0.keySet().iterator();
		System.out.println("Before Sorting");
		while (it.hasNext()) {
			int key = (int) it.next();
			System.out.println("Roll no:  " + key + "     name:   " + hm0.get(key));
		}
		System.out.println("\n");
		System.out.println("After Sorting");

		TreeMap<Integer, String> tm = new TreeMap<Integer, String>(hm0);
		Iterator<Integer> itr = tm.keySet().iterator();
		while (itr.hasNext()) {
			int key = (int) itr.next();
			System.out.println("Roll no:  " + key + "     name:   " + hm0.get(key));
		}

		// 2. using LinkedHashMap
		System.out.println("Using LinkedHashMap\n\n");
		// implementing HashMap
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(6, "Tushar");
		hm.put(12, "Ashu");
		hm.put(5, "Zoya");
		hm.put(78, "Yash");
		hm.put(10, "Praveen");
		hm.put(67, "Boby");
		hm.put(1, "Ritesh");
		System.out.println("Before Sorting:");
		Set set = hm.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry map = (Map.Entry) iterator.next();
			System.out.println("Roll no:  " + map.getKey() + "     Name:   " + map.getValue());
		}

		Map<Integer, String> map = sortValues(hm);
		System.out.println("\n");
		System.out.println("After Sorting:");
		Set set2 = map.entrySet();
		Iterator iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry me2 = (Map.Entry) iterator2.next();
			System.out.println("Roll no:  " + me2.getKey() + "     Name:   " + me2.getValue());
		}

	}

	// method to sort values
	private static HashMap sortValues(HashMap<Integer, String> map) {
		List list = new LinkedList(map.entrySet());
		// Custom Comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		// copying the sorted list in HashMap to preserve the iteration order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

}