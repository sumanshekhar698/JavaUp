package dev.codecounty.java.java8.oops.abstract_classes;

public class GeekSterEmployee extends Employee {

	@Override
	void sayMyId() {

		System.out.println(empId);

	}

	void proud() {//Specializeed Methiod for GeekSterEmployee class
		System.out.println("proud to be a geekster");
	}

}
