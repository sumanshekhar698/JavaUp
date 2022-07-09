package com.sumanshekhar.java.core.collections.custom_sorting;

public class Student implements Comparable<Student> {
	int roll;
	String name;
	int age;

	public Student(int roll, String name, int age) {
		super();
		this.roll = roll;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student s) {
		if (age == s.age)
			return 0;
		else if (age > s.age)
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", age=" + age + "]";
	}

}
