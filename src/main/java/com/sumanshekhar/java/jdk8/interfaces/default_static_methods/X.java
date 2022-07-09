package com.sumanshekhar.java.jdk8.interfaces.default_static_methods;

public interface X {

	void sing();

	default void climb() {
		System.out.println("Climbing link a Monkey");
	}
	
	static void jump() {
		System.out.println("Jumpimgh like a Beetle");
	}

}
