package com.sumanshekhar.java.core.collections.linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExample {

	public static void main(String[] args) {

		// PROS: Insertion , Deletion very fast
		// CONS: Traversal

		LinkedList<Integer> integerLinkedList = new LinkedList<>();
		integerLinkedList.add(5);
		integerLinkedList.add(6);
		integerLinkedList.add(66);
		integerLinkedList.add(76);
		integerLinkedList.add(68);
		integerLinkedList.add(2, 10);
		System.out.println(integerLinkedList.get(0));
		integerLinkedList.remove();
		System.out.println(integerLinkedList);

		for (Integer integer : integerLinkedList) {
			System.out.print(integer + "  ");
		}
		System.out.println();

//		Using Iterator for traversal
		Iterator<Integer> iterator = integerLinkedList.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

		ArrayList<Integer> arrayList = new <Integer>ArrayList();
		arrayList.add(4);
		arrayList.add(14);
		arrayList.add(44);
		arrayList.add(45);
		arrayList.add(49);
		arrayList.add(433);

//		Iterator on ArrayList
		Iterator<Integer> iteratorForArrayList = arrayList.iterator();
		while (iteratorForArrayList.hasNext()) {
			Integer integer = (Integer) iteratorForArrayList.next();
			System.out.print(integer + " ");
		}
		System.out.println();

//		Custom Iterator on ArrayList
		ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size());
		System.out.println("ARRAYLIST REVERSED ITERATOR");
		while (listIterator.hasPrevious()) {
			Integer integer = (Integer) listIterator.previous();
			System.out.print(integer + " ");
		}
		System.out.println();

//		Custom DescendingIterator onLinkedList
		Iterator<Integer> descendingIterator = integerLinkedList.descendingIterator();
		while (descendingIterator.hasNext()) {// hasNext() will work because its a doubly linkedlist
			Integer integer = (Integer) descendingIterator.next();
			System.out.print(integer + " ");
		}
		System.out.println();

//	-1(I) [5, 6, 10, 66, 76, 68]
	}
}
