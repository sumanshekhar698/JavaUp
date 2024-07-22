package com.codecounty.java.advance.multithreading.jakob_jenkov.executors;

import java.util.concurrent.*;

public class _8JDK19ThreadPoolExecutorSeviceVirtualThreads {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();// This Executor will use 1
																						// virtual Thread/task submitted
																						// to it, The number of threads
																						// is unbounded

		// We use virtual thread Executor Service ::
		// We already have a system ready with Executor Service, so minimal change
		// Take advantage of Executors Framework and Future a& All


		Future<String> future = executorService.submit(newCallable("Hey"));
		System.out.println(future.isDone());

		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println(future.isDone());
		executorService.shutdown();

	}

	private static Callable<String> newCallable(String msg) {// Type safe version

		return new Callable<String>() {
			public String call() {
				String newMsg = "Message | " + msg + " threadData :: " + Thread.currentThread().getName();
				return newMsg;
			}

		};

	}
}
