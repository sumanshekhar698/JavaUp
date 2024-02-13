package com.codecounty.java.core.arrays;
// Java program to demonstrate Working of 

import java.util.Arrays;
import java.util.Comparator;

class Student {
	int rollno;
	String name, address;

	public Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	public String toString() {
		return this.rollno + " " + this.name + " " + this.address;
	}
}

class SortStudentByRoll implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		return a.rollno - b.rollno;
	}
}

public class CustomComaparatorArraySort {

	public static void main(String[] args) {
		Student[] arr = { new Student(111, "John", "london"), new Student(131, "Jane", "nyc"),
				new Student(121, "Josh", "jaipur") };

		System.out.println("Unsorted  -->");

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

		System.out.println("User Defined Sorted  -->");
		Arrays.sort(arr, new SortStudentByRoll());
		System.out.println("\nSorted by rollno");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
}