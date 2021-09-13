package org.core.threads.advance;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	int count = 0;

	Lock lock = new ReentrantLock();

	void increment() {
		lock.lock();
		try {
			for (int i = 0; i < 1000; i++) {
				count++;
			}
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockTest test = new ReentrantLockTest();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				test.increment();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				test.increment();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Final count = " + test.count);
	}

}
