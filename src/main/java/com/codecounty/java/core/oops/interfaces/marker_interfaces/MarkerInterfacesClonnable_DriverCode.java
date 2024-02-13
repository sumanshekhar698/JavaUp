package com.codecounty.java.core.oops.interfaces.marker_interfaces;

public class MarkerInterfacesClonnable_DriverCode {
	
	public static void main(String[] args) {
		Dinosaur dinosaur = new Dinosaur("Aerodactyl", "Flying", 360000, true);
//		new Dinosaur();//when we have override the constructor, we cannot use the default constructor unless its specified.
		Object clone = null;
		try {
			 clone = (Dinosaur)dinosaur.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dinosaur dinosaurClone = (Dinosaur)clone;
		System.out.println(clone);
		System.out.println(dinosaurClone);
		if(clone==dinosaur) {
			System.out.println("Cloning failed");
//			int a=7;//local to if block only; will give error if a is already defined;
		}
		else
			System.out.println("Cloning SUCCESS");
		
//		int a=9;//we can re initiate a here since the previous a is only prevalent in th if scope.
//		int c =7+a;
		
	}

}
