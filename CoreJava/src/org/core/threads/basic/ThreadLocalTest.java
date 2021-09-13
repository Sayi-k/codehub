package org.core.threads.basic;

public class ThreadLocalTest extends Thread {
	static Integer num = new Integer(10);
	static ThreadLocal<Integer> threadLocalNum = new ThreadLocal<Integer>();

	public static void main(String[] args) {

		Thread t1 = new ThreadLocalTest();
		Thread t2 = new ThreadLocalTest();
		Thread t3 = new ThreadLocalTest();

		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		num = (int) (Math.random() * 10);
		threadLocalNum.set(num);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num + " - " + threadLocalNum.get());
	}

}
