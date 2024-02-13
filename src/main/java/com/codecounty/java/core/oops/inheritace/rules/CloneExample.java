package com.codecounty.java.core.oops.inheritace.rules;

import java.util.Arrays;

public class CloneExample {

	public static void main(String[] args) {

		int[] x = { 4, 6, 2, 88, 99 };// Every array is an object
		System.out.println(x);
		int z[] = x;

		// taking a backup
		int y[] = new int[x.length];
		for (int i = 0; i < y.length; i++) {
			y[i] = x[i];
		}

		//
		int[] m = x.clone();// Dont try to clone any thing you wish
//		you can clone any array

//		System.out.println(x.toString());
//		String valueOf = String.valueOf(x);
		System.out.println(Arrays.toString(x));
		increment(x);
		System.out.println(Arrays.toString(z));// [5, 7, 3, 89, 100]
		System.out.println(Arrays.toString(x));// [5, 7, 3, 89, 100]
		System.out.println(Arrays.toString(y));// [4, 6, 2, 88, 99]
		System.out.println(Arrays.toString(m));// [4, 6, 2, 88, 99]

		System.out.println(z);
		System.out.println(x);

	}

	private static void increment(int[] y) {

		for (int i = 0; i < y.length; i++) {
			y[i] += 1;
		}

	}

}
