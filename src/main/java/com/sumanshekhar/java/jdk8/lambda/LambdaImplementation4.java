package com.sumanshekhar.java.jdk8.lambda;

public class LambdaImplementation4 {

	public static void main(String[] args) {

		SampleFunctionalInterface4 sfi4 = new TraditionalImplementation4();
		int sqr = sfi4.m4sqr(17);
		System.out.println("method m3() called using traditional approach " + sqr);// 289

		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

		sfi4 = (x) -> x * x;// x gives x^2
		sqr = sfi4.m4sqr(19);
		System.out.println("λ   |  SQR = " + sqr);// 361
	}
}

class TraditionalImplementation4 implements SampleFunctionalInterface4 {

	@Override
	public int m4sqr(int n) {
		return n * n;
	}

}
