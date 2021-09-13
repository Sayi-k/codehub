package org.core.threads.basic;

public class SynchronizationMethodTest {
	static int count = 0;

	public static synchronized void increment() {
		count++;
	}

	public static void process() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					increment();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					increment();
				}
			}

		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended");
	}

	public static void main(String[] args) throws InterruptedException {
		long time1 = System.currentTimeMillis();
		System.out.println(time1);
		process();
		long time2 = System.currentTimeMillis();
		System.out.println(time2);
		System.out.println(count + ": Time taken =" + (time2 - time1));
	}

}
