package dev.codecounty.java.java8.core.exception_handling;

import java.util.Scanner;

public class VotingEligiblity {

	public static void main(String[] args) {

		System.out.println("START");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter you age");
		int age = scanner.nextInt();

		try {
			validate(age);
		} catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		System.out.println("END");

	}

	private static void validate(int age) throws InvalidAgeException {

		if (age >= 18)
			System.out.println("ELIGIBLE");
		else
			throw new InvalidAgeException("Invalid Age for Voting");// Creating an Exception

	}
}

class InvalidAgeException extends Exception {

	private static final long serialVersionUID = 1L;

	InvalidAgeException(String msg) {
		super(msg);
	}
}
