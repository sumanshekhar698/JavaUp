package com.sumanshekhar.java.core.oops.interfaces.functional_interfaces_basic;

import java.util.Scanner;

public class MainShapes {

	static int m = 7;

	public static void main(String[] args) {

		int x = 8;
		Shapes s0 = new Shapes() {// Anonymous Inner Class
			@Override
			public int area() {
				int y = x;
				System.out.println("Arae depende on diomensions");
				return 0;
			}
		};

//		s0.area();

		// Lambda Fn
		Shapes s1 = () -> {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Area of a Square ?" + MainShapes.m);
			int side = scanner.nextInt();
			int area = side * side;
			System.out.println("Arae of square = " + area);
			scanner.close();
			return area;
		};

		Shapes c1 = () -> {
//			Scanner scanner = new Scanner(System.in);
			System.out.println("Area of a Circle");
			int radius = 7;
			int area = (int) (Math.PI * radius * radius);
			System.out.println("Arae of circle = " + area);
//			scanner.close();
			return area;
		};

		int area = s1.area();
		area = c1.area();

	}

}
