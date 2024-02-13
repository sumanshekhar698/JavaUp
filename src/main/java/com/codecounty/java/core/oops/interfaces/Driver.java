package com.codecounty.java.core.oops.interfaces;

public class Driver {

	public static void main(String[] args) {

//	Animal an =	new Animal();//Normally we cannot instantiate an interface
		Animal animal = new Animal() {

			@Override
			public int count() {

				return 10;
			}

			@Override
			public void breathe() {
				System.out.println("Test Breathing");

			}

			@Override
			public boolean isResponsibleForGlobalWarming() {
				// TODO Auto-generated method stub
				return false;
			}
		};// But if we define the body then and there only , then we can instantiate

		int count = animal.count();
		animal.breathe();
		System.out.println(count);
		System.out.println();

		Dog dog = new Dog();
		dog.breathe();
//		System.out.println(dog.isInstinct);
//		System.out.println(	Dog.isInstinct);//Multiple implementation can be cause ambiguity and conflict so care must be taken

		// To remove ambiguity use it Statically from the source
		System.out.println(Animal.isInstinct);
		System.out.println(CarbonFootprint.isInstinct);

		// Static methods dont take part in Inheritance
		CarbonFootprint.earthCrying();

		
//		3. Using Lambda over an Functional interface
		CarbonFootprint cft = () -> {
			return true;
		};
		System.out.println(cft.isResponsibleForGlobalWarming());

	}

}
