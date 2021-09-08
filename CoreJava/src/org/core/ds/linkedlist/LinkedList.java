package org.core.ds.linkedlist;

public class LinkedList {

	Node head;
	
	public void insertFirst(int data) {
		Node node = getNewNode(data);
		node.next = head;
		head = node;
	}
	
	public void insert(int data) {
		Node node = getNewNode(data);
		Node n = head;
		if(n==null) {
			head = node;
			return;
		}
		while(n.next!=null) {
			n = n.next;
		}
		n.next = node;
	}
	
	public void insertAt(int index, int data){
		Node node = getNewNode(data);
		Node n = head;
		if(n==null) {
			head = node;
			return;
		}
		for(int i=0; i<index-1; i++) {
			n = n.next;
		}
		node.next = n.next;
		n.next = node;
	}
	
	public void show() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.println();
	}
	
	public void delete(int index) {
		Node n = head;
		if(n!=null) {
			for(int i=0; i<index-1; i++) {
				n = n.next;
			}
			if(n.next == null) {
				head = null;
			}
			n.next = n.next.next;
		}
	}

	private Node getNewNode(int data) {
		Node node = new Node();
		node.data = data;
		return node;
	}
}
