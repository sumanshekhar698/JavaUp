package com.sumanshekhar.java.core.exception_handling;

import java.io.FileOutputStream;
import java.util.Scanner;

public class TryWithResource {
	public static void main(String[] args) {

		Scanner sc;

		// Creating an object of FileOutputStream to write stream or raw data
		try (FileOutputStream fos = new FileOutputStream("docs/sample.txt");
//				sc = new Scanner(System.in);
				Scanner scan = new Scanner(System.in);) {// Adding resource
			System.out.println("Give the input to write");
			String text = "GeekSter took input" + scan.nextLine();
			byte arr[] = text.getBytes();
			fos.write(arr);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("END");

	}

}
