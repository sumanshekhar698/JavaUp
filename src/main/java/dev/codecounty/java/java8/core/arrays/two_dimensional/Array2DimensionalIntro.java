package dev.codecounty.java.java8.core.arrays.two_dimensional;

import java.util.Scanner;

public class Array2DimensionalIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] array2D = { { 1, 2, 3 }, { 4, 5, 6 }// 2*3 2Darray
		};

		ArrayMultipication.printMatrix2D(array2D);

		int[][] arrayExample = new int[2][3];
		ArrayMultipication.printMatrix2D(arrayExample);

		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < arrayExample.length; i++) {// number of 1D array in a 2d array
			for (int j = 0; j < arrayExample[i].length; j++)
				arrayExample[i][j] = scanner.nextInt();
		}

		ArrayMultipication.printMatrix2D(arrayExample);

//		Jaggerd 2d array

	}

}
