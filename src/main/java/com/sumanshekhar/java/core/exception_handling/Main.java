package com.sumanshekhar.java.core.exception_handling;

import java.util.Scanner;
// java.land  package gets imported by default

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		OtpEncryption oe = new OtpEncryption();

		System.out.println("Enter the length of sequence");
		Scanner sc = new Scanner(System.in);
		int c;
		c = sc.nextInt();

		Integer b = 6;// JVM -> Heap(Objects hvdshvsh [6]) | StackFrame(main(){ a =5, b=hvdshvsh )
//		Integer c = new Integer(a);
		int[] numbers = new int[c];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (i + 1) * (i + 1);

		}

		for (int i : numbers) {
			System.out.print(i + " ");
		}
		System.out.println("********************************************");

		numbers = null;

		try {
//			return;
			System.exit(-1);
			System.out.println(numbers[0]);
			System.out.println("END");
		}

		catch (ArrayIndexOutOfBoundsException b1) {
			System.out.println("1st catch block");
			System.out.println(b1.getMessage());
		} catch (Exception arka) {
			System.out.println("2nd catch block");
			System.out.println(arka.getMessage());
		} finally {

			sc.close();
			System.out.println("END");
		}
//User defined Exception Handling
//		try-> catch
//		try -> catch-> finally
//		try -> finally

//		System.out.println("END");

	}

}
