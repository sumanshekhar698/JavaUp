package dev.codecounty.java.java8.oops.abstract_classes;

public abstract class Animal {
//	0-100% Abstraction using Abstract Class
	boolean isExtinct;// Instance Variable

	final void breathe() {// Concrete/Non Abstract Methods/Non Overidable due to final
		System.out.println("Every Animal Breathe");
	}

	abstract void speaks();// Abstract Method

}
