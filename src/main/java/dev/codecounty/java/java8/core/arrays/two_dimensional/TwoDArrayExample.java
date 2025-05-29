package dev.codecounty.java.java8.core.arrays.two_dimensional;

import java.util.Scanner;

public class TwoDArrayExample {

	public static void main(String[] args) {

//		int x[][] = {}

//		***Time Complexity 
		
		
//		O notation (worst time complexity)
//		Space Complexity
		
		Scanner s = new Scanner(System.in);

		int x[][] = { { 3, 4, 5,6 }, { 6, 7, 8,7 }, { 9, 10, 11 ,14} };// hard coding the 2D array

		// Printing in Standard Order
//		O=n^2
		for (int i = 0; i < x.length; i++) {// no of 1D arrays in a 2D array
			for (int j = 0; j < x[i].length; j++) {// x[2].length=x[0].length=x[1].length=3
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}


		System.out.println();// print an empty line

		// Total Reverse Order //		O=n^2
		for (int i = x.length - 1; i >= 0; i--) {// no of 1D arrays in a 2D array
			for (int j = x[i].length - 1; j >= 0; j--) {// x[2].length=x[0].length=x[1].length=3
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
		// Wavy Fashion
		
//		O=n^2
		for (int i = 0; i < x.length; i++) {// no of 1D arrays in a 2D array
			if (i % 2 == 0)
				for (int j = 0; j < x[i].length; j++) {// x[2].length=x[0].length=x[1].length=3
					System.out.print(x[i][j] + " ");
				}
			else
				for (int j = x[i].length - 1; j >= 0; j--) {// x[2].length=x[0].length=x[1].length=3
					System.out.print(x[i][j] + " ");
				}
			System.out.println();
		}
	}

}
// Transpose Of Matrix
// Row by Row reversing
//Column by Column Reversal
// Reverse ?//Wavy Fqaqshion
// Searching

// Rotation, Matrix Multipolication
//Determiannyt, Identinty

//Summation of Matrix
//Sumation of rows columns