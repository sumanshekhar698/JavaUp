package com.codecounty.java.core.arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inputArray[] = { 5, 66, 77, 6, 88, -4 };// hardcoding a 1D array elements

		int array[] = inputArray.clone();// cloning a different Array
		print1DArray(array);
		System.out.println();
//		int[] reversedArray = reverseArray(inputArray);
//		print1DArray(reversedArray);

		reverseArrayOptimized(array);
		print1DArray(inputArray);

	}

	static void reverseArrayOptimized(int[] x) {
		int i = 0, temp;
//		System.out.println(temp);//Error
		int j = x.length - 1;
		while (i <= j) {
			temp = x[i];
			x[i] = x[j];
			x[j] = temp;
			i++;
			j--;
		}
//		return inputArray;
	}

	static int[] reverseArray(int[] inputArray) {
		int[] reversedArray = new int[inputArray.length];

		int z = 0;
		for (int i = inputArray.length - 1; i >= 0; i--) {
			reversedArray[z++] = inputArray[i];
		}

		return reversedArray;
	}

	static void print1DArray(int[] inputArray) {

		for (int i = 0; i < inputArray.length; i++)
			System.out.print(inputArray[i] + " ");
	}

}
