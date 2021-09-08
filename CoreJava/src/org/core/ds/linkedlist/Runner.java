package org.core.ds.linkedlist;

public class Runner {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.show();
		list.insertFirst(5);
		list.show();
		list.insertAt(2, 15);
		list.show();
		list.delete(2);
		list.show();
		list.delete(4);
		list.show();
	}
}
