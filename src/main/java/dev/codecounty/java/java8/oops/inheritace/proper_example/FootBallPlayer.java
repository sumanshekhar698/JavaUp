package dev.codecounty.java.java8.oops.inheritace.proper_example;

public class FootBallPlayer extends Player {
	
	int noOfGoals;
	int noOfAssisted;
	
	
	@Override
	public String toString() {
		return "FootBallPlayer [noOfGoals=" + noOfGoals + ", noOfAssisted=" + noOfAssisted + ", name=" + name + ", age="
				+ age + ", BMI=" + BMI + "]";
	}
	
	

}
