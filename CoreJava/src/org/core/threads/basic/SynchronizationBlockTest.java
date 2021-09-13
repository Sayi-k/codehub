package org.core.threads.basic;

public class SynchronizationBlockTest {
	public int count = 0;

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public void add() throws InterruptedException {
		synchronized (lock1) {
			for (int i = 0; i < 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" - add");
				System.out.println(count);
				Thread.sleep(500);
			}
		}
	}

	public void addAgain() throws InterruptedException {
		synchronized (lock2) {
			for (int i = 0; i < 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" - addAgain");
				System.out.println(count);
				Thread.sleep(500);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizationBlockTest test = new SynchronizationBlockTest();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					test.add();
					test.addAgain();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					test.add();
					test.addAgain();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		//long time1 = System.currentTimeMillis();
		//System.out.println(time1);
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();

		t1.join();
		t2.join();
		//long time2 = System.currentTimeMillis();
		//System.out.println(time2);
		//System.out.println(test.count + ": Time taken =" + (time2 - time1));
	}

}
