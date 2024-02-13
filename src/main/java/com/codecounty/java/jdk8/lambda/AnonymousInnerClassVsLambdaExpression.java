package com.codecounty.java.jdk8.lambda;

public class AnonymousInnerClassVsLambdaExpression {

	public static void main(String[] args) {

		/* • Implementing a functional interface */
//		Runnable runnable = new Runnable();// ERROR as we cannot directly instantiate an interface
//		But we can use Anonymous Inner Classes to instantiate this
		int n = 10;
		Runnable runnableUsingAnonymousity = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < n; i++) {
					System.out.println("Annnymous Inner Class Thread  " + i);
				}
			}
		};
		/*
		 * In above case we are defining the implementation of Runnable in an unnamed
		 * class. Instantiating that unnamed[Anonymous] inner class to the reference =
		 * Runnable runnableUsingAnonymousity
		 */
		Thread t1 = new Thread(runnableUsingAnonymousity);
		t1.start();// starting t1 thread

//		Main Thread
		for (int i = 0; i < n; i++) {
			System.out.println("Main() Thread  " + i);
		}

//		☀ λ can be used only in case of Functional Interface
		/*
		 * λ Thread ==> here we are passing the Runnable Implementation instance to
		 * Thread
		 */
		Runnable runnableUsingLambda = () -> {
			for (int i = 0; i < n; i++) {
				System.out.println("λ() Thread  " + i);
			}
		};
		Thread t2 = new Thread(runnableUsingLambda);
		t2.start();// starting λ thread

		/*
		 * λ-enhanced Thread ==> here we are passing the Runnable Implementation
		 * directly
		 */
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < n; i++)
				System.out.println("λe() Thread  " + i);
		});
		t3.start();// starting λe thread

		/*
		 * ☀ Anonymous Inner Class Strength 
		 * • Extending to a concrete class
		 */
		Test test = new Test() {// anonymous inner class extending to concrete Test; test = Test() getting
								// assigned to ref Test test
			void m2() {
				System.out.println("adding a method to the already existing concrte class");
			}

			@Override
			void m1() {
				System.out.println("m1() @Override");
			}
		};
		test.a = 5;
		System.out.println(test.a);

		/*
		 * • Extending to a abstract class
		 */
		//		Demo2 demo2 = new Demo2();//ERROR abstract class cannot be directly instantiated
		Demo2 demo2 = new Demo2() {// anonymous inner class extending to abstract Demo2; demo2 = Demo2() getting
									// assigned to ref Test test
			@Override
			void m1() {
				System.out.println("m1() implementd from abstract class");
			}
		};

		/* • Implementing an interface with multiple abstract methods */
		Demo1 demo1 = new Demo1() {// anonymous inner class implementing Demo2; demo2 = Demo2() getting
									// assigned to ref Demo1 demo1
			@Override
			public void m1() {
				System.out.println("m1() implementd from abstract class");
			}

			@Override
			public void m2() {
				System.out.println("m2() implementd from abstract class");
			}

			@Override
			public void m3() {
				System.out.println("m3() implementd from abstract class");
			}
		};

	}
}

interface Demo1 {
	void m1();

	abstract void m2();

	void m3();
}

abstract class Demo2 {
	abstract void m1();
}

abstract class Demo3 {

}

class Test {
	int a;

	void m0() {
		System.out.println("m0()");
	}

	void m1() {
		System.out.println("m1()");
	}
}
