package dev.codecounty.java.java8.advance.filehandling.basics;

import java.io.File;

public class FileInfo {

	public static void main(String[] args) {

		String path = "C:\\Users\\suman\\eclipse-workspace\\Java B8\\notes\\demo.txt";
		File file = new File(path);

		System.out.println(file.exists());

		if (file.exists()) {
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getName());
			System.out.println(file.canRead());
			System.out.println(file.canWrite());
			System.out.println(file.isHidden());


		} else {
			System.out.println("File is missing in the given path");
		}

	}

}
