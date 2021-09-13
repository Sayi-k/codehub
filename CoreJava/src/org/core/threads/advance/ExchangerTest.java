package org.core.threads.advance;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		Thread prod = new Thread(new Producer(exchanger));
		Thread cons = new Thread(new Consumer(exchanger));
		prod.start();
		cons.start();
	}

}

class Producer implements Runnable {
	Exchanger<String> exchanger;

	public Producer(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		String str = "Hello";
		try {
			System.out.println("Entered Producer");
			Thread.sleep(3000);
			String result = exchanger.exchange(str);
			System.out.println("Producer is running = " + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	Exchanger<String> exchanger;

	public Consumer(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		String str = "Hi";
		try {
			System.out.println("Entered Consumer");
			Thread.sleep(3000);
			String result = exchanger.exchange(str);
			System.out.println("Consumer is running = " + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
