package dev.codecounty.java.java8.core.collections.custom_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomSortingExample {

	public static void main(String[] args) {

		ArrayList<Student> arrayList = new ArrayList();
		arrayList.add(new Student(1, "Sam", 55));
		arrayList.add(new Student(7, "Samantha", 45));
		arrayList.add(new Student(9, "Rocky", 39));
		arrayList.add(new Student(8, "Christopher", 6));
		arrayList.add(new Student(67, "Tamy", 67));

		System.out.println(arrayList);

		Collections.sort(arrayList);// Custom Sorting using Comparable
		System.out.println(arrayList);

		ArrayList<StudentPlain> arrayListPlain = new ArrayList<StudentPlain>();
		arrayListPlain.add(new StudentPlain(1, "Sam", 55));
		arrayListPlain.add(new StudentPlain(7, "Samantha", 45));
		arrayListPlain.add(new StudentPlain(9, "Rocky", 39));
		arrayListPlain.add(new StudentPlain(8, "Christopher", 6));
		arrayListPlain.add(new StudentPlain(67, "Tamy", 67));
		System.out.println(arrayListPlain);

		// Custom Sorting using Comparator
		Collections.sort(arrayListPlain, new RollComparator());// Sorting based on Roll
		System.out.println(arrayListPlain);

//		Using Lambda | Sorting further based on Age
		Collections.sort(arrayListPlain, (Comparator<StudentPlain>) (StudentPlain s1, StudentPlain s2) -> {

			if (s1.age == s2.age)
				return 0;
			else if (s1.age > s2.age)
				return 1;
			else
				return -1;
		});
		System.out.println(arrayListPlain);

		
	}
}
