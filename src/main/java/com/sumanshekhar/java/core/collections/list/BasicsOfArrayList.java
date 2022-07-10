package com.sumanshekhar.java.core.collections.list;

import java.util.ArrayList;


public class BasicsOfArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] x = { 4, 65, 76, 2 };

		int y = 1;
		Integer z = y;// aotboxing. wrappimg

//		Collection

		ArrayList a = new ArrayList();// They only hold Objects instead of primitive data type
//		a.add(a);

//		a[0]="John";
		a.add("John");
		a.add("Mary");
		a.add("Manv");
		a.add("Kalyan");
		a.add(new Student("bear"));
		a.add(1);// autoboxing
		a.add(2, "ravi");
//		a.add(a)
		System.out.println(a);
//		a.remove(0);
//		a.remove("Manv");
//		boolean remove = a.remove(new Student("bear"));
		a.remove(5);
//		System.out.println(remove);
		System.out.println(a);

	}

}
