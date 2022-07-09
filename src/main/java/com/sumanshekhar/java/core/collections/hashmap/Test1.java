package com.sumanshekhar.java.core.collections.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {

	public static void main(String[] args) {

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(1, "London");
		hashMap.put(2, "Berlin");
		hashMap.put(3, "Bangalore");
		String result;
		ArrayList<String> values = new ArrayList<String>(hashMap.values());
		 List<String> collect = values.stream().filter(x -> x.equals("London")).collect(Collectors.toList());
			System.out.println(collect.get(0));

	}

}
