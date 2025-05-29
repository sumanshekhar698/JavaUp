package dev.codecounty.java.java8.oops.inheritance.final_keyword;

import java.sql.Date;

public class UniversityStudent extends Student {

	public UniversityStudent(String name, int age, Date dob, long usn) {
		super(name, age, dob, usn);
		// TODO Auto-generated constructor stub
	}

	@Override
	void shoutGrade() {
//	void shoutttGrade() {
		switch (this.getGrade()) {
		case 'O':
			System.out.println("Outstanding perfomance");
			break;
		case 'E':
			System.out.println("Excellent perfomance");
			break;
		case 'A':
			System.out.println("Good improvement");
			break;
		case 'B':
			System.out.println("Needs improvement");
			break;
		case 'C':
			System.out.println("Warning for ypur grades");
			break;
		default:
			System.out.println("No Grades available");
			break;
		}

	}

	void shoutName() {
		System.out.println(getName());
	}

}
