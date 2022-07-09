package com.sumanshekhar.java.core.oops.inheritance.final_keyword;

public class FinalizeExample {
	public static void main(String[] args) {
		FinalizeExample object = new FinalizeExample();
		System.out.println(object.hashCode());
		object = null;
		// calling garbage collector
		System.gc();
		System.out.println("end of garbage collection");

	}

	@Override
	protected void finalize() {
		System.out.println("finalize method called");
	}
}