package dev.codecounty.java.java8.core.multithreading;

public class DriverOne {

	public static void main(String[] args) {

		System.out.println("START");
		RunnerOne runnerOne = new RunnerOne();// task

		Thread thread1 = new Thread(runnerOne);// thread to execute task
		String name = thread1.getName();
		System.out.println(name);

		Thread thread2 = new Thread(new RunnerOne());
		Thread thread3 = new Thread(new RunnerOne());
		thread3.getState();
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.NORM_PRIORITY);
		thread3.setPriority(Thread.MIN_PRIORITY);// [1-10]
		thread1.getState();
		thread1.start();
		thread2.start();
		thread3.start();

		System.out.println("END");

//		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
//		CompletableFuture<T>

	}

}
