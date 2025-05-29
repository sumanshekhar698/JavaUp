package dev.codecounty.java.java8.oops.encapsulation;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bird bird1 = new Bird();
		bird1.color = "blue";
		bird1.isEndangered = false;
		bird1.species = "Eagles";

		System.out.println(bird1);
		bird1.isEndangered=true;
		System.out.println(bird1);

	}

}
