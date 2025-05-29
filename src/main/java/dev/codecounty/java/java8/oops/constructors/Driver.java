package dev.codecounty.java.java8.oops.constructors;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal animal1 = new Animal();
//		animal1.setSpecies("Lion");
//		animal1.setEndemic(false);
//		animal1.setNoAlive(5000);
		System.out.println(animal1);

		Animal animal2 = new Animal("Buffalo", 6000000, false);
		System.out.println(animal2);

	}

}
