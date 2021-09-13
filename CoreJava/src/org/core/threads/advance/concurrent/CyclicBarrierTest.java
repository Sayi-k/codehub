package org.core.threads.advance.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker1 implements Runnable {
	CyclicBarrier cb;

	public Worker1(CyclicBarrier cb) {
		this.cb = cb;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " running...");
		// try {
		// Thread.sleep(500);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " running agin and finished");
	}
}

public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				System.out.println("Cyclic Barrier finished");
			}
		});

		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			service.submit(new Worker1(cb));
		}
		System.out.println("All tasks finished");
	}

}
