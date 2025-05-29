package dev.codecounty.java.java8.oops.inheritace.proper_example;

public class Tester3 {

	public static void main(String[] args) {

//		Football
		FootBallPlayer[] barcelona = new FootBallPlayer[15];
		FootBallPlayer messi = new FootBallPlayer();
		messi.name = "Messi";
		messi.age = 47;
		System.out.println(messi);
		barcelona[0] = messi;

//		IPL Team
		IPLPlayer[] RCB = new IPLPlayer[15];
		IPLPlayer virat = new IPLPlayer();
		virat.name = "Virat Kohli";
		virat.BMI = 50;
		virat.matchesPlayed = 99;
		virat.StrikeRate = 96;
		virat.age = 45;
//		System.out.println(virat);
		virat.stats();

		RCB[0] = virat;
		
//		IPLPlayer iii = new Player();//You cannot create a Child Object and assign it to Parent refernce
	}

}
