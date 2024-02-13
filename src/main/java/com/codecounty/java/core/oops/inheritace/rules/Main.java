package com.codecounty.java.core.oops.inheritace.rules;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		C c = new C(9);
//		c.greet();
		
		B b = new B("314", 413);
		b.greet();//overiding
		c.shout();//inherited
		c.goodExample();

	}

}
