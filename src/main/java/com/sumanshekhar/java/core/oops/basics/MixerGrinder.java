package com.sumanshekhar.java.core.oops.basics;

public class MixerGrinder {
	
	//Instance variable/Object Variables
	int wattage;
	String color;
	int speed;
	
	void grind(){
		System.out.println("GRINDING");
	}
	
	void mixing(){
		System.out.println("MIXING");
	}
	
	void blending(){
		System.out.println("BLENDING");
	}
	
	void readOutSpecs() {
		System.out.println("Wattage -> "+wattage);
		System.out.println("Speed -> "+speed);
		System.out.println("Color -> "+color);
		
	}

}
