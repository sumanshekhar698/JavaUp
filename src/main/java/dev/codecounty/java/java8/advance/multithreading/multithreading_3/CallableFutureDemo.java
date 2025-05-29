package dev.codecounty.java.java8.advance.multithreading.multithreading_3;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import dev.codecounty.java.java8.advance.filehandling.gson.KeywordAnalyserImplementation;
import dev.codecounty.java.java8.advance.filehandling.gson.KeywordAnalyzerInterface;
import dev.codecounty.java.java8.advance.filehandling.gson.KeywordAndFrequency;


class MyTask2 implements Callable<List<KeywordAndFrequency>> {// Callable can return something which the Parent thread
																// can read and use later
	private KeywordAnalyzerInterface kai;

	@Override
	public List<KeywordAndFrequency> call() throws Exception {
		return kai.getAllKeywordWithFreq();
	}

	public MyTask2() {
		super();
	}

	public MyTask2(KeywordAnalyzerInterface kai) {
		super();
		this.kai = kai;
	}

}

public class CallableFutureDemo {
	public static void main(String[] args) {
		System.out.println("START");
		KeywordAnalyserImplementation kai = new KeywordAnalyserImplementation();
		kai.recordKeyword("JAVA");
		kai.recordKeyword("GO");
		kai.recordKeyword("C++");
		kai.recordKeyword("GO");

		MyTask2 myTask2 = new MyTask2(kai);
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<List<KeywordAndFrequency>> submitFutureList = executorService.submit(myTask2);

		executorService.shutdown();
		System.out.println(submitFutureList.isDone());

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (submitFutureList.isDone()) {
			try {
//				System.out.println(submitFutureList.get());// get() blocks the main thread until the current thread has
				// finished execution
				System.out.println(submitFutureList.get(30, TimeUnit.MILLISECONDS));// If results is not received in 30
																					// ms throws TimeoutException
				System.out.println(submitFutureList.isDone());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				System.out.println("SLA Breached");// Service Level Agreement Breach
				e.printStackTrace();
			}
		}

		System.out.println("END");
	}
}
