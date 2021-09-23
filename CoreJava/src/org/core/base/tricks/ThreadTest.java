package org.core.base.tricks;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main");
		//Thread.currentThread().join();
		Thread t = Thread.currentThread();
		t.start();
		System.out.println("Main end");
	}
}

class Test implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside thread");
	}

}