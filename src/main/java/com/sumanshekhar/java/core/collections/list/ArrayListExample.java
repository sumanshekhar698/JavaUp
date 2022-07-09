package com.sumanshekhar.java.core.collections.list;

import com.sumanshekhar.java.core.oops.encapsulation.Bird2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayListExample {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(5);
		arrayList.add(-5);
		arrayList.add(7);
		System.out.println(arrayList);
		arrayList.add(1, 9);
		System.out.println(arrayList);
		Integer remove = arrayList.remove(0);
		System.out.println(arrayList);

		Collections.sort(arrayList);//sorting
		System.out.println(arrayList);
		boolean contains = arrayList.contains(9);
		System.out.println(contains);

//		1st Normal For Loop
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

		ArrayList<Integer> arrayListCloned = (ArrayList<Integer>) arrayList.clone();
		System.out.println("CLONE " + arrayListCloned);

//		2nd for each loop
		for (Integer integer : arrayList) {// enhanced for loop
			arrayListCloned.add(7);
			System.out.println(integer);
		}

		System.out.println("CLONE " + arrayListCloned);
//		3rd
		Iterator<Integer> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);

		}

		ArrayList<Bird2> arrayListOfBird = new ArrayList<Bird2>();
		arrayListOfBird.add(new Bird2(1, "Crow", "Black", false));
		arrayListOfBird.add(new Bird2(9, "Pigeon", "Grey", false));
		arrayListOfBird.add(new Bird2(7, "Peacock", "Rainbow", true));
		arrayListOfBird.add(new Bird2(0, "Vultures", "Brown", true));
		arrayListOfBird.add(new Bird2(0, "Raven", "Deep Black", true));
//		Custom Sorting
//		BEFORE
		System.out.println("Before Sorting\n\n\n");
		for (Bird2 bird2 : arrayListOfBird) {
			System.out.println(bird2);
		}

		System.out.println("After Sorting\n\n\n");
		arrayListOfBird.sort(new BirdSorterViaNumber());
		for (Bird2 bird2 : arrayListOfBird) {
			System.out.println(bird2);
		}

	}

}

class BirdSorterViaNumber implements Comparator<Bird2> {

	@Override
	public int compare(Bird2 b1, Bird2 b2) {
		if (b1.getNumber() == b2.getNumber())
			return 0;
		else if (b1.getNumber() > b2.getNumber())
			return 1;
		else
			return -1;
	}
}
