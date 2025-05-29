package dev.codecounty.java.java8.specials.lambda;

public class LambdaImplementation2 {

	public static void main(String[] args) {

		int i = 7, j = 8;
		SampleFunctionalInterface2 sfi1 = new TraditionalImplementation2();
		sfi1.m2(i, j);// 15 TraditionaApproach

		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

//		*ERROR*// SampleFunctionalInterface2 sfi2 = (int a,b) -> {   
		SampleFunctionalInterface2 sfi2 = (int a, int b) -> {
			System.out.println("λ implementation  |  SUM = " + (i + j));
			// If mentioning the actual parameters, it should be declared to all the
			// parameters
			// Other local variables can be used inside λ, though not recommended
		};
		sfi2.m2(100, 9);// 15

		sfi2 = (a, b) -> {
			System.out.println("λ implementation with type inference |  SUM = " + (a + b));
		};
		// Type inference is done considering the formal parameters of abstract method
		// a,b cannot be declared before this lambda as it will cause ambiguity
		// a,b is local scoped to λ only
		sfi2.m2(18, 9);// 27

		sfi2 = (a, b) -> System.out.println("λ implementation with code formatted |  SUM = " + (a + b));
		// Here we can use again the same variables
		sfi2.m2(3, 1);// 4

	}

}

class TraditionalImplementation2 implements SampleFunctionalInterface2 {

	@Override
	public void m2(int i, int j) {
		System.out.println("m2() ----> implemented using traditional approach | SUM = " + (i + j));

	}
}
