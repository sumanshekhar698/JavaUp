package com.sumanshekhar.java.core.arrays;

public class _01EquilibriumPoint {

	public static void main(String[] args) {

//		6
		
		int x[] = { 4, 2, 3, 7, 5, 4 };
		int requiredEIndex;
		int leftSum, rightSum;
		
//		O(n) = n*n = n^2= 6^2=36 loop = n^2
		//Brute Force
		for (int i = 0; i < x.length; i++) {// This will traverse through all the elements /indices // 6 times

			leftSum = 0;
			rightSum = 0;

			for (int j = 0; j < i; j++) {// find the sum left to i  | i =3 ; 3 times
				leftSum += x[j];
			}

			for (int j = i + 1; j < x.length; j++) {// find the sum right to i | i = 3 ;3 times
				rightSum += x[j];
			}

			
//			6 times
			if (leftSum == rightSum) {// checking if the index is Eindex
				requiredEIndex = i + 1;
				System.out.println("FOUND E index-> " + requiredEIndex);
				break;
			}

		}

	}

}
