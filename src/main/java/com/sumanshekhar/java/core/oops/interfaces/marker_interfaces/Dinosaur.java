package com.sumanshekhar.java.core.oops.interfaces.marker_interfaces;

public class Dinosaur implements Cloneable{
	private String name;
	private String type;
	private int exitingAge;
	private boolean carnivorus;
	
	@Override  
	protected Object clone() throws CloneNotSupportedException {  
	return super.clone();  
	}  
	
	
	@Override
	public String toString() {
		return "Dinosaur [name=" + name + ", type=" + type + ", exitingAge=" + exitingAge + ", carnivorus=" + carnivorus
				+ "]";
	}


	public Dinosaur(String name, String species, int exitingAge, boolean carnivorus) {
		super();
		this.name = name;
		this.type = species;
		this.exitingAge = exitingAge;
		this.carnivorus = carnivorus;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return type;
	}
	public void setSpecies(String species) {
		this.type = species;
	}
	public int getExitingAge() {
		return exitingAge;
	}
	public void setExitingAge(int exitingAge) {
		this.exitingAge = exitingAge;
	}
	public boolean isCarnivorus() {
		return carnivorus;
	}
	public void setCarnivorus(boolean carnivorus) {
		this.carnivorus = carnivorus;
	}

}
