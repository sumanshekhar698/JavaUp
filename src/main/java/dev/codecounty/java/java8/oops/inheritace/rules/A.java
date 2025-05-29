package dev.codecounty.java.java8.oops.inheritace.rules;

public class A {

	int x;
	boolean y;
	int a = 4;

	public A(int x, boolean y) {// Parametrized
//		super();
		System.out.println("A(int, boolean)  parameterized constructor called");

		this.x = x;
		this.y = y;
	}

	public A() {// Non Parameterized
//		super();
		System.out.println("A() zero parameterized constructor called");
	}

	public void greet() {
		System.out.println("Hello A !!");
	}

}
