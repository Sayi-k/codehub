package org.core.threads.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerAndConsumer {

	public static void main(String[] args) {
		System.out.println("How to use wait and notify method in Java");
		System.out.println("Solving Producer Consumper Problem");
		Queue<Integer> buffer = new LinkedList<>();
		int maxSize = 3;
		int runFor = 12;
		Check check = new Check();

		Thread producer = new Producer(buffer, maxSize, "PRODUCER", check);
		Thread consumer = new Consumer(buffer, maxSize, "PRODUCER", check);

		producer.start();
		consumer.start();
	}

}

class Producer extends Thread {
	private Queue<Integer> queue;
	private int maxSize;
	private Check runCheck;

	public Producer(Queue<Integer> q, int ms, String name, Check check) {
		super(name);
		queue = q;
		maxSize = ms;
		runCheck = check;
	}

	@Override
	public void run() {
		synchronized (queue) {
			while (0 < runCheck.runFor) {
				while (queue.size() == maxSize) {
					try {
						System.out.println("Queue is full, " + "Producer thread waiting for "
								+ "consumer to take something from queue --- ");
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				runCheck.runFor = runCheck.runFor - 1;
				System.out.print("Run for = " + runCheck.runFor + " --- ");
				System.out.print("Random number generating --- ");
				Random random = new Random();
				int i = random.nextInt();
				System.out.println("Producing value : " + i);
				queue.add(i);
				queue.notifyAll();
			}
		}
	}
}

class Consumer extends Thread {
	private Queue<Integer> queue;
	private int maxSize;
	private Check runCheck;

	public Consumer(Queue<Integer> queue, int maxSize, String name, Check check) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
		runCheck = check;
	}

	@Override
	public void run() {

		synchronized (queue) {
			while (0 < runCheck.runFor) {
				while (queue.isEmpty()) {
					System.out.println("Queue is empty," + "Consumer thread is waiting"
							+ " for producer thread to put something in queue --- ");
					try {
						queue.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				runCheck.runFor = runCheck.runFor - 1;
				System.out.print("Run for = " + runCheck.runFor + " --- ");
				System.out.print("In Consume --- ");
				System.out.println("Consuming value : " + queue.remove());
				queue.notifyAll();
			}
		}
	}

}

class Check {
	volatile int runFor = 12;
}