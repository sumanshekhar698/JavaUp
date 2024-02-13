package com.sumanshekhar.java.advance.multithreading.basics.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeThreadHandlingUsingAtomicInteger {

	static class Counter {
//		private int x = 0;
		private AtomicInteger x = new AtomicInteger(0);

		public int getX() {
			return x.get();
		}

//		synchronized void incrementX() {//synchronizing will fix this issue
		void incrementX() {
			x.getAndIncrement();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		final Counter counter = new Counter();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				counter.incrementX();
			}).start();

		}

		Thread.sleep(10000);
		System.out.println("10000 ? " + counter.getX());

	}

}
