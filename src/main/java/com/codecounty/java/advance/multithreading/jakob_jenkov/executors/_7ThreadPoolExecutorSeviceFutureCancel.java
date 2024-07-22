package com.codecounty.java.advance.multithreading.jakob_jenkov.executors;

import java.util.List;
import java.util.concurrent.*;

public class _7ThreadPoolExecutorSeviceFutureCancel {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(newCallable("Hey"));

		System.out.println(future.isDone());

		boolean mayInterrupt = true;

		// uncommenting the below code will give enough time for the Future Task to
		// complete so cancel() will have no effect

		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		boolean wasCanceled = future.cancel(mayInterrupt);// no effect if already completed or canceled or could not be
															// canceled
		// if the task hasnt run so after cancel it will never run
		System.out.println(wasCanceled);

		System.out.println(future.isCancelled());// true because its canceled | true is the task is canceled before it
													// completed
		System.out.println(future.isDone());// true because its canceled | true :: normal termination, cancelation,
											// exception

		try {
			System.out.println(future.get());// Will get CancellationException when trying to get a FutureTask that has
												// been
												// cancelled = true
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} catch (CancellationException e) {// unchecked
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
