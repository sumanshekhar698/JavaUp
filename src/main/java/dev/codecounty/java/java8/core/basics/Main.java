package dev.codecounty.java.java8.core.basics;
//package name
//import statements
//Annotations

public class Main {

	public static void main(String[] args) {
//		INTEGER
		byte a = 5;
		short s = 77;
		int age = 24;
		int totalAges = age + 56 + 87;
		long distance = 453543;

		age++;// Post Increment Operator
		++age;// Pre Increment
		--age;// Pre Decrement
		age--;// Post Decrement

//		DECIMAL
		float bankBalance = 1000.67f;
		double speedOfLight = 299_794_458.67__687_996;

//		BOOLEAN
		boolean isDay = false;

//		CHAR
		char firstAlphabet = 'A';// UTF16

		System.out.println("Light Speed" + speedOfLight);
		System.out.println("BALANCE " + bankBalance);
		System.out.println("Light Speed" + --firstAlphabet);

	}
}
