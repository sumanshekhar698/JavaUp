package com.sumanshekhar.java.core.oops.interfaces;

public interface Animal extends CarbonFootprint {
	// JDK ......1.6,1.7,1.8,9,10,.......18
	// Interface can have static methods also since JDK 8
	// Interface can also have default methods since JDK 8
	// Generally methods are implicitly abstract in Interfaces

	boolean isInstinct = false;// Every Variable in final & static

	void breathe();// Abstract methods | abstrac keywords are optional

	int count();

}
