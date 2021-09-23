package org.core.base.fun;

public class ThreadTest implements Runnable {

	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		t.call();
	}

	public void call() {
		Thread t1 = new Thread(this);
		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Thread Test");
	}

}
