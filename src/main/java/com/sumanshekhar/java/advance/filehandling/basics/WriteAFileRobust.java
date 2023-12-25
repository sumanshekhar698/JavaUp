package com.sumanshekhar.java.advance.filehandling.basics;

import java.io.FileOutputStream;

public class WriteAFileRobust {

	public static void main(String[] args) {
		String path = "C:\\Users\\suman\\eclipse-workspace\\Java B8\\notes\\demo.txt";
		String msg = "Only few months \n left in 2023";

		try (FileOutputStream fos = new FileOutputStream(path)) {
			fos.write(msg.getBytes());

		} catch (Exception e) {
		}

	}

}
