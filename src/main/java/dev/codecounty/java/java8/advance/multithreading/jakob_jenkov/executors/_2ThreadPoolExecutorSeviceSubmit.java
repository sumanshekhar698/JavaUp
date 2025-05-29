package dev.codecounty.java.java8.advance.multithreading.jakob_jenkov.executors;

import java.util.concurrent.*;

public class _2ThreadPoolExecutorSeviceSubmit {// Used to create customized thread pool
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Runnable task = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Running in " + Thread.currentThread().getName());
			}
		};

		// executorService.execute(task);
		Future future = executorService.submit(task);// submit method is like execute method,
		// but it returns an Future object

		System.out.println(future.isDone());// probably false

		try {
			System.out.println(future.get());// null because runnable doesnt return anything
			// Also get method blocks the thread until result is available
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(future.isDone());// for sure true
		executorService.shutdown();

	}

}
