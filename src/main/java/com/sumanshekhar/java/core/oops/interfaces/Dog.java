package com.sumanshekhar.java.core.oops.interfaces;

public class Dog extends Survey implements Animal, CarbonFootprint {// extends keyword will be always before implements
																	// keyword

	@Override
	public void breathe() {
		System.out.println("Dog breathes faster while running");

	}

	@Override
	public int count() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isResponsibleForGlobalWarming() {
		return false;
	}

}
