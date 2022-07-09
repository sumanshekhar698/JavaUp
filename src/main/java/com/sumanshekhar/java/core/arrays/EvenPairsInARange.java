package com.sumanshekhar.java.core.arrays;

// Java implementation of the approach
public class EvenPairsInARange {

// Function to find the count of pairs
// with odd sum and the count
// of pairs with even sum
	static void findPairs(int arr[], int n) {

		// To store the count of even and
		// odd number from the array
		int cntEven = 0, cntOdd = 0;

		for (int i = 0; i < n; i++) {

			// If the current element is even
			if (arr[i] % 2 == 0)
				cntEven++;

			// If it is odd
			else
				cntOdd++;
		}

		// To store the count of
		// pairs with even sum
		int evenPairs = 0;

		// All the even elements will make
		// pairs with each other and the
		// sum of the pair will be even
		evenPairs += ((cntEven * (cntEven - 1)) / 2);

		// All the odd elements will make
		// pairs with each other and the
		// sum of the pair will be even
		evenPairs += ((cntOdd * (cntOdd - 1)) / 2);

		// To store the count of
		// pairs with odd sum
		int oddPairs = 0;

		// All the even elements will make pairs
		// with all the odd element and the
		// sum of the pair will be odd
		oddPairs += (cntEven * cntOdd);

		System.out.println("Odd pairs = " + oddPairs);
		System.out.println("Even pairs = " + evenPairs);
	}

// Driver code
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;

		findPairs(arr, n);
	}
}
