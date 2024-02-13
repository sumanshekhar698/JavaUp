package com.codecounty.java.core.basics;

public class BasicOperators {

	public static void main(String[] args) {

		// Increment, Decrement Operators

		// POST Increment Operators
		int x = 9;
		x++;// Post Increment
		System.out.println(x);// 10
		System.out.println(x++);// 10
		System.out.println(x);// 11

		// PRE Increment Operators
		int y = 9;
//		++y;
//		System.out.println(y);
		System.out.println(++y);// 10

//		Q1
		x = 7;
		y = 9;
		y = ++x + ++y + y++ + ++x + y++;// 8 + 10 + 10 + 9 + 11
		System.out.println(y);// 48

//		Q2 [to solve]
		x = 7;
		y = 9;
		y = ++x + ++y + y++ + -y-- + --y - ++x + +--y + y++ + x--;// 8 + 10 + 10 + 9 + 11
		System.out.println(y);

//		Shorthand Operators format
		int m = 9;
		m *= 7;
		System.out.println(m);

//		Bit Wise Operators
		System.out.println(7 & 90);
		System.out.println(7 | 90);
		System.out.println(~-7);
		System.out.println(6 ^ 7);

//		Power method in Java
		double pow = Math.pow(2, 8);
		System.out.println((int) pow);

	}
}
