package com.codecounty.java.advance.multithreading.multithreading_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadingViaExecutors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("START");
		ExecutorService es = Executors.newFixedThreadPool(5);// Here We are creating Executor Service with a thread pool
																// of 5 working threads.

		Runnable runnableTask = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Running in " + Thread.currentThread().getName());
			}
		};

		es.submit(runnableTask);
		es.submit(runnableTask);
		es.submit(runnableTask);
		es.submit(() -> {
			for (int i = 0; i < 7; i++) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Running in " + Thread.currentThread().getName());

			}
		});

//		es.submit(() -> {
//			System.out.println("Running in " + Thread.currentThread().getName());
//		});

//		es.submit(() -> {
//			System.out.println("Running in " + Thread.currentThread().getName());
//		});

		es.shutdown();// If not provided, Thread will be alive
//		es.shutdownNow();// If not provided, Thread will be alive
//		In real usually it keeps on running
//		es.submit(runnableTask);// will give error as thread-pool has been shutdown
		System.out.println("END");

	}

}
