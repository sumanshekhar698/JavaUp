package dev.codecounty.java.java8.oops.abstract_classes;

public class Cow extends Animal {

	@Override
	void speaks() {// Overrided/Concrete Method
		System.out.println("Cows make sound like MOO~~~~");
	}

	void color() {// Specialized Methods, Concrete Method
		System.out.println("Cows are BROWN, BLACK, WHITE or mix");

	}

}
