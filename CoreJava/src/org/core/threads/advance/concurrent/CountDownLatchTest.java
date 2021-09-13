package org.core.threads.advance.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable {
	CountDownLatch countDownLatch;

	public Worker(CountDownLatch latch) {
		countDownLatch = latch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " running...");
		countDownLatch.countDown();
		// try {
		// Thread.sleep(500);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		System.out.println(Thread.currentThread().getName() + " running again...");
	}
}

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cdLatch = new CountDownLatch(5);
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			service.submit(new Worker(cdLatch));
		}
		cdLatch.await();
		// Thread.sleep(5000);
		System.out.println("Finished all tasks");
	}

}
