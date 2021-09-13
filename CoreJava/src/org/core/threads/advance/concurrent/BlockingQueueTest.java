package org.core.threads.advance.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FirstWorker implements Runnable {
	BlockingQueue<Integer> queue;

	public FirstWorker(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			try {
				System.out.println("Adding to queue: " + count);
				queue.put(count++);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class SecondWorker implements Runnable {
	BlockingQueue<Integer> queue;

	public SecondWorker(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int num = queue.take();
				System.out.println("Taking from queue: " + num);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
		new Thread(new FirstWorker(queue)).start();
		new Thread(new SecondWorker(queue)).start();
	}

}
