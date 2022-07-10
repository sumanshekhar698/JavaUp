package com.sumanshekhar.java.core.oops.constructors;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MessengerConstructorChaining m1 = new MessengerConstructorChaining(2, "Hello");
		System.out.println(m1.hashCode());
		// hash of the object in decimal format
		// m1 | hex format of decimal
		System.out.println(m1);
		// DEFAULT : hashcode in hex decimal format
		// toString()

		MessengerConstructorChaining m2 = new MessengerConstructorChaining(2, "Hello");
		System.out.println(m2.hashCode());

		MessengerConstructorChaining m3 = new MessengerConstructorChaining(2, "Hello");
		System.out.println(m3.hashCode());
		System.out.println(m3);
		
//		new Employee();

	}

//	156643D4
//	156643d4

}
