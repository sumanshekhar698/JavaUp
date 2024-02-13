package com.codecounty.java.core.collections.custom_sorting;

public class StudentPlain {
	int roll;
	String name;
	int age;

	public StudentPlain(int roll, String name, int age) {
		super();
		this.roll = roll;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", age=" + age + "]";
	}

}
