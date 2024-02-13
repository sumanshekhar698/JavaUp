package com.codecounty.java.core.oops.interfaces;

public class GeekSterEmployee extends JobPermit implements Employee, PFaccount {

	@Override
	public String toString() {
		return "GeekSterEmployee [id=" + id + ", name=" + name + "]";
	}

	int id;
	String name;

	@Override
	public void sayMyName() {
		System.out.println("I am " + name + " from " + Employee.COMPANY_NAME);
	}

	public GeekSterEmployee(int id, String name) {
		super(true);
		this.id = id;
		this.name = name;
	}

	@Override
	public void sayMyId() {
		System.out.println("I am " + name + " from " + Employee.COMPANY_NAME + " with an ID of " + id);

	}

	void Proud() {
		System.out.println("Proud to bhe a geekster");
	}

	@Override
	public void pfSalary() {
		System.out.println("PF is debited from the CTC");

	}

}
