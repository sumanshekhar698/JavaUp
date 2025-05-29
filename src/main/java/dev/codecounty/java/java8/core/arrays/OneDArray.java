package dev.codecounty.java.java8.core.arrays;

import java.util.Scanner;

public class OneDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int zeroLengthArray[] = new int[0];// Zero length array is possible in Java
		int[] x = new int[3];

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < x.length; i++) {// Print the initial contents of array. It will show the default values
			System.out.print(x[i] + " ");
		}

		for (int i = 0; i < x.length; i++) {// Taking Input
			x[i] = sc.nextInt();
		}

		for (int i = 0; i < x.length; i++) {// Print the contents of array
			System.out.print(x[i] + " ");
		}

	}

}
