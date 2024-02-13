package com.codecounty.java.core.oops.constructors;

public class Box {//Object Class

	float lenght;
	float height;
	float breadth;
	String material;
	
	
	private Box(float lenght, float height, float breadth, String material) {//Explicit Constructor
//		super();
		this.lenght = lenght;
		this.height = height;
		this.breadth = breadth;
		this.material = material;
	}
	
	//What is the use of a private Constructor ?
}
