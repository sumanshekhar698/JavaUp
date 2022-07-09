package com.sumanshekhar.java.core.oops.inheritace.rules;

public class B extends A {

	String number;
	int serial;
	int a=8;

	public B(String number, int serial) {

		super(serial, false);// Rule 1: super should be your 1st statement inside a constructor
		System.out.println("Constructr B called");

		this.number = number;
		this.serial = serial;
	}

	void shout() {
		System.out.println("SHOUTIG !!!");
	}
	
	@Override
	public void greet() {//Method overriding
		System.out.println("Hello B !!");
		super.greet();
	}

}
