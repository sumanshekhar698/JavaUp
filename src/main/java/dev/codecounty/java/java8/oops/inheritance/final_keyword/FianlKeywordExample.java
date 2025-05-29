package dev.codecounty.java.java8.oops.inheritance.final_keyword;

public final class FianlKeywordExample {
	final static float pi = 3.14179f;

	public static void main(String[] args) {

//		pi=10;

		final int x;
		x = 56;
//		x=55;

		float radius = 10;
		System.out.println("AERA --> " + calcAreaOfCircle(radius));

	}

	private static float calcAreaOfCircle(float radius) {
		return pi * radius * radius;
	}

}
