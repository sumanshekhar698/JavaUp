package com.sumanshekhar.java.core.oops.abstract_classes;

public class Tiger extends Animal {

	@Override
	void speaks() {// Overrided
		System.out.println("Tiger ROARS####");

	}

	void species() {// Specialized
		System.out.println("The most prestigious species of tigers are Sundarban Tigers");
	}

}
