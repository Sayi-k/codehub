package org.core.threads.basic;

public class SynchTest {
	public static void main(String[] args) throws InterruptedException {
		Person p = new Person();
		Person p1 = new Person();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() throws RuntimeException {
				p.getName();
			}

		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				p.getAddress();
			}

		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(p.age);
	}
}

class Person {
	volatile int age = 32;

	public synchronized void getName() {
		System.out.println("Name is");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Rohan " + age);
		age = 30;
	}

	public synchronized void getAddress() {
		System.out.println("Address is");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Bangalore " + age);
	}
}
