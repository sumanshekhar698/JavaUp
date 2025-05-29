package dev.codecounty.java.java8.core.multithreading;

public class DriverTwo {

	public static void main(String[] args) {

		System.out.println("START");
		RunnerTwo r1 = new RunnerTwo();
		r1.start();
		try {
			r1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		RunnerTwo r2 = new RunnerTwo();
//		r2.start();
//		
//		RunnerTwo r3 = new RunnerTwo();
//		r3.start();
		System.out.println("END");

	}
}
