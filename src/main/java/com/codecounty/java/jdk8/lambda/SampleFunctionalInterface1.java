package com.codecounty.java.jdk8.lambda;

@FunctionalInterface
public interface SampleFunctionalInterface1 {

	public void m1();
	public static int m2(int a) {
		return a * a;
	}

	default void m3() {
		System.out.println("M3");

	}

	default void m4() {
		System.out.println("M4");

	}
}
