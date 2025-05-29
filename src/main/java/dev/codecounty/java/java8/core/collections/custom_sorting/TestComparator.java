package dev.codecounty.java.java8.core.collections.custom_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class TestComparator {
	public static void main(String args[]) {
//Creating a list of students  
		ArrayList<ColledgeStudent> al = new ArrayList<ColledgeStudent>();
		al.add(new ColledgeStudent(101, "Vijay", 23));
		al.add(new ColledgeStudent(106, "Ajay", 27));
		al.add(new ColledgeStudent(105, "Jai", 21));

		System.out.println("*********Sorting by Name*********");
//Using NameComparator to sort the elements  
		Collections.sort(al, new NameComparator());
//Traversing the elements of list  
		for (ColledgeStudent st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		System.out.println("\n*******Sorting by Age*********");
//Using AgeComparator to sort the elements  
		Collections.sort(al, new AgeComparator());
//Travering the list again  
		for (ColledgeStudent st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

	}
}

class NameComparator implements Comparator<ColledgeStudent> {
	public int compare(ColledgeStudent s1, ColledgeStudent s2) {
		return s1.name.compareTo(s2.name);
	}
}

class AgeComparator implements Comparator<ColledgeStudent> {
	public int compare(ColledgeStudent s1, ColledgeStudent s2) {
		if (s1.age == s2.age)
			return 0;
		else if (s1.age > s2.age)
			return 1;
		else
			return -1;
	}
}

class ColledgeStudent {
	int rollno;
	String name;
	int age;

	ColledgeStudent(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
}