package com.sumanshekhar.java.core.oops.polymorphism;

import static java.lang.Math.PI;

public class MathOperations {

	double area(float radius) {
//		return Math.PI * radius * radius;
		return PI * radius * radius;
	}

	double area(int length) {
		return length * length;
	}

	double area(float length, float breadth) {
		return length * breadth;
	}

}
