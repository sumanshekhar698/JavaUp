package com.sumanshekhar.java.advance.filehandling.basics;

import java.io.File;
import java.io.IOException;

public class FileHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "C:sample.txt";

		File file = new File(path);
//		FileInputStream
//		Scanner
		if (file.exists())
			System.out.println(true);
		else
			System.out.println(false);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
