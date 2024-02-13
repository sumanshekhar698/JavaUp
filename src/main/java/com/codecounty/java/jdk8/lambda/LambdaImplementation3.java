package com.codecounty.java.jdk8.lambda;

public class LambdaImplementation3 {

	public static void main(String[] args) {

		int i = 7, j = 8;
		SampleFunctionalInterface3 sfi1 = new TraditionalImplementation3();
		int length = sfi1.m3("JAVA-8");
		System.out.println("method m3() called using traditional approach " + length);// 6 TraditionaApproach

		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

		SampleFunctionalInterface3 sfi3 = (String x) -> {
			return x.length();
		};
		length = sfi3.m3("java-8_Lambda_flora ");
		System.out.println("λ implementation  |  Length = " + length);// 20

		sfi3 = (x) -> {
			return x.length();
		};
		// Type inference is done considering the formal parameters of abstract method
		// x is understood by compiler as String from the context of the abstract method
		// x is local scoped to λ only
		length = sfi3.m3("java-8_Lambda Sierra Blue ");
		System.out.println("λ implementation with type inference |  Length = " + length);// 26

//		sfi3 = (x) -> return x.length();// when using the return keyword enclose within the curly braces

		sfi3 = (x) -> x.length();// no need for the return keyword and curly braces removes as the λ had only 1
									// parameter
		length = sfi3.m3("java-8_Lambda Sierra Blue moon ");
		System.out.println("λ implementation with code formatted |  Length = " + length);// 31

		sfi3 = x -> x.length();// no need for the () if the method contains only one formal parameters
		length = sfi3.m3("java-8_Lambda Sierra Blue moon and back");
		System.out.println("λ implementation with further code formatted |  Length = " + length);// 39

	}
}

class TraditionalImplementation3 implements SampleFunctionalInterface3 {

	@Override
	public int m3(String x) {
		return x.length();
	}

}
