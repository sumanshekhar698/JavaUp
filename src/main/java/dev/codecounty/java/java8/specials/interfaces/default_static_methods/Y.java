package dev.codecounty.java.java8.specials.interfaces.default_static_methods;

public interface Y {

	void write();

	default void climb() {
		System.out.println("Climbing link a Bear");
	}

	static void jump() {
		System.out.println("Jumpimgh like a Frog");
	}
}
