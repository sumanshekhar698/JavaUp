package com.sumanshekhar.java.jdk8.lambda;

public interface SampleNonFunctionalInterface {

	public void m1();

	public void m9();// More than 1 abstract methods So it isn't a functional interface

	public static int m2(int a) {
		return a * a;

	}

	default void m3() {
		System.out.println("M3");
	}
}
