package org.core.base.linkedlist;

public class DetectLoop {

	public static void main(String[] args) {
		Node node = new Node(1);
		DetectFirstNodeLoopList list = new DetectFirstNodeLoopList(node);
		Node head = list.head;
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = head.next.next;
		list.detectLoop(head);
	}
}

class DetectLoopList {
	Node head;

	public DetectLoopList(Node head) {
		this.head = head;
	}

	public void detectLoop(Node head) {
		Node slow = head, fast = head;
		while (null != slow && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Loop detected");
				return;
			}
		}
		System.out.println("No loop detected");
	}
}