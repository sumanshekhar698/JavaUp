package com.codecounty.java.advance.multithreading.jakob_jenkov.executors;

import java.util.concurrent.*;

public class _1ThreadPoolExecutorSeviceExecute {// Used to create customized thread pool
	public static void main(String[] args) {

		int corePoolSize = 5;// initial thread pool
		int maxPoolSize = 10;// max thread pool size
		long keepAliveTime = 5000;
		// if workers thread are idle for this time, it will return to corePoolSize
		/*
		 * [[[[Parameters]]]
		 * # corePoolSize -> the number of threads to keep in the pool, even if they are
		 * idle, unless allowCoreThreadTimeOut is set
		 * # maximumPoolSize -> the maximum number of threads to allow in the pool
		 * # keepAliveTime -> when the number of threads is greater than the core, this
		 * is the maximum time that excess idle
		 * threads will wait for new tasks before terminating.
		 * # unit -> the time unit for the keepAliveTime
		 * # argumentworkQueue -> the queue to use for holding tasks before they are
		 * executed. This queue will hold only the Runnable tasks submitted by the
		 * execute method.
		 */

		// To us Exeutor Service, you have to create an imlmentation of its
		// There are 2 main implementaion ::
		// 1. ThreadPoolExecutor,
		// 2. ScheduledThreadPoolExecutor

		// 1.1 Dynamic Thread pool Executor Service
		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());// Link Blocking Queue is thread safe

		// 1.2 Fixed thread pool which is infact an instance of ThreadPoolExecutor
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		// 1.3 Single Thread pool is like Executors.newFixedThreadPool(1)
		ExecutorService executorServiceSingle = Executors.newSingleThreadExecutor();

		// 2.1 Scheduled Thread pool Executor :: used to schedule execution is future

		// ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new
		// ScheduledThreadPoolExecutor(corePoolSize);
		// ScheduledExecutorService scheduledThreadPoolExecutor = new
		// ScheduledThreadPoolExecutor(corePoolSize);
		ExecutorService scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(corePoolSize);

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
		executorService.execute(task);
		// executorService.submit(task);// submitting the same task multipe times might
		// cause unforsen errors

		// executorService.submit(task);
		// executorService.submit(task);
		// executorService.submit(task);
		executorService.execute(newRunnable(" msg 1"));
		executorService.execute(newRunnable(" msg 2"));
		executorService.execute(newRunnable(" msg 2"));

		executorService.execute(() -> {
			for (int i = 0; i < 4; i++) {
				System.out.println("Value:" + i + " " + Thread.currentThread().getName());
			}
		});
		executorService.shutdown();
		// executorService.submit(task); //Dont submit a task after executorService has
		// been shutDown

	}

	private static Runnable newRunnable(String msg) {
		return new Runnable() {
			public void run() {
				String newMsg = "Message ::" + msg + " " + Thread.currentThread().getName();
				System.out.println(newMsg);
			}

		};
	}
}
