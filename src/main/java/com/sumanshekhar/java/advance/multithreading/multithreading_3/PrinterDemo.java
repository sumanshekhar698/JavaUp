package com.sumanshekhar.java.advance.multithreading.multithreading_3;

import java.util.concurrent.atomic.AtomicInteger;

class Printer {
	synchronized void print(String content, int line) {// synchronized makes any block or method thread safe
		for (int i = 0; i < line; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(content + " ~~> " + Thread.currentThread().getName());
		} // CPU will do the context switching
	}
}

class VisitorCount {
	private int total;

	public int getTotal() {
		return total;
	}

	synchronized void incrementVisitor() {// Synchronized will remove the Race condition
		total++;
		/*
		 * CPU reads value 
		 * increment value 
		 * write value
		 */
	}

}

class VisitorCountAtomized {
	private AtomicInteger total = new AtomicInteger(0);

	synchronized void incrementVisitor() {// Synchronized will remove the Race condition
		total.incrementAndGet();
	}

	public int getTotal() {
		return total.get();
	}

}

public class PrinterDemo {

	public static void main(String[] args) throws InterruptedException {

		String data1 = "I am bored";
		String data2 = "Boredom is fun";
		String data3 = "but too much fun is boring";
		String data4 = "So is having fun boring ?";
//		Printer printer = new Printer();

//		VisitorCount visitorCount = new VisitorCount();//Synchronized
		VisitorCountAtomized visitorCount = new VisitorCountAtomized();// Atomized

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				visitorCount.incrementVisitor();
			}

//			printer.print(data1, 10);
		});

		Thread thread2 = new Thread(() -> {
//			printer.print(data2, 10);
			for (int i = 0; i < 1000; i++) {
				visitorCount.incrementVisitor();
			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();
		int total = visitorCount.getTotal();
		System.out.println(total);
//		ExecutorService es = Executors.newFixedThreadPool(3);
//		es.submit(() -> {
//			printer.print(data1, 10);
//		});
//
//		es.submit(() -> {
//			printer.print(data2, 10);
//		});
//
//		es.submit(() -> {
//			printer.print(data3, 10);
//		});
//
//		es.submit(() -> {
//			printer.print(data4, 10);
//		});
//		es.shutdown();

	}
}
