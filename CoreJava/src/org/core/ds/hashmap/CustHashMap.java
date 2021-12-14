package org.core.ds.hashmap;

public class CustHashMap<K, V> {

	private int capacity = 16;
	private Entry<K, V>[] table;

	public CustHashMap() {
		table = new Entry[capacity];
	}

	public CustHashMap(int size) {
		this.capacity = size;
		table = new Entry[capacity];
	}

	public int findIndex(K key) {
		if (key != null) {
			return Math.abs(key.hashCode() % capacity);
		}
		return 0;
	}

	public void put(K key, V value) {
		int index = findIndex(key);
		Entry<K, V> newNode = new Entry<K, V>(key, value, null);
		if (table[index] == null) {
			table[index] = newNode;
		} else {
			Entry<K, V> currentNode = table[index];
			Entry<K, V> prevNode = null;
			while (currentNode != null) {
				if (currentNode.getKey().equals(key)) {
					currentNode.setValue(value);
					prevNode = null;
					break;
				}
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
			if (prevNode != null) {
				prevNode.setNext(newNode);
			}
		}
	}

	public V get(K key) {
		int index = findIndex(key);
		Entry<K, V> node = table[index];
		while (node != null) {
			if (node.getKey().equals(key)) {
				return node.getValue();
			}
			node = node.getNext();
		}
		return null;
	}

	public void remove(K key) {
		int index = findIndex(key);
		Entry<K, V> currentNode = table[index];
		Entry<K, V> prevNode = null;
		while (currentNode != null) {
			if (currentNode.getKey().equals(key)) {
				/* First Node in table */
				if (prevNode == null) {
					table[index] = currentNode.getNext();
				} else {
					prevNode.setNext(currentNode.getNext());
				}
				break;
			}
			prevNode = currentNode;
			currentNode = currentNode.getNext();
		}
	}

	public void display() {
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				Entry<K, V> currentNode = table[i];
				while (currentNode != null) {
					System.out.println(
							String.format("Key is %s and value is %s", currentNode.getKey(), currentNode.getValue()));
					currentNode = currentNode.getNext();
				}
			}
		}
	}
}
