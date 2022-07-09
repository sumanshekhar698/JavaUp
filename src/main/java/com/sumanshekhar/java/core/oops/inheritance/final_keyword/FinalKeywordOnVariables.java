package com.sumanshekhar.java.core.oops.inheritance.final_keyword;

public class FinalKeywordOnVariables {
	static final double VALUE_OF_PI = 3.14159;

	public static void main(String[] args) {

		final int demo;
		float radius = 7.7878f;

//		pi = 4.76;
		float areaOfCircle = (float) Math.PI * radius * radius;
		System.out.println(areaOfCircle);

	}

}

class AreaOfACicle {

	final double pi;

	public AreaOfACicle(double pi) {
		super();
		this.pi = pi;
	}

	AreaOfACicle() {
		super();
		this.pi = Math.PI;
		// TODO Auto-generated constructor stub
	}
}
