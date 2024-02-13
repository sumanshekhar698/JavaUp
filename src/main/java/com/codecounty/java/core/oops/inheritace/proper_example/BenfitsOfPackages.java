package com.codecounty.java.core.oops.inheritace.proper_example;

//import com.jdk8.oop.inheritace.IPLPlayer;
public class BenfitsOfPackages {

	public static void main(String[] args) {

		IPLPlayer iplPlayer = new IPLPlayer();
		iplPlayer.age = 88;
		iplPlayer.method1();

		com.codecounty.java.core.oops.inheritace.IPLPlayer iplPlayer2 = new com.codecounty.java.core.oops.inheritace.IPLPlayer();
		iplPlayer2.BMI = 77;
		iplPlayer2.method2();
	}

}
