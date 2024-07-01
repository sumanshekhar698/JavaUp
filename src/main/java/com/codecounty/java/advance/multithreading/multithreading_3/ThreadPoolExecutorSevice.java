package com.codecounty.java.advance.multithreading.multithreading_3;

import java.util.concurrent.*;

public class ThreadPoolExecutorSevice {// Used to create customized thread pool
	public static void main(String[] args) {

		int corePoolSize = 5;// initial thread pool
		int maxPoolSize = 10;// max thread pool size
		long keepAliveTime = 5000;
		// if workers thread are idle for this time, it will return to corePoolSize
		/*
		 * [[[[Parameters]]]
		 * # corePoolSize -> the number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut is set
		 * # maximumPoolSize ->  the maximum number of threads to allow in the pool
		 * # keepAliveTime -> when the number of threads is greater than the core, this is the maximum time that excess idle
		 * threads will wait for new tasks before terminating.
		 * # unit -> the time unit for the keepAliveTime 
		 * # argumentworkQueue -> the queue to use for holding tasks before they are executed. This queue will hold only the Runnable tasks submitted by the execute method.
		 */

		//Dynamic Thread pool
		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());// Link Blocking Queue is thread safe

		//Fixed thread pool
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		//Single Thread pool
		ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();

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
		executorService.submit(task);
		executorService.submit(task);
		executorService.submit(task);
		executorService.submit(task);
		executorService.submit(task);
		executorService.submit(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("value:" + i + " " + Thread.currentThread().getName());
			}
		});
		executorService.shutdown();
		executorService.submit(task);

	}
}
