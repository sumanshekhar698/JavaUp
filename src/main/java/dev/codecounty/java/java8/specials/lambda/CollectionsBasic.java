package dev.codecounty.java.java8.specials.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionsBasic {

	public static void main(String[] args) {

		/*
		 * LIST: ArrayList -> Insertion order preserved ; Duplicates Allowed
		 */
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("Tom");
		arraylist.add("Dick");
		arraylist.add("Harry");
		arraylist.add("Tom");
		System.out.println("ArrayList -> " + arraylist);

		/*
		 * SET: HashSet -> Insertion order not preserved ; Duplicates not Allowed
		 */

		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("Tom");
		hashSet.add("Dick");
		hashSet.add("Harry");
		hashSet.add("Tom");
		System.out.println("HashSet -> " + hashSet);

		/*
		 * MAP: HashMap -> Key:Value mechanism; Insertion order not preserved ;
		 * Duplicate Keys not Allowed
		 */

//		HashMap<int, String> hashMap = new HashMap<int,String>();//ERROR  : int not an Object
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(54, "Sukanya");
		hashMap.put(55, "Sulagna");
		hashMap.put(56, "Suman");
		hashMap.put(57, "Sumaniya");//will get override
		hashMap.put(57, "Suman");
		System.out.println("HashMap -> " + hashMap);

	}

}
