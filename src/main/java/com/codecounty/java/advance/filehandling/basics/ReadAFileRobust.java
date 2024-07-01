package com.codecounty.java.advance.filehandling.basics;

import java.io.FileInputStream;

public class ReadAFileRobust {

	public static void main(String[] args) {
		String path = "C:\\Users\\suman\\eclipse-workspace\\Java B8\\notes\\demo.txt";

		try (FileInputStream fis = new FileInputStream(path)) {
			int readChar = 0;
			while ((readChar = fis.read()) != -1) {
				System.out.print((char)readChar);

			}

		} catch (Exception e) {
		}

	}

}
