package com.sumanshekhar.java.core.oops.inheritace.proper_example;

public class Player {

	String name;
	int age;
	int BMI;
	private long phoneNumber;

	public void stats() {
		System.out.println("STATS --> [ " + name + " " + age + " " + BMI+"]");
	}

	public Player() {
		System.out.println("Constrcutor Triggered of Parent Class --> Player");
	}

}
