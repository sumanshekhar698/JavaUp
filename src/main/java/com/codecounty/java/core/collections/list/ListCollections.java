package com.codecounty.java.core.collections.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListCollections {

	public static void main(String[] args) {
		System.out.println("+++++++++++++++++ARRAY LIST++++++++++++++++");
		List<String> list1 = new ArrayList<String>();
		List<String> linkedList1 = new LinkedList<String>();
		List<String> vectorList1 = new Vector<String>();
		Stack<String> stack = new Stack<String>();

		list1.add("Ravi");// Adding object in arraylist
		list1.add("Vijay");
		list1.add("Ravi");
		list1.add("Ajay");

		System.out.println("USING for");
		for (int i = 0; i < list1.size(); i++) {
			String string = list1.get(i);
			System.out.print(string + " ");
//			list1.add("donkey");// illegal coding style
		}

		System.out.println("\n\nUSING forEach()");
		list1.forEach(x -> System.out.print(x + " "));

		System.out.println("\n\nUSING enhanced forLoop");
		for (String element : list1) {
			System.out.print(element + " ");
//			list1.add("donkey");// fail fast [ConcurrentModificationException]
		}

		System.out.println("\n\nUSING iterator");
		Iterator<String> iterator1 = list1.iterator();

		while (iterator1.hasNext()) {
			String string = (String) iterator1.next();
			System.out.print(string + " ");
//			list1.add("");// fail fast [ConcurrentModificationException]
		}

		System.out.println("\n==>CopyOnWriteArrayList");

		CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
		copyOnWriteArrayList.add("Ravi");// Adding object in arraylist
		copyOnWriteArrayList.add("Vijay");
		copyOnWriteArrayList.add("Ravi");
		copyOnWriteArrayList.add("Ajay");
		Iterator<String> iterator0 = copyOnWriteArrayList.iterator();
		while (iterator0.hasNext()) {
			String string = (String) iterator0.next();
			System.out.print(string + " ");
			copyOnWriteArrayList.add("toi");// dead code, FAIL SAFE

		}

//LINKED LIST
		System.out.println("\n\n+++++++++++++++++LINKED LIST++++++++++++++++");
		linkedList1.add("Ravi");// Adding object in arraylist
		linkedList1.add("Vijay");
		linkedList1.add("Ravi");
		linkedList1.add("Ajay");

		System.out.println("\nUSING iterator");
		Iterator<String> iterator2 = linkedList1.iterator();
		while (iterator2.hasNext()) {
			String string = (String) iterator2.next();
			System.out.print(string + " ");
//			linkedList1.add("");Fail Fast
		}

		System.out.println("\n\n+++++++++++++++++VECTOR++++++++++++++++");
//		VECTOR
		vectorList1.add("Ayush");
		vectorList1.add("Amit");
		vectorList1.add("Amit");
		vectorList1.add("Ashish");
		vectorList1.add("Garima");

		Iterator<String> itr = vectorList1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("\n\n+++++++++++++++++STACK++++++++++++++++");
		stack.push("Ayush");
		stack.push("Garvit");
		stack.push("Amit");
		stack.push("Ashish");
		stack.push("Garima");
		String pop = stack.pop();
		System.out.println("POPPED ==> " + pop);
		Iterator<String> itrs = stack.iterator();// Iteration is bottom to top
		while (itrs.hasNext()) {
			System.out.println(itrs.next());
		}

	}

}
