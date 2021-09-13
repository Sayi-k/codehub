package org.core.threads.basic;

import java.text.SimpleDateFormat;

public class ThreadLocalExample {

	public static void main(String[] args) throws InterruptedException {
		ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
			@Override
			public SimpleDateFormat initialValue() {
				return new SimpleDateFormat("dd/yy HH:mm");
			}
		};
		threadLocal.set(new SimpleDateFormat("mm/dd/yy HH:mm"));
		System.out.println("Main Thread " + Thread.currentThread().getName() + " has default formatter "
				+ threadLocal.get().toPattern());
		for (int i = 0; i < 6; i++) {
			Thread t = new Thread(new MyThread(threadLocal), "" + i);
			Thread.sleep(1000);
			t.start();
		}
	}

}

class MyThread implements Runnable {
	ThreadLocal<SimpleDateFormat> threadLocal;

	public MyThread(ThreadLocal<SimpleDateFormat> threadLocal) {
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " has default formatter "
				+ threadLocal.get().toPattern());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadLocal.set(new SimpleDateFormat());
		System.out.println("Thread " + Thread.currentThread().getName() + " has changed formatter "
				+ threadLocal.get().toPattern());
	}

}
