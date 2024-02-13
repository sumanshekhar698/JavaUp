package com.codecounty.java.core.exception_handling;

import java.util.Arrays;
import java.util.Scanner;

public class TryWithResourceExample {

	public static void main(String[] args) {
//		Scanner scanner = null;
		try (Scanner scanner = new Scanner(System.in);// What kind of resource are autoclose able ? All the resource which indirectlyt implements AutoCloseable is eligible for autoclosing in trywithresource block

		) {// try with Resource

			System.out.println("Number ofInput Of Names");
			int numberOfInputs = scanner.nextInt();// take an int input
			String[] stringArrayOfNames = new String[numberOfInputs];

			scanner.nextLine();// Flushing

			for (int i = 0; i < numberOfInputs; i++) {
				System.out.print("Input for Name " + i + " th");
				stringArrayOfNames[i] = scanner.nextLine();
			}

			System.out.println(Arrays.toString(stringArrayOfNames));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
