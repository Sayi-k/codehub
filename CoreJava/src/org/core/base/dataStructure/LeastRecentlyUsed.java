package org.core.base.dataStructure;

import java.util.HashMap;

public class LeastRecentlyUsed {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		cache.set(1, 10);
		cache.set(2, 20);
		cache.set(3, 30);
		cache.set(4, 40);
		cache.set(5, 50);
		cache.display();
		cache.get(3);
		System.out.println("After getting 3");
		cache.display();
		System.out.println("After setting 6");
		cache.set(6, 60);
		cache.display();
	}
}

class Node {
	int key;
	int value;
	Node prev;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class LRUCache {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public void display() {
		Node node = head;
		while (null != node) {
			System.out.print("[" + node.key + "," + node.value + "]->");
			node = node.next;
		}
		System.out.println();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			setHead(node);
		} else {
			Node newNode = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(newNode);
			} else {
				setHead(newNode);
			}
			map.put(key, newNode);
		}
	}

	public void setHead(Node node) {
		node.next = head;
		node.prev = null;
		if (null != head) {
			head.prev = node;
		}
		head = node;
		if (end == null) {
			end = head;
		}
	}

	public void remove(Node node) {
		if (null != node.prev) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}
		if (null != node.next) {
			node.next.prev = node.prev;
		} else {
			end = node.prev;
		}
	}
}