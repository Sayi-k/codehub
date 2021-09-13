package org.core.threads.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName() + " --- " + i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class ExecutorServiceTest {

	public static void main(String[] args) {
		Worker1 worker = new Worker1();
		ExecutorService service = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 5; i++) {
			service.execute(worker);
		}
	}

}
