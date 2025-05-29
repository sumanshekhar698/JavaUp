package dev.codecounty.java.java8.core.basics.data_types;

public class JavaMathsEdgeCases {

	public static void main(String[] args) {
//		System.out.println(9 / 0);//Undefined / by zero ArithmeticException

		System.out.println(0.0f == 0);// by zero
		System.out.println(9 / 0.0);// Infinity
		System.out.println(-9 / 0.0);// - Infinity
//		System.out.println(0 / 0);// / by zero ArithmeticException
		System.out.println(2.0 % 0.0);// NaN
		System.out.println(0.0 / 0.0);// NaN
		System.out.println(Math.sqrt(-1));// NaN
//		NaN

	}

}
