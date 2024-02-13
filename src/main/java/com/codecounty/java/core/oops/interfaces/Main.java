package com.codecounty.java.core.oops.interfaces;

public class Main {

	static int x;

	public static void main(String[] args) {

		GeekSterEmployee g1 = new GeekSterEmployee(1, "Romnnie");
		g1.sayMyId();
		g1.sayDetaislAboutRegNoFromDefaultMethod();

		Employee.sayDetails();
//		g1.sayDetails();//Static methods dont take part in inheritance

		new Main().details(g1);// Its very bad practice
		Main.details(g1);// Good Habit
		details(g1);

		Employee e1 = new Employee() {// Anonymous inner class
			int id;
			String name;

			@Override
			public void sayMyName() {
				// TODO Auto-generated method stub
				System.out.println(name);
			}

			@Override
			public void sayMyId() {
				// TODO Auto-generated method stub
				System.out.println(id);

			}

			@Override
			public void pfSalary() {
				// TODO Auto-generated method stub

			}

		};

		e1.sayMyId();

	}

	static void details(Employee g1) {
		g1.sayMyId();
		g1.sayMyName();
	}

}
