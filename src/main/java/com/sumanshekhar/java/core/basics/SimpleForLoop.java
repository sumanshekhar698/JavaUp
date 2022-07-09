package com.sumanshekhar.java.core.basics;

public class SimpleForLoop {

	public static void main(String[] args) {
		// SUM of 1st n natural numbers
		int n = 10000;
		int sum = 0;
//		Solution 1 [For iteration]
		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		System.out.println("SUM 1 ~> " + sum);

//		System.out.println(i);
		for (int i = 1; i <= n;) {
			sum = sum + i;
			int z = 8;// declaration
			i++;
		}

//		Solution 2 [Maths]
		long start = System.nanoTime();
		sum = n * (n + 1) / 2;
		long end = System.nanoTime();
		System.out.println("SUM 2 ~> " + sum);
		System.out.println("TIME ~> " + (end - start));

//		Break And Continue Statements
		System.out.println("---> ");
		for (int z = 1; z <= 20; z++) {
			if (z % 5 == 0) {
//				break;
				continue;
			}
			System.out.println(z);
		}

	}
}
