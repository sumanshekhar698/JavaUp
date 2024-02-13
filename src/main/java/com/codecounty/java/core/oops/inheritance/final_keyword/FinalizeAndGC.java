package com.codecounty.java.core.oops.inheritance.final_keyword;

public class FinalizeAndGC extends Object {

	public static void main(String[] args) {

		float x = -10 / 0.0f;
		System.out.println(x);

		if (0.0f == 0)
			System.out.println(true);

		float y = 0 / 0.0f;
		System.out.println(y);// NaN = Not a Number

		Student s1 = new Student(null, 0, null, 0);
		Student s2 = s1;
		System.gc();
		s1 = null;
		s2 = null;

		System.gc();

	}

	@Override
	protected void finalize() {
		System.out.println("finalize method called");
	}

}
