package com.codecounty.java.jdk8.lambda;

import java.util.ArrayList;
import java.util.Collections;

public class CustomClassesCustomRuleLambdaSorting {

	public static void main(String[] args) {

		ArrayList<Employee> integerListOfEmployees = new ArrayList<Employee>();
		integerListOfEmployees.add(new Employee(9, "Archana"));
		integerListOfEmployees.add(new Employee(1, "Abi"));
		integerListOfEmployees.add(new Employee(21, "Sassy"));
		integerListOfEmployees.add(new Employee(100, "Tia"));
		integerListOfEmployees.add(new Employee(28, "Angel"));
		System.out.println("EmployeeList before sorting -> " + integerListOfEmployees);

		// Custom Descending Sort according to EmpId
		Collections.sort(integerListOfEmployees, (e1, e2) -> (e1.id > e2.id) ? -1 : (e2.id < e2.id) ? 1 : 0);
		System.out.println("EmployeeList after sorting -> " + integerListOfEmployees);
	}

}

class Employee {
	int id;
	String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}