package dev.codecounty.java.java8.specials.lambda;

public class LambdaImplementation1 {

	public static void main(String[] args) {

//		()->{System.out.println("Hello")};
//		(int i,int j)->{System.out.println("SUM"+(i+j))};
//		(int i,int j)->System.out.println("SUM"+(i+j));
//		( i, j)->System.out.println("SUM"+(i+j));//type inference
		
		
//		(int i,int j)->{System.out.println("SUM"+(i+j))};
		
//		(int i,int j)->{System.out.println("SUM"+(i+j))};
		
//		(String x)->{return x.length();};
//		(String x)->return x.length();//if body contains only 1 statement , curly braces are optional
//		( x)->return x.length();//Compliler can guess the type
//		( x)-> x.length();//if the λ is returning something, no need for retutn keywword
//		 x->return x.length();//if only 1 parameter then no need for small braces
		SampleFunctionalInterface1 sfi1 = new TraditionalImplementation1();
		sfi1.m1();//TraditionaApproach
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		SampleFunctionalInterface1 sfi2=()->{System.out.println("λ implementation");};//Type inference is done taking onto account of abstract methods.
		sfi2.m1();
		
		sfi2=()->System.out.println("λ implementation with code formatted");
		sfi2.m1();
		
	}

	private static void sum(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("SUM"+(i+j));
	}
	
	private static int product(int i, int j) {
		return i*j;
	}

	private static void m1() {
		System.out.println("Hello World again");
	}
	
	private static int size(String x) {
		return x.length();
	}
}
	class TraditionalImplementation1 implements SampleFunctionalInterface1 {

		@Override
		public void m1() {
			System.out.println("m1() ----> implemented using traditional approach");
		}
	}


