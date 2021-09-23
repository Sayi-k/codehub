package org.core.base.linkedlist;

public class MidleOfLinkedList {

	public static void main(String[] args) {
		LinkedList link = new LinkedList();
		Node head = new Node(1);
		link.addToEnd(head);
		link.addToEnd(new Node(2));
		link.addToEnd(new Node(3));
		link.addToEnd(new Node(4));
		link.addToEnd(new Node(5));

		link.printAll();
		Node middle = link.findMiddle(head);
		System.out.println();
		System.out.println("Middle element is : " + middle.data);
	}
}

class LinkedList {

	private Node head;

	public void addToEnd(Node node) {
		if (null == head) {
			head = node;
		} else {
			Node temp = head;
			while (null != temp.next) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}

	public void printAll() {
		Node temp = head;
		while (null != temp) {
			System.out.print(temp.data + "-");
			temp = temp.next;
		}
	}

	public Node findMiddle(Node head) {
		Node fast, slow;
		fast = slow = head;
		while (null != fast) {
			fast = fast.next;
			if (null != fast && null != fast.next) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return slow;
	}
}
