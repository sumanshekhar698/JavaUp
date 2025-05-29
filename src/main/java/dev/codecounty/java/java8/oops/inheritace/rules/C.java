package dev.codecounty.java.java8.oops.inheritace.rules;

//public class C extends B,A {
public class C extends B {

	int last;
	int a = 7;

	public C(int last) {

		super("Calling B", 333);
		System.out.println(a);//By default it searches value of a in current class
		//Then it will search for a in immediate parent
		System.out.println(super.a);
//		System.out.println(super.super.a);
		System.out.println("Constructor C called");
		this.last = last;
	}
	
	
	void goodExample() {//Specialized Methods
		System.out.println("Good job");
	}

}
