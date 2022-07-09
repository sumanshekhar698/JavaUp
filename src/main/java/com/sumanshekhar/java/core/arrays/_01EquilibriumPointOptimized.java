package com.sumanshekhar.java.core.arrays;

public class _01EquilibriumPointOptimized {

	public static void main(String[] args) {
		int x[] = { 4, 2, 3, 7, 5, 4 };

		int requiredEIndex;
		int sum = 0;
		int leftSum = 0;

//		O(n) = 2n  = n = 2*6 = 12 loop iteration
		for (int i = 0; i < x.length; i++) {// 6
			sum += x[i];
		}

		System.out.println(sum);// 25

		for (int i = 0; i < x.length; i++) {// 6
			sum -= x[i];// calculating the right sum
			if (leftSum == sum) {
				requiredEIndex = i + 1;
				System.out.println("FOUND E index-> " + requiredEIndex);
			}
			leftSum += x[i];

		}
	}

}
