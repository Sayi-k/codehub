package org.core.ds.queue;

public class Queue {

	int max = 5;
	int[] queue = new int[max];
	int front, rear;
	int size;
	
	public void enQueue(int data) {
		if(size != max) {
			queue[rear] = data;
			rear = (rear+1)%max;
			size++;
		}
		else {
			System.out.println("Queue is full");
		}
	}
	
	public int deQueue() {
		if(size == 0 ) {
			System.out.println("Queue is empty");
			return 0;
		}
		int data = queue[front];
		front = (front+1)%max;
		size--;
		return data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void show() {
		int start = front;
		System.out.println("Front: "+front+" Rear: "+rear);
		for(int i=0; i<size; i++) {
			System.out.print(queue[start++]+"->");
		}
	}
}
