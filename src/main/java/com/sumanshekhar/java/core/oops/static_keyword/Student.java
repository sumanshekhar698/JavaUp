package com.sumanshekhar.java.core.oops.static_keyword;

public class Student {

	static int counter = 6;

	// Object Variables
	String id;
	String name;// instance variables

	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student(String name) {
		super();
		this.id = "C" + counter++;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	static {
		System.out.println("1st Static Block");
	}
	
	static {
		System.out.println("2nd Static Block");

	}

}
