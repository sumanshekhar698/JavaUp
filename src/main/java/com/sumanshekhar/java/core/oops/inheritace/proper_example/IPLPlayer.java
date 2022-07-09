package com.sumanshekhar.java.core.oops.inheritace.proper_example;

public class IPLPlayer extends Player {

	int matchesPlayed;
	int StrikeRate;

	@Override
	public String toString() {
		return "IPLPlayer [matchesPlayed=" + matchesPlayed + ", StrikeRate=" + StrikeRate + ", name=" + name + ", age="
				+ age + ", BMI=" + BMI + "]";
	}

	void method1() {
		System.out.println("IPLPlayer Class using Inheitance");
	}
	
	
	public IPLPlayer() {
		super();
		System.out.println("IPL Player Constructor Triggered");
	}

	@Override
	public void stats() {
		super.stats();
		System.out.println("STRIKE RATE ->" + StrikeRate);
	}

}
