package dev.codecounty.java.java8.core.multithreading;

public class RunnerTwo extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Iteration -> " + i + " ; [" + Thread.currentThread().getName() + "]");

		}

	}

}
