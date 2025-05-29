package dev.codecounty.java.java8.oops.inheritace.proper_example;

//import com.jdk8.oop.inheritace.IPLPlayer;
public class BenfitsOfPackages {

	public static void main(String[] args) {

		IPLPlayer iplPlayer = new IPLPlayer();
		iplPlayer.age = 88;
		iplPlayer.method1();

		dev.codecounty.java.java8.oops.inheritace.IPLPlayer iplPlayer2 = new dev.codecounty.java.java8.oops.inheritace.IPLPlayer();
		iplPlayer2.BMI = 77;
		iplPlayer2.method2();
	}

}
