package dev.codecounty.java.java8.advance.filehandling.basics;

import java.io.File;
import java.io.IOException;

public class FileMutation {

	public static void main(String[] args) {

		String path = "C:\\Users\\suman\\eclipse-workspace\\Java B8\\notes\\custom_file.txt";
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
			System.out.println("File is being created >>> ");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (file.exists()) {
			file.delete();
			System.out.println("File Deleted");
		}

	}

}
