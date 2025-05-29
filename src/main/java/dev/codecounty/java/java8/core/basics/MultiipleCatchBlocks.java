package dev.codecounty.java.java8.core.basics;

import java.util.Scanner;

public class MultiipleCatchBlocks {

	public static void main(String[] args) {

		System.out.println("START");
		Scanner sc = new Scanner(System.in);

		int x[] = { 3, 6, 7, 8, 1, 0 };
		try {

			MultiipleCatchBlocks.main(args);

			while (true) {
			}
//			System.out.println(x[0 / 0]);
		} catch (ArithmeticException e) {

			System.out.println("1");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("2");
			e.printStackTrace();
		}

//		catch (Throwable e) {
//			System.out.println("3");
//			e.printStackTrace();
//		} 

		finally {
			System.out.println("YOLO");
		}

		System.out.println("END");

	}

}
