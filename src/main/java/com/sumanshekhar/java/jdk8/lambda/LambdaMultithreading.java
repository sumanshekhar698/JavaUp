package com.sumanshekhar.java.jdk8.lambda;

public class LambdaMultithreading {

	public static void main(String[] args) {

		System.out.println("Using  Traditional way");
		MyRunnable myRunnable = new MyRunnable();
		Thread thread1 = new Thread(myRunnable);
		thread1.start();

//		λ Equivalent
		Runnable myRunnable2 = () -> {
			for (int i = 0; i < 9; i++) {
				System.out.println("Main λ THREAD ->" + i);
			}
		};
		Thread thread2 = new Thread(myRunnable2);
		thread2.start();

		for (int i = 0; i < 9; i++) {
			System.out.println("Main THREAD ->" + i);
		}

	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 9; i++) {
			System.out.println("Child THREAD ->" + i);
		}
	}

}
