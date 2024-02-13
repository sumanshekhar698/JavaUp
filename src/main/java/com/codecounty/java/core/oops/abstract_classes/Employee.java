package com.codecounty.java.core.oops.abstract_classes;

public abstract class Employee {

	private String name;
	public long empId;

	void sayMyName() {// declaring and as well as implementing [concrete method]
		System.out.println(this.name);
	}

	abstract void sayMyId();// am just declaring the signature

	public long getEmpId() {
		return empId;
	}

}
