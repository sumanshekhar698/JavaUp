package com.codecounty.java.core.oops.inheritace;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IPLPlayer[] RCB=new IPLPlayer[15];
		
		IPLPlayer virat = new IPLPlayer();
		virat.name="Virat Kohli";
		virat.BMI=50;
		virat.matchesPlayed=99;
		virat.StrikeRate= 96;
		virat.age=45;
		System.out.println(virat);
		
		RCB[0]=virat;
		
		
		

	}

}
