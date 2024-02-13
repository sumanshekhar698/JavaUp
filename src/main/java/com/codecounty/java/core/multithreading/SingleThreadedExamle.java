package com.codecounty.java.core.multithreading;

public class SingleThreadedExamle {

	public static void main(String[] args) {

		System.out.println("START");
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);// Must be handled
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Squares -> " + (i * i));
		}
		System.out.println("END");
	}

}
