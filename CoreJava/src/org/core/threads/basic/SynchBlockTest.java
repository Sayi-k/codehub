package org.core.threads.basic;

public class SynchBlockTest {

	public static void main(String[] args) {
		One one = new One();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					one.doOne();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					One.doTwo();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		t1.start();
		t2.start();
	}
}

class One {

	public void doOne() throws InterruptedException {
		synchronized (One.class) {
			System.out.println("DoOne");
			Thread.sleep(2000);
		}

	}

	public static synchronized void doTwo() throws InterruptedException {
		// synchronized (new Temp()) {
		System.out.println("DoTwo");
		Thread.sleep(2000);
		// }

	}
}

class Temp {

}
