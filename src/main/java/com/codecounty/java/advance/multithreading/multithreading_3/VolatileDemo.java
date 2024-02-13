package com.sumanshekhar.java.advance.multithreading.multithreading_3;

class Task_1 implements Runnable {

	volatile private boolean stop;
//	 private boolean stop;

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println(" ~~> " + Thread.currentThread().getName());
		}

	}
}

public class VolatileDemo {

	public static void main(String[] args) {
		System.out.println("Start");
		Task_1 myThread = new Task_1();

		Thread thread = new Thread(myThread);
		thread.start();

//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		myThread.setStop(false);
		myThread.setStop(true);
		myThread.setStop(false);
		myThread.setStop(true);
		System.out.println("end");

	}
}
