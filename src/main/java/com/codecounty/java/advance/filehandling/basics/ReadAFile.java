package com.codecounty.java.advance.filehandling.basics;

import java.io.File;
import java.util.Scanner;

public class ReadAFile {

	public static void main(String[] args) {
		String path = "C:\\Users\\suman\\eclipse-workspace\\Java B8\\notes\\demo.txt";
		File file = new File(path);

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

		} catch (Exception e) {
		}

	}

}
