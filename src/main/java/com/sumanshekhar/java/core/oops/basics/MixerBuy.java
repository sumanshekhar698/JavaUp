package com.sumanshekhar.java.core.oops.basics;

public class MixerBuy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MixerGrinder orpat =new MixerGrinder();//orpat as a Object Reference
		//MixerGrinder()
		System.out.println(orpat);//By default it will print the memory address
		
		
		
		orpat.readOutSpecs();// preint the defaulyt values
		
		
//		Default Values
//		integer --> 0
//		float/double -> 0.0
//		Objetct refer nce - null
//		String - null
//		char -> null char
//		boolean --> false
		
		orpat.color="Pink";
		orpat.speed=20000;
		orpat.wattage=240;
		
		orpat.readOutSpecs();
		
		
		
		System.out.println("\n\n\n\n mix1");
		MixerGrinder mix1;
		mix1 = new MixerGrinder();
		System.out.println(mix1);
		mix1.readOutSpecs();
		
		
		MixerGrinder mix2= orpat;
		System.out.println(mix2);
		mix2.readOutSpecs();
		
		orpat.readOutSpecs();
//		mix1.readOutSpecs();
		
		mix1=null;
		orpat=null;

	}

}
