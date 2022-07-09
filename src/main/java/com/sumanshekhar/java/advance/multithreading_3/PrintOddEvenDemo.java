package com.sumanshekhar.java.advance.multithreading_3;

/*
1 thread-0
2 thread-1
3
10
 */
class PrintEvenOdd implements Runnable {
	static int num = 1;
	int remainder;
	static Object lock = new Object();

	PrintEvenOdd(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (num < 10) {
			synchronized (lock) {
				while (num % 2 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " -->  " + num);
				num++;
				lock.notifyAll();
			}
		}
	}
}

public class PrintOddEvenDemo {

	public static void main(String[] args) {
		PrintEvenOdd runnable1 = new PrintEvenOdd(1);
		PrintEvenOdd runnable2 = new PrintEvenOdd(0);
		Thread t1 = new Thread(runnable1, "Thread 1");
		Thread t2 = new Thread(runnable2, "Thread 2");
		t1.start();
		t2.start();
	}
}
