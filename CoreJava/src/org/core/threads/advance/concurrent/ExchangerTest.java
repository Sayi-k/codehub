package org.core.threads.advance.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExchangerTest {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		Lock lock = new ReentrantLock();
		new Thread(new FirstThread(exchanger, lock), "First").start();
		new Thread(new SecondThread(exchanger, lock), "Second").start();
	}
}

class FirstThread implements Runnable {
	Exchanger<String> exchanger;
	Lock lock;

	public FirstThread(Exchanger<String> exchanger, Lock lock) {
		this.exchanger = exchanger;
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName() + " - " + "running...");
				String pass1 = "FirstThread says Hi...";
				String message = exchanger.exchange(pass1);
				System.out.println(message);
				System.out.println(Thread.currentThread().getName() + " - " + "finishing...");
				lock.unlock();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class SecondThread implements Runnable {
	Exchanger<String> exchanger;
	Lock lock;

	public SecondThread(Exchanger<String> exchanger, Lock lock) {
		this.exchanger = exchanger;
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				// lock.lock();
				System.out.println(Thread.currentThread().getName() + " - " + "running...");
				String pass2 = "SecondThread says Hi...";
				String message = exchanger.exchange(pass2);
				System.out.println(message);
				System.out.println(Thread.currentThread().getName() + " - " + "finishing...");
				// lock.unlock();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
