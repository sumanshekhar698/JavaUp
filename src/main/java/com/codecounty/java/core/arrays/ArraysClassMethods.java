package com.codecounty.java.core.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArraysClassMethods {

	public static void main(String[] args) {

		int x[] = { 4, 6, 7, 2, 8, 0 };
		int z[] = { 4, 6, 7, 2, 8, 0 };
		System.out.println(Arrays.toString(x));

		Arrays.sort(x);
		System.out.println(Arrays.toString(x));

		int y[] = x;
		if (y == x)
			System.out.println("Equal1");
		if (z == x)// unequal
			System.out.println("Equal2");

		int[] arr1 = { 13, 7, 6, 45, 21, 9, 2, 100, 76, 455 };// [7, 6, 45, 21]
		Arrays.sort(arr1, 1, 5);
		System.out.printf("Modified arr1[] : %s", Arrays.toString(arr1));

//		Sort in Descending
		Integer[] arr2 = { 13, 7, 6, 45, 21, 9, 2, 100 };// The array should be of Integer type not int type
		Arrays.sort(arr2, Collections.reverseOrder());// returns a comparator
		System.out.printf("\nModified arr2[] : %s", Arrays.toString(arr2));

		String arr3[] = { "SUSAN", "SAM", "AMY", "ANNA", "ANABELLA" };
		Arrays.sort(arr3);
		System.out.printf("\nModified arr3[] : %s\n\n", Arrays.toString(arr3));

		Arrays.sort(arr3, Collections.reverseOrder());
		System.out.printf("Modified arr3[] : %s\n\n", Arrays.toString(arr3));

	}
}
