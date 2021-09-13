package org.core.threads.basic;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumerLevel1 {
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int maxSize = 2;

	public static void main(String[] args) {
		System.out.println("Thread started.... The max size is " + maxSize);

		Thread producer = new Thread(new Producers(queue, maxSize), "Producer");
		Thread consumer = new Thread(new Consumers(queue), "Consumer");

		producer.start();
		consumer.start();
	}

}

class Producers implements Runnable {
	Queue<Integer> queue;
	int maxSize;

	public Producers(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println("Produced... " + i);
			try {
				produce(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void produce(int i) throws InterruptedException {
		while (queue.size() == maxSize) {
			synchronized (queue) {
				System.out.println("Thread " + Thread.currentThread().getName()
						+ " is waiting bec Queue is full with size = " + queue.size());
				queue.wait();
			}
		}
		synchronized (queue) {
			queue.add(i);
			System.out.println("Producer Queue elements = " + queue + " size = " + queue.size());
			queue.notifyAll();
		}
	}

}

class Consumers implements Runnable {
	Queue<Integer> queue;

	public Consumers(Queue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consuming... " + consume());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private int consume() throws InterruptedException {
		while (queue.isEmpty()) {
			synchronized (queue) {
				System.out.println("Thread " + Thread.currentThread().getName()
						+ " is waiting bec Queue is empty with size = " + queue.size());
				queue.wait();
			}
		}
		synchronized (queue) {
			queue.notifyAll();
			int x = queue.remove();
			System.out.println("Consumer Queue elements = " + queue + " size = " + queue.size());
			return x;
		}
	}

}
