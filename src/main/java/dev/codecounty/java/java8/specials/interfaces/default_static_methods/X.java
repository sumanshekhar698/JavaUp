package dev.codecounty.java.java8.specials.interfaces.default_static_methods;

public interface X {

	void sing();

	default void climb() {
		System.out.println("Climbing link a Monkey");
	}
	
	static void jump() {
		System.out.println("Jumpimgh like a Beetle");
	}

}
