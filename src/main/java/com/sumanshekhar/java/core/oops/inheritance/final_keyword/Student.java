package com.sumanshekhar.java.core.oops.inheritance.final_keyword;

import java.sql.Date;

public class Student {

	private String name;
	private int age;
	private Date dob;
	private long usn;
	private char grade;// \u0000 is the null character in Unicode

	public Student(String name, int age, Date dob, long usn) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.usn = usn;
	}

	public char getGrade() {
		return grade;
	}

	 void shoutGrade() {

		switch (this.grade) {
		case 'A':
			System.out.println("Outstanding perfomance");
			break;
		case 'B':
			System.out.println("Goood perfomance");
			break;
		case 'C':
			System.out.println("Needs improvement");
			break;
		default:
			System.out.println("No Grades available");
			break;
		}

	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Student* [name=" + name + ", age=" + age + ", dob=" + dob + ", usn=" + usn + "]";
	}

	public Date getDob() {
		return dob;
	}

	public long getUsn() {
		return usn;
	}

}
