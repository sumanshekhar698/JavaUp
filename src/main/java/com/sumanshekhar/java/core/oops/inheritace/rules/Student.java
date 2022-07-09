package com.sumanshekhar.java.core.oops.inheritace.rules;

import java.sql.Date;

public class Student {

	private String name;
	private int age;
	private Date dob;
	private long usn;

	public Student(String name, int age, Date dob, long usn) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.usn = usn;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", dob=" + dob + ", usn=" + usn + "]";
	}

	public Date getDob() {
		return dob;
	}

	public long getUsn() {
		return usn;
	}

}
