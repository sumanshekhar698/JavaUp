package com.sumanshekhar.java.core.collections.list;

import java.util.Arrays;
import java.util.List;

public class FirstAndLastOccurenceInASortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] geeks = { "Rahul", "Utkarsh", "Shubham", "Neelam" };
		Integer arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };

		// Conversion of array to ArrayList using Arrays.asList
		List<String> al = Arrays.asList(geeks);
		List<Integer> arraysAsList = Arrays.asList(arr);
		// if the type of array is int, then don't try this as it will return a List of
		// int []

		/*
		 * Integer[] array = arraysAsList.toArray();
		 * System.out.println(Arrays.toString(array));
		 */
		findFirstLastUsingArrayList(arraysAsList, 8);
		findFirstUsingBinarySearch(arraysAsList, 8);
		System.out.println(al);
	}

	private static void findFirstLastUsingArrayList(List<Integer> arr, int x) {
//		Drawback O(n)
		System.out.println(arr.indexOf(x));
		System.out.println(arr.lastIndexOf(x));
	}

	private static void findFirstUsingBinarySearch(List<Integer> arr, int x) {
		int l = 0, r = arr.size() - 1, result = -1, m;
		while (l <= r) {
//			m = (l + r) / 2;
			m = l + (r - l) / 2;
			if (arr.get(m) > x)
				r = m - 1;
			else if (arr.get(m) < x)
				l = m + 1;
			else {// if matches
				result = m;// updating result
				r = m - 1;// move to left to find the 1st occurrence
//				l = m + 1;// move to right to find the last occurrence
			}
		}
		System.out.println(result);
	}

	private static void findLastUsingBinarySearch(List<Integer> arr, int x) {
		int l = 0, r = arr.size() - 1, result = -1, m;
		while (l <= r) {
//			m = (l + r) / 2;
			m = l + (r - l) / 2;
			if (arr.get(m) > x)
				r = m - 1;
			else if (arr.get(m) < x)
				l = m + 1;
			else {// if matches
				result = m;// updating result
//				r = m - 1;// move to left to find the 1st occurrence
				l = m + 1;// move to right to find the last occurrence
			}
		}
		System.out.println(result);
	}

}
