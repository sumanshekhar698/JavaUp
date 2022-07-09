package com.sumanshekhar.java.jdk8.interfaces.default_static_methods;

public class SampleTwo implements X, Y {

	@Override
	public void write() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub

	}

	@Override // Override to remove Ambiguity
	public void climb() {
		X.super.climb();
		System.out.println("Climbing lika a human");
		Y.super.climb();
	}

}
