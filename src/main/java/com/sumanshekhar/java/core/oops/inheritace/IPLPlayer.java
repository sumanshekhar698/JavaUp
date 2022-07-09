package com.sumanshekhar.java.core.oops.inheritace;

public class IPLPlayer {

	public String name;
	public int age;
	public int BMI;
	public int matchesPlayed;
	public int StrikeRate;

	@Override
	public String toString() {
		return "IPLPlayer [name=" + name + ", age=" + age + ", BMI=" + BMI + ", matchesPlayed=" + matchesPlayed
				+ ", StrikeRate=" + StrikeRate + "]";
	}

	 public void method2() {
		System.out.println("IPLPlayer Class without Inheitance");
	}

}
