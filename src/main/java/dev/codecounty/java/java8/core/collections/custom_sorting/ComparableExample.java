package dev.codecounty.java.java8.core.collections.custom_sorting;

import java.util.ArrayList;
import java.util.Collections;

class SchoolStudent implements Comparable<SchoolStudent> {
	int rollno;
	String name;
	int age;

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", age=" + age + "]";
	}

	SchoolStudent(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(SchoolStudent st) {
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
	}
}

//Creating a test class to sort the elements  
public class ComparableExample {
	public static void main(String args[]) {
		ArrayList<SchoolStudent> al = new ArrayList<SchoolStudent>();
		al.add(new SchoolStudent(101, "Vijay", 23));
		al.add(new SchoolStudent(106, "Ajay", 27));
		al.add(new SchoolStudent(105, "Jai", 21));

		Collections.sort(al);
		for (SchoolStudent st : al) {
			System.out.println(st);
		}
	}
}