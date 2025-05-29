package dev.codecounty.java.java8.advance.multithreading.multithreading_by_defog.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyTry2 {

//    static volatile int ticketsAvailable = 200;
//    static AtomicInteger ticketAtomized = new AtomicInteger(200);

	public static void main(String[] args) throws InterruptedException {
		new Tickets().concur();
	}
}

class Tickets {

	void concur() throws InterruptedException {
		AtomicInteger ticketAtomized = new AtomicInteger(200);

		new Thread(() -> {
			while (ticketAtomized.getAndDecrement() > 0) {
				System.out
						.println(ticketAtomized.get() + " th --> ticket BOOKED by " + Thread.currentThread().getName());
//                ticketAtomized.decrementAndGet();
			}
		}).start();

		new Thread(() -> {
			while (ticketAtomized.getAndDecrement() > 0) {
				System.out
						.println(ticketAtomized.get() + " th --> ticket BOOKED by " + Thread.currentThread().getName());
//                ticketAtomized.decrementAndGet();
			}
		}).start();

		new Thread(() -> {
			while (ticketAtomized.getAndDecrement() > 0) {
				System.out
						.println(ticketAtomized.get() + " th --> ticket BOOKED by " + Thread.currentThread().getName());
//                ticketAtomized.decrementAndGet();
			}
		}).start();

		new Thread(() -> {
			while (ticketAtomized.getAndDecrement() > 0) {
				System.out
						.println(ticketAtomized.get() + " th --> ticket BOOKED by " + Thread.currentThread().getName());
//                ticketAtomized.decrementAndGet();
			}
		}).start();

		Thread.sleep(5000);
		System.out.println("FINAL  --> " + ticketAtomized.get());
	}

}
