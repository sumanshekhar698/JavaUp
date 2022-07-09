package com.sumanshekhar.java.advance.multithreading_3;

class MyThread2 implements Runnable {

	volatile private boolean stop;

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

public class VolatiileDemo {

	public static void main(String[] args) {
		System.out.println("Start");
		MyThread2 myThread = new MyThread2();

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
//		myThread.setStop(true);
		System.out.println("end");

	}
}
