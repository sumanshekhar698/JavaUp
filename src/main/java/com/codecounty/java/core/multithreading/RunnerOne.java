package com.codecounty.java.core.multithreading;

public class RunnerOne implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Iteration -> " + i + " ; [" + Thread.currentThread().getName() + " "
					+ Thread.currentThread().getState()+ "]");

		}

	}
}
