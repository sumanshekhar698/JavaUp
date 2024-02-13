package com.codecounty.java.core.oops.encapsulation;

public class Driver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bird2 bird1 = new Bird2(0, null, null, false);

//		bird1.color = "blue";//Direct access will give error for private variables
//		bird1.isEndangered = false;
//		bird1.species = "Eagles";

		bird1.setColor("Blue");
		bird1.setEndangered(false);
		bird1.setSpecies("Eagles");

		System.out.println(bird1);
		System.out.println(bird1.getColor());

//		bird1.chirp();

	}
}
