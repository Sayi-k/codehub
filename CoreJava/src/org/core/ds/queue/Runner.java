package org.core.ds.queue;

public class Runner {

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(40);
		q.enQueue(50);
		q.enQueue(60);
		q.show();
		System.out.println("\nDequeue = "+q.deQueue());
		q.show();
		System.out.println("\nDequeue = "+q.deQueue());
		q.show();
		System.out.println("\nDequeue = "+q.deQueue());
		q.show();
		System.out.println("\nDequeue = "+q.deQueue());
		q.show();
		System.out.println("\nDequeue = "+q.deQueue());
		q.show();
		System.out.println("\nDequeue = "+q.deQueue());
		q.show();
	}

}
