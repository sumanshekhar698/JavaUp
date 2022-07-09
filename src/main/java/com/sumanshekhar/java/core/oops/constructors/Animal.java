package com.sumanshekhar.java.core.oops.constructors;

public class Animal {

	private String species;
	private int noAlive;
	private boolean isEndemic;

	@Override
	public String toString() {
		return "Animal [species=" + species + ", noAlive=" + noAlive + ", isEndemic=" + isEndemic + "]";
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getNoAlive() {
		return noAlive;
	}

	public void setNoAlive(int noAlive) {
		this.noAlive = noAlive;
	}

	public boolean isEndemic() {
		return isEndemic;
	}

	public void setEndemic(boolean isEndemic) {
		this.isEndemic = isEndemic;
	}

	public Animal(String species, int noAlive, boolean isEndemic) {// Parameterized Constructor

//		Constructor has the same name as class
//		Constructor does not has an explicit return type
//		Constructors can be parameterized or parameterless
//		A class can have several constructors

		this();// Used for Constructor Chaining, and it should be the 1st statement
//		super();
		this.species = species;
		this.noAlive = noAlive;
		this.isEndemic = isEndemic;
//		this();
	}

	public Animal() {// Default / No Parameter Constructor
		System.out.println("Animal are lovely");

	}
}
