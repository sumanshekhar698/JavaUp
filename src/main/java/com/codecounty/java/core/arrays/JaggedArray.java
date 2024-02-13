package com.codecounty.java.core.arrays;

public class JaggedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int B[][] = { { 1, 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3, 3, 5, 7 } };

//		Printing the 2D jagged Array
		for (int i = 0; i < B.length; i++) {// Here B.length = 3
			for (int j = 0; j < B[i].length; j++) {
				System.out.print(B[i][j] + " ");
			}
			System.out.println();
		}
	}
}
