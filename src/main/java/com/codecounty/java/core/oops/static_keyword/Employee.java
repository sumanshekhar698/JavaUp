package com.codecounty.java.core.oops.static_keyword;

public class Employee {

	String name;
	private long phoneNumber;
	private boolean isMarried;
	String employeeID;
	static int sequence = 1;

	public Employee(String name, long phoneNumber, boolean isMarried, String employeeID) {
		super();
		System.out.println("Employee constructor triggerd");
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.isMarried = isMarried;
		this.employeeID = "EMP" + sequence++;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", phoneNumber=" + phoneNumber + ", isMarried=" + isMarried + ", employeeID="
				+ employeeID + "]";
	}

	static int getCount() {
//		System.out.println(phoneNumber);
		return sequence;
	}

	static {
		sequence = 100;
		System.out.println("Static block called");
	}

}
