package com.sumanshekhar.java.core.arrays.two_dimensional;

public class SearchingIn2Darray {

	public static void main(String[] args) {

		int y[][] = { { 3, 4, 5, 6 }, { 6, 10, 8, 7 }, { 9, 10, 11, 14 } };// hard coding the 2D array

//		1D linear array | 2Pointer [ i, j]
		int item = 29;
		int x[][] = { // full sorted matrix
				{ 10, 21, 30, 40 }, 
				{ 15, 25, 36, 45 }, 
				{ 27, 29, 37, 48 }, 
				{ 32, 33, 39, 50 } };
		
		Integer xx =878;


		
		
		System.out.println(x.length);// 4
		// 16 numnber of cells/elements
		// m = 4 is the length of 2D array
		// 3 [m-1] is the last index of thgis 2D array

		// Brute Force O(n^2) = n*n

//		y[][] = 3*4  = m*n= n*n  = n^2
//		4 * 4= 16 = 4^2  = n=4

//		n n^2  n^3  log(n) n(log(n))

//		log(n) < n < n(log(n)) < n^2 <n^3

//		A = O(log(n))
//		B = O(n(log(n))
//		O(n)
//		Binary Search = O(log n) | The array should be sorted
//		O(n)

		// Brute Force
		for (int i = 0; i < x.length; i++) {// no of 1D arrays in a 2D array
			for (int j = 0; j < x[i].length; j++) {// x[2].length=x[0].length=x[1].length=3
				if (x[i][j] == item)
					System.out.print("Found " + x[i][j] + " [" + i + " " + j + "]");
			}
			System.out.println();
		}

		int n = x.length;
		int i = 0, j = x.length - 1;

	}

}
