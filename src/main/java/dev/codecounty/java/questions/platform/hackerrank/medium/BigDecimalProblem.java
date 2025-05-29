package dev.codecounty.java.questions.platform.hackerrank.medium;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BigDecimalProblem {

	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();

		// Write your code here

//		Ascending Order
//		Arrays.sort(s, 0, n, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				// TODO Auto-generated method stub
//				BigDecimal a = new BigDecimal(s1);
//				BigDecimal b = new BigDecimal(s2);
//				return a.compareTo(b);
//			}
//		});
//		Descending order
		Arrays.sort(s, 0, n, Collections.reverseOrder(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				BigDecimal b1 = new BigDecimal(s1);
				BigDecimal b2 = new BigDecimal(s2);
				return b1.compareTo(b2);
			}
		}));

		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}
}