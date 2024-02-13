package com.codecounty.java.core.oops.constructors;

public class MainPrivarteConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e1 = Employee.getObject(21);
		System.out.println(e1);
		System.out.println(e1.hashCode());

		Employee e2 = Employee.getObject(22);
		System.out.println(e2);
		System.out.println(e2.hashCode());

		Employee[] arrayOfEmp = new Employee[100];

		for (int i = 0; i < arrayOfEmp.length; i++) {
			arrayOfEmp[i] = Employee.getObject(i);
		}

		for (int i = 0; i < arrayOfEmp.length; i++) {
			System.out.println(arrayOfEmp[i]);
		}

	}
}
