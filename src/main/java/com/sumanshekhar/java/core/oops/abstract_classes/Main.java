package com.sumanshekhar.java.core.oops.abstract_classes;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GeekSterEmployee g1 = new GeekSterEmployee();
		g1.proud();
		g1.sayMyId();

//		Employee e0 = g1;

		printEmployee(g1);

		// Abstract classes cannot be directly instantiated
//		Employee employee = new Employee();

		Employee e1 = new Employee() {

			// Atleast all the abstract methods you have to provide body for it
			@Override
			void sayMyId() {
				// TODO Auto-generated method stub
				System.out.println(this.empId);

			}

			@Override
			void sayMyName() {
				// TODO Auto-generated method stub
				System.out.println(this.empId);

			}

//			void print() {// Specialized method also
//
//			}
		};

		e1.sayMyId();
		e1.sayMyId();
//		e1.pr

	}

	private static void printEmployee(Employee g1) {

		GeekSterEmployee e1 = null;
		if (g1 instanceof GeekSterEmployee)
			e1 = (GeekSterEmployee) g1;// Downcasting

		System.out.println(e1);

	}

}
