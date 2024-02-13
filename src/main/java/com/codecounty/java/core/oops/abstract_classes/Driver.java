package com.codecounty.java.core.oops.abstract_classes;

public class Driver {

	public static void main(String[] args) {

//		Animal animal = new Animal();//abstract class cannot be normally instantiated
		Cow cow = new Cow();
		cow.speaks();
		cow.breathe();// Inherited
		cow.color();// Specialized

		Tiger tiger = new Tiger();
		tiger.breathe();
		tiger.speaks();// Overided
		tiger.species();// Specialized

		// Up casting- Assigning a Parent reference to the CHild Object
		Animal cowAnimal = new Cow();
		cowAnimal.breathe();
		cowAnimal.speaks();

		// Down casting- DownCasting an already upcasted object
//		Upcasting and Downcasting does not create new Objects !!!
		Cow cow3 = (Cow) cowAnimal;// Downcasting
		// It is ONLY possible when we are down casting an already upcasted objects\

		Lion lion = new Lion();
		lion.breathe();
		lion.speaks();
		lion.king();

	}

}
