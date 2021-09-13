package org.core.threads.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader {
	INSTANCE;
	private Semaphore semaphore = new Semaphore(2, true);

	public void download() throws InterruptedException {
		semaphore.acquire();
		System.out.println("Downloading...");
		Thread.sleep(1000);
		semaphore.release();
	}
}

public class SemaphoreTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 15; i++) {
			service.execute(new Runnable() {

				@Override
				public void run() {
					try {
						Downloader.INSTANCE.download();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

}
