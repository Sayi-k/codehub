package org.core.threads.advance;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {
	public Lock lock = new ReentrantLock(true);
	Condition condition;

	public Worker() {
		condition = lock.newCondition();
	}

	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("Producer is running....");
		condition.await();
		System.out.println("Producer is running again....");
		lock.unlock();
	}

	public void consumer() throws InterruptedException {
		lock.lock();
		Thread.sleep(500);
		System.out.println("Consumer is running....");
		condition.signalAll();
		lock.unlock();
	}
}

public class ReentrantLockLevel1 {

	public static void main(String[] args) {
		Worker worker = new Worker();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						worker.producer();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						worker.consumer();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}

}
