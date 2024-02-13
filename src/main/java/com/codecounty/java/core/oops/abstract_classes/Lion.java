package com.codecounty.java.core.oops.abstract_classes;

public class Lion extends Animal {// extend Inheritance , you can ONLY extend one class

	@Override
	void speaks() {
		System.out.println("LION ROARS LOUDER");

	}

//	@Override
//	void breathe() {
//		System.out.println("Lions breath fatser");
//	}

	void king() {// Specialized Method
		System.out.println("LION IS THE KING OF JUNGLE");
	}

}
